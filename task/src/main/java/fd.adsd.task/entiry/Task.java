package fd.adsd.task.entiry;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String workNum;
    private String content;
    private int status;

    public Task() {
    }

    public Task(String workNum, String content, int status) {
        this.workNum = workNum;
        this.content = content;
        this.status = status;
    }
}
