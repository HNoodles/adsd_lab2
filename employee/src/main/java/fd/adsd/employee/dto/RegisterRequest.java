package fd.adsd.employee.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
    private String name;
    private String workNum;
    private String dept;
    private String email;
}
