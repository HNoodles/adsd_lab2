package fd.adsd.employee.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangeDeptRequest {
    private String workNum;
    private String newDept;

}
