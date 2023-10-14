package assesment.box;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="BikeRack")
public class BikeRack {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    @NotNull
    @Size(max=256)
    private String name;
    @ManyToOne
    private City city;
    private Integer capacity;
    private Integer availableCapacity;

    public String getId(){return id;}
    public String getName(){return name;}
    public City getCity(){return city;}
    public Integer getCapacity(){return capacity;}
    public Integer getAvailableCapacity(){return availableCapacity;}

    public void setId(String n_id){ id=n_id;
    }
    public void setName(String n_name){ name=n_name;}
    public void setCity(City n_city){city=n_city;}
    public void setCapacity(Integer n_capacity){capacity=n_capacity;}
    public void setAvailableCapacity(Integer n_setcapacity){availableCapacity=n_setcapacity;}
}
