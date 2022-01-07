package fd.adsd.employee.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterResponse {
    private String username;
    private String password;

    public RegisterResponse() {
    }

    public RegisterResponse(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
