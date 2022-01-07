package fd.adsd.employee.service;

import fd.adsd.employee.config.Queues;
import fd.adsd.employee.dto.*;
import fd.adsd.employee.entiry.Employee;
import fd.adsd.employee.repository.EmployeeRepository;
import fd.adsd.employee.utils.JsonUtils;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public RegisterResponse register(RegisterRequest request){
        Employee employee = employeeRepository.findByWorkNum(request.getWorkNum());
        if(employee != null)
            return null;
        String pass = makeRandomPassword(10);
        employee = new Employee(request.getName(),request.getWorkNum(),pass, request.getEmail(), request.getDept());
        employeeRepository.save(employee);
        NotifyRegisterInfo info = new NotifyRegisterInfo(request.getWorkNum(),pass,request.getEmail());
        notifyRegister(info);
        return new RegisterResponse(request.getWorkNum(),pass);
    }

    public String changeDept(ChangeDeptRequest request){
        Employee employee = employeeRepository.findByWorkNum(request.getWorkNum());
        employee.setDept(request.getNewDept());
        employeeRepository.save(employee);
        return "success";
    }

    public void notifyRegister(NotifyRegisterInfo info){
        String infoJson = JsonUtils.object2Json(info);
        rabbitTemplate.convertAndSend(Queues.queueRegister,infoJson);
    }

    public String makeRandomPassword(int len){
        char[] charr = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        for (int x = 0; x < len; ++x) {
            sb.append(charr[r.nextInt(charr.length)]);
        }
        return sb.toString();
    }

    public List<EmployeeDept> allEmployeeDept(){
        List<Employee> employees = (List<Employee>) employeeRepository.findAll();
        List<EmployeeDept> depts = new ArrayList<>();
        for (Employee employee:employees){
            EmployeeDept employeeDept = new EmployeeDept(employee.getWorkNum(),employee.getDept());
            System.out.println(employee.getWorkNum());
            depts.add(employeeDept);
        }
        return depts;
    }
}
