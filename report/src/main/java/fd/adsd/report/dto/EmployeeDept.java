package fd.adsd.report.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDept {
    private String workNum;
    private String dept;

    public EmployeeDept() {
    }

    public EmployeeDept(String workNum, String dept) {
        this.workNum = workNum;
        this.dept = dept;
    }
}
