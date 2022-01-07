package fd.adsd.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangePassRequest {
    private String username;
    private String newPass;
}
