package fd.adsd.report.repository;

import fd.adsd.report.entiry.Report;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends CrudRepository<Report,Long> {
}
