package assesment.box;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@DiscriminatorValue("car")
public class Car extends Vehicle{
    @ManyToOne
    private City city;
    private boolean isParked;
    @Column(name = "parkingfacility_id")
    private String parkingFacilityId;
    public boolean getisParked(){
        return isParked;
    }
    public void setisParked(boolean newIsParked){
        this.isParked=newIsParked;
    }
    public void setParkingFacilityId(String newParkingFacilityid){
        this.parkingFacilityId=newParkingFacilityid;
    }
    public void setCity(City newCity){
        this.city=newCity;
    }
}
