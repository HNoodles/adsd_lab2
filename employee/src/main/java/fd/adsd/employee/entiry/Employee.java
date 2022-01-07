package fd.adsd.employee.entiry;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @Column(unique = true)
    private String workNum;
    private String password;
    private String email;
    private String dept;

    public Employee() {
    }

    public Employee(String name, String workNum, String password, String email, String dept) {
        this.name = name;
        this.workNum = workNum;
        this.password = password;
        this.email = email;
        this.dept = dept;
    }
}
