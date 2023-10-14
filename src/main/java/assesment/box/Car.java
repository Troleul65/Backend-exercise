package assesment.box;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@DiscriminatorValue("car")
@Table(name="Car")
public class Car extends Vehicle{
    @ManyToOne
    private City city;
    private boolean isParked;
    @Column(name = "parkingfacility_id")
    private String parkingFacilityId;
    public boolean getisParked(){
        return isParked;
    }
    public void setisParked(boolean n_isparked){
        this.isParked=n_isparked;
    }
    public void setParkingFacilityId(String n_parkingfacilityid){
        this.parkingFacilityId=n_parkingfacilityid;
    }
    public void setCity(City n_city){
        this.city=n_city;
    }
}
