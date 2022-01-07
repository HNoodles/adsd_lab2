package fd.adsd.employee.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotifyRegisterInfo {
    private String username;
    private String password;
    private String email;

    public NotifyRegisterInfo() {
    }

    public NotifyRegisterInfo(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
