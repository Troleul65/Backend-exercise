package assesment.box;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@DiscriminatorValue("bike")
@Table(name="bike")
public class Bike extends Vehicle {
    @ManyToOne
    private City city;
    private boolean isParked;
    @Column(name = "parkingfacility_id")
    private String parkingfacilityId;

    public boolean getisParked() {
        return isParked;
    }

    public void setisParked(boolean n_isparked) {
        this.isParked = n_isparked;
    }

    public void setParkingFacilityId(String n_parkingfacilityid) {
        this.parkingfacilityId = n_parkingfacilityid;
    }

    public void setCity(City n_city) {
        this.city = n_city;
    }
}
