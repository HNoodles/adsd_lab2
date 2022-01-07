package fd.adsd.report.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class TaskResponseList {
    private List<TaskResponse> tasks;

    public TaskResponseList() {
        tasks = new ArrayList<>();
    }
}
