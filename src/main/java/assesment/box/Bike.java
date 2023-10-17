package assesment.box;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@DiscriminatorValue("bike")
public class Bike extends Vehicle {
    @ManyToOne
    private City city;
    private boolean isParked;
    @Column(name = "parkingfacility_id")
    private String parkingfacilityId;

    public boolean getisParked() {
        return isParked;
    }

    public void setisParked(boolean newIsParked) {
        this.isParked = newIsParked;
    }

    public void setParkingFacilityId(String newParkingFacilityid) {
        this.parkingfacilityId = newParkingFacilityid;
    }

    public void setCity(City newCity) {
        this.city = newCity;
    }
}
