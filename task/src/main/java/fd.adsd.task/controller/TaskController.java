package fd.adsd.task.controller;

import fd.adsd.task.dto.BaseResponse;
import fd.adsd.task.dto.CreateTaskRequest;
import fd.adsd.task.dto.TaskResponse;
import fd.adsd.task.dto.TaskResponseList;
import fd.adsd.task.entiry.Task;
import fd.adsd.task.service.TaskService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task/")
@Api(tags = "任务管理")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/tasks")
    @ApiOperation("新建任务")
    public BaseResponse<Task> createTask(@RequestBody CreateTaskRequest request){
        return new BaseResponse<>(taskService.createTask(request));
    }

    @PutMapping("/tasks/{taskId}")
    @ApiOperation("完成任务")
    public BaseResponse<Task> finishTask(@PathVariable Long taskId){
        return new BaseResponse<>(taskService.finishTask(taskId));
    }

    @GetMapping("/tasks/{workNum}")
    @ApiOperation("获取员工任务")
    public BaseResponse<List<Task>> getTasks(@PathVariable String workNum){
        return new BaseResponse<>(taskService.getTasks(workNum),"success");
    }

    @PostMapping("/register/{workNum}")
    @ApiOperation("注册新增任务")
    public BaseResponse<Task> register(@PathVariable String workNum){
        return new BaseResponse<>(taskService.register(workNum));
    }

    @PutMapping("/changePass/{workNum}")
    @ApiOperation("完成修改密码任务")
    public BaseResponse<Task> changePass(@PathVariable String workNum){
        return new BaseResponse<>(taskService.changePass(workNum));
    }

    @GetMapping("/taskNum/{workNum}")
    @ApiOperation("获取员工任务数量")
    public BaseResponse<TaskResponseList> getTaskNum(@PathVariable String workNum){
        TaskResponseList list = new TaskResponseList();
        list.setTasks(taskService.getTaskNum(workNum));
        return new BaseResponse<>(list,"success");
    }
}
