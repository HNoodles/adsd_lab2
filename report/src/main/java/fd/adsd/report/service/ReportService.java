package fd.adsd.report.service;

import fd.adsd.report.dto.*;
import fd.adsd.report.entiry.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ReportService {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private TaskService taskService;


    public List<Report> allDeptReport(){
        EmployeeDeptList employeeDepts = employeeService.allEmployeeDept().getData();

        List<Report> reports = new ArrayList<>();
        if (employeeDepts != null) {
            Map<String,Integer> deptNum = new HashMap<>();
            Map<String,Integer> deptFinish = new HashMap<>();
            for (EmployeeDept employeeDept:employeeDepts.getEmployeeDepts()){
                TaskResponseList tasks = taskService.getTaskNum(employeeDept.getWorkNum()).getData();
                assert tasks != null;
                for(TaskResponse response:tasks.getTasks()){
                    if(response.getStatus()==1){
                        if (deptFinish.containsKey(employeeDept.getDept())){
                            deptFinish.put(employeeDept.getDept(),deptFinish.get(employeeDept.getDept()) + 1);
                        }
                        else{
                            deptFinish.put(employeeDept.getDept(),1);
                        }
                    }
                }
                if (deptNum.containsKey(employeeDept.getDept())){
                    deptNum.put(employeeDept.getDept(),deptNum.get(employeeDept.getDept()) + tasks.getTasks().size());
                }
                else{
                    deptNum.put(employeeDept.getDept(),tasks.getTasks().size());
                }
            }
            for (String dept:deptNum.keySet()){
                int finished = deptFinish.get(dept)==null?0:deptFinish.get(dept);
                reports.add(new Report(dept,deptNum.get(dept),finished));
            }
        }

        return reports;
    }
}
