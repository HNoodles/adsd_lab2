package fd.adsd.report.entiry;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dept;
    private int taskNum;
    private int finished;

    public Report() {
    }

    public Report(String dept, int taskNum,int finished) {
        this.dept = dept;
        this.taskNum = taskNum;
        this.finished = finished;
    }
}
