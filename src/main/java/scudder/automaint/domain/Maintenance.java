package scudder.automaint.domain;

import javax.persistence.*;
import java.util.Date;
import java.math.BigDecimal;

@Entity
@Table(name = "maintenance")
public class Maintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    private Date date;
    private String location;
    private Long odometer;
    private BigDecimal gallons;
    private BigDecimal price;
    
 //   @ManyToOne(fetch = FetchType.LAZY)
 //   @JoinColumn(name = "vehicle_id")
 //   private Vehicle vehicle;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Date getdate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
   
    public Long getOdometer() {
        return odometer;
    }

    public void setOdometer(Long odometer) {
        this.odometer = odometer;
    }
 
    public BigDecimal getGallons() {
        return gallons;
    }
    public void setGallons(BigDecimal gallons) {
        this.gallons = gallons;
    }

    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    
}
