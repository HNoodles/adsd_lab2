package fd.adsd.report.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskResponse {
    private String workNum;
    private int status;

    public TaskResponse() {
    }

    public TaskResponse(String workNum, int status) {
        this.workNum = workNum;
        this.status = status;
    }
}
