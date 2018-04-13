package scudder.automaint.services;

import scudder.automaint.domain.Vehicle;
import scudder.automaint.repositories.VehicleRepository;
import scudder.automaint.domain.Maintenance;
import scudder.automaint.repositories.MaintenanceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VehicleServiceImpl implements VehicleService {
	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Autowired
	private MaintenanceRepository maintenanceRepository;
	
	public void setVehicleRepository(VehicleRepository vehicleRepository,
			                         MaintenanceRepository maintenanceRepository) {
		this.vehicleRepository = vehicleRepository;
		this.maintenanceRepository = maintenanceRepository;
	}
	
	
	@Override
	public Iterable<Vehicle> listAllVehicles() {
		return vehicleRepository.findAll();
	}
	
	@Override
	public Vehicle getVehicleById(Integer id) {
		return vehicleRepository.findOne(id);
	}
	
	@Override
	public Vehicle saveVehicle(Vehicle vehicle) {
		// something with maint
		maintenanceRepository.save(vehicle.getMaintenanceList());
		return vehicleRepository.save(vehicle);
	}
	
	@Override
	public void deleteVehicle(Integer id) {
		vehicleRepository.delete(id);
	}

}
