package fd.adsd.task.service;

import fd.adsd.task.dto.CreateTaskRequest;
import fd.adsd.task.dto.TaskResponse;
import fd.adsd.task.entiry.Task;
import fd.adsd.task.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public String register(String workNum){
        Task task = new Task(workNum,"更改密码",0);
        taskRepository.save(task);
        return "success";
    }

    public String changePass(String workNum){
        Task task = taskRepository.findByWorkNumAndContent(workNum,"更改密码");
        task.setStatus(1);
        taskRepository.save(task);
        return "success";
    }

    public String createTask(CreateTaskRequest request){
        Task task = new Task(request.getWorkNum(),request.getContent(),0);
        taskRepository.save(task);
        return "success";
    }

    public String finishTask(Long taskId){
        Task task = taskRepository.findById(taskId).get();
        task.setStatus(1);
        taskRepository.save(task);
        return "success";
    }

    public List<Task> getTasks(String workNum){
        return taskRepository.findAllByWorkNum(workNum);
    }

    public List<TaskResponse> getTaskNum(String workNum){
        List<Task> tasks = taskRepository.findAllByWorkNum(workNum);
        List<TaskResponse> responses = new ArrayList<>();
        for (Task task:tasks){
            TaskResponse response = new TaskResponse(task.getWorkNum(),task.getStatus());
            responses.add(response);
        }
        return responses;
    }
}
