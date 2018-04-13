package scudder.automaint.services;

import scudder.automaint.domain.Vehicle;

public interface VehicleService {
	Iterable<Vehicle> listAllVehicles();
	
	Vehicle getVehicleById(Integer id);
	
	Vehicle saveVehicle(Vehicle vehicle);
	
	void deleteVehicle(Integer id);
}
