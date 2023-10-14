package assesment.box;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.boot.cfgxml.spi.CfgXmlAccessService;

@Entity
@Table(name="ParkingFacilities")
public class ParkingFacilities {
   @Id
   @GeneratedValue(generator = "system-uuid")
   @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    @OneToOne(cascade = CascadeType.ALL)
    private CarPark carPark;
    @OneToOne(cascade = CascadeType.ALL)
    private BikeRack bikeRack;
    @ManyToOne
    private City city;
    public City getCity(){
        return city;
    }
    public CarPark getCarPark(){
        return carPark;
    }
    public BikeRack getBikeRack(){
        return bikeRack;
    }
    public void setCity(City city) {
        this.city = city;}

}
