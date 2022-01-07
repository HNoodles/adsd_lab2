package fd.adsd.user.service;

import fd.adsd.user.config.Queues;
import fd.adsd.user.dto.ChangePassRequest;
import fd.adsd.user.dto.LoginRequest;
import fd.adsd.user.dto.RegisterRequest;
import fd.adsd.user.entity.User;
import fd.adsd.user.repository.UserRepository;
import fd.adsd.user.utils.JsonUtils;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;

    private static final String TASK_URL_PREFIX = "http://task:6783/api/task/";

    public String register(RegisterRequest request){
        User user = new User(request.getUsername(),request.getPassword(),request.getEmail());
        userRepository.save(user);
        Map<String, String> params = new HashMap<>();
        params.put("workNum",user.getUsername());
        restTemplate.postForObject(TASK_URL_PREFIX+"register/{workNum}",null,String.class,params);
        return "success";
    }

    public String login(LoginRequest request){
        User user = userRepository.findByUsername(request.getUsername());
        if(user==null)
            return "用户不存在";
        if(!request.getPassword().equals(user.getPassword()))
            return "密码错误";
        return "success";
    }

    public String changePass(ChangePassRequest request){
        User user = userRepository.findByUsername(request.getUsername());
        user.setPassword(request.getNewPass());
        if (user.getStatus()==0){
            user.setStatus(1);
            Map<String, String> params = new HashMap<String, String>();
            params.put("workNum",user.getUsername());
            restTemplate.put(TASK_URL_PREFIX+"changePass/{workNum}",null,params);
        }
        userRepository.save(user);
        return "success";
    }

    @RabbitListener(queues=Queues.queueRegister)
    public void processRegister(String infoJson){
        RegisterRequest request = JsonUtils.json2Object(infoJson,RegisterRequest.class);
        register(request);
    }
}
