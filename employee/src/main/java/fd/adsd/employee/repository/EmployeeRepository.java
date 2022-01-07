package fd.adsd.employee.repository;

import fd.adsd.employee.entiry.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Long> {
    Employee findByWorkNum(String workNum);
}
