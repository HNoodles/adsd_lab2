package fd.adsd.employee.controller;

import fd.adsd.employee.dto.*;
import fd.adsd.employee.entiry.Employee;
import fd.adsd.employee.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
@Api(tags = "员工管理")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/register")
    @ApiOperation("员工注册")
    public BaseResponse<RegisterResponse> register(@RequestBody RegisterRequest request){
        RegisterResponse response = employeeService.register(request);
        if (response==null)
            return new BaseResponse<>("员工已注册");
        return new BaseResponse<>(response,"success");
    }

    @PutMapping("/dept")
    @ApiOperation("员工更改部门")
    public BaseResponse<Employee> changeDept(@RequestBody ChangeDeptRequest request){
        return new BaseResponse<>(employeeService.changeDept(request));
    }

    @GetMapping("/depts")
    @ApiOperation("获取所有员工部门")
    public BaseResponse<EmployeeDeptList> allEmployeeDept(){
        EmployeeDeptList list = new EmployeeDeptList();
        list.setEmployeeDepts(employeeService.allEmployeeDept());
        return new BaseResponse<>(list,"success");
    }
}
