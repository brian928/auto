package scudder.automaint.bootstrap;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import scudder.automaint.domain.Vehicle;
import scudder.automaint.repositories.VehicleRepository;
import scudder.automaint.domain.Maintenance;
import scudder.automaint.repositories.MaintenanceRepository;

@Component
public class VehicleLoader implements ApplicationListener<ContextRefreshedEvent>{

    private VehicleRepository vehicleRepository;
    private MaintenanceRepository maintenanceRepository;
    
    private Logger log = Logger.getLogger(VehicleLoader.class);

    @Autowired
    public void setVehicleRepository(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }
    
    @Autowired
    public void setMaintenanceRepository(MaintenanceRepository maintenanceRepository) {
        this.maintenanceRepository = maintenanceRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Vehicle porsche = new Vehicle();
        porsche.setYear(1987);
        porsche.setMake("Porsche");
        porsche.setModel("928s4");
        porsche.setDescription("Blue Car");
        porsche.setOdometer((long)57800);
        
        Maintenance p1 = new Maintenance();
        // p1.setDate(new Date());
        p1.setLocation("Sams");
        p1.setOdometer((long)58000);
        p1.setGallons(new BigDecimal("15.25"));
        p1.setPrice(new BigDecimal("2.39"));
        maintenanceRepository.save(p1);
        
        Maintenance p2 = new Maintenance();
        // p1.setDate(now);
        p2.setLocation("Lone Star");
        p2.setOdometer((long)58000);
        p2.setGallons(new BigDecimal("12.00"));
        p2.setPrice(new BigDecimal("1.99"));       
        maintenanceRepository.save(p2);
        
     /*    List<Maintenance> maintList = porsche.getMaintenanceList(); 		
        if (maintList == null) {
        	log.info("maintList is null: ");
        } 
        else if (maintList.isEmpty()) {
        	log.info("maintList is empty: ");
        	
        }
        */
        
        List<Maintenance> maintList = new ArrayList<Maintenance>();
        maintList.add(p1);
        maintList.add(p2);
        porsche.setMaintenanceList(maintList);
        
        // porsche.setMaintenanceList(maintList);
        
        vehicleRepository.save(porsche);
        log.info("Saved porsche - id: " + porsche.getId());
        
        Vehicle ford = new Vehicle();
        ford.setYear(2011);
        ford.setMake("Ford");
        ford.setModel("Flex");
        ford.setDescription("Family Hauler");
        ford.setOdometer((long)2500);
        vehicleRepository.save(ford);

        
        log.info("Saved ford - id: " + ford.getId());
        Maintenance f1 = new Maintenance();
        // f1.setDate(now);
        f1.setLocation("FordSams");
        f1.setOdometer((long)58000);
        f1.setGallons(new BigDecimal("15.25"));
        f1.setPrice(new BigDecimal("2.39"));
        maintenanceRepository.save(f1);
        
        Maintenance f2 = new Maintenance();
        // f2.setDate(now);
        f2.setLocation("Ford Lone Star");
        f2.setOdometer((long)58000);
        f2.setGallons(new BigDecimal("12.00"));
        f2.setPrice(new BigDecimal("1.99"));
        maintenanceRepository.save(f2);
       
        
    }
}
