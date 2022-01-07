package fd.adsd.task.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateTaskRequest {
    private String workNum;
    private String content;

}
