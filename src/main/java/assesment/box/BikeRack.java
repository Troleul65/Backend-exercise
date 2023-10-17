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

    public void setId(String newId){ this.id=newId;
    }
    public void setName(String newName){ this.name=newName;}
    public void setCity(City newCity){this.city=newCity;}
    public void setCapacity(Integer newCapacity){capacity=newCapacity;}
    public void setAvailableCapacity(Integer newSetCapacity){availableCapacity=newSetCapacity;}
}
