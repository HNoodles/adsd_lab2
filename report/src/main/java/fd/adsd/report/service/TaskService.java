package fd.adsd.report.service;

import fd.adsd.report.dto.BaseResponse;
import fd.adsd.report.dto.TaskResponse;
import fd.adsd.report.dto.TaskResponseList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "task",url = "localhost:6783/api/task/")
public interface TaskService {
    @GetMapping("/taskNum/{workNum}")
    BaseResponse<TaskResponseList> getTaskNum(@PathVariable String workNum);
}
