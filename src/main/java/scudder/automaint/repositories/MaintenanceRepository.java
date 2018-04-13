package scudder.automaint.repositories;

import scudder.automaint.domain.Maintenance;
import org.springframework.data.repository.CrudRepository;

public interface MaintenanceRepository extends CrudRepository<Maintenance, Integer> {
}



