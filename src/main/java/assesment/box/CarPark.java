package assesment.box;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.IdGeneratorType;
import org.hibernate.annotations.PartitionKey;
import org.hibernate.property.access.spi.Setter;

@Entity
@Table(name="CarPark")
public class CarPark {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    @Size(max = 256)
    private String name;
@ManyToOne
    private City city;
    private Integer capacity;
    private Integer availableCapacity;
    //getter and setter
    public String getId(){return id;}
    public String getName(){return name;}
    public City getCity(){return city;}
    public Integer getCapacity(){return capacity;}
    public Integer getAvailableCapacity(){return availableCapacity;}

    public void setId(String newId){ id=newId;}
    public void setName(String newName){ name=newName;}
    public void setCity(City newCity){city=newCity;}
    public void setCapacity(Integer ewCapacity){capacity=ewCapacity;}
    public void setAvailableCapacity(Integer newSetCapacity){availableCapacity=newSetCapacity;}

}
