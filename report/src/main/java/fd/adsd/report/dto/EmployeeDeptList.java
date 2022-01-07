package fd.adsd.report.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class EmployeeDeptList {
    private List<EmployeeDept> employeeDepts;

    public EmployeeDeptList() {
        this.employeeDepts = new ArrayList<>();
    }
}
