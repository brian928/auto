package scudder.automaint.repositories;

import scudder.automaint.domain.Vehicle;
import org.springframework.data.repository.CrudRepository;

public interface VehicleRepository extends CrudRepository<Vehicle, Integer>{
}
