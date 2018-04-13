package scudder.automaint.domain;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vehicle")
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Version
	private Integer version;
	
    	private Integer year;
	    private String make;
	    private String model;
	    private String description;
	    private Long odometer;
	    
	    @OneToMany(cascade = CascadeType.ALL)
	    private List<Maintenance> maintenanceList;
	    
	    public Integer getId() {
	    	return id;
	    }
	    public void setId(Integer id) {
	    	this.id = id;
	    }
	    
	    public Integer getVersion() {
	    	return version;
	    }
	    public void setVersion(Integer version) {
	    	this.version = version;
	    }
	    
	    public String getMake() {
	    	return make;
	    }
	    public void setMake(String make) {
	    	this.make = make;
	    }
	    
	    public String getModel() {
	    	return model;
	    }
	    public void setModel(String model) {
	    	this.model = model;
	    }
	    
	    public Integer getYear() {
	    	return year;
	    }
	    public void setYear(Integer year) {
	    	this.year = year;
	    }
	    
	    public String getDescription() {
	    	return description;
	    }
	    public void setDescription(String description) {
	    	this.description = description;
	    }
	    
	    public Long getOdometer() {
	    	return odometer;
	    }
	    public void setOdometer(Long odometer) {
	    	this.odometer = odometer;
	    }
	    
	    public List<Maintenance> getMaintenanceList() {
	        return maintenanceList;
	    }

	    public void setMaintenanceList(List<Maintenance> maintenanceList) {
	        this.maintenanceList = maintenanceList;
	    }

}
