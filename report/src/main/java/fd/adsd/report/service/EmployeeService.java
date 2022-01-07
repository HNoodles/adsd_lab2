package fd.adsd.report.service;

import fd.adsd.report.dto.BaseResponse;
import fd.adsd.report.dto.EmployeeDept;
import fd.adsd.report.dto.EmployeeDeptList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "employee",url = "employee:6782/api/employee/")
public interface EmployeeService {
    @GetMapping("/depts")
    BaseResponse<EmployeeDeptList> allEmployeeDept();
}
