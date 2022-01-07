package fd.adsd.task.repository;

import fd.adsd.task.entiry.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends CrudRepository<Task,Long> {
    Task findByWorkNumAndContent(String workNum,String content);
    List<Task> findAllByWorkNum(String workNum);
}
