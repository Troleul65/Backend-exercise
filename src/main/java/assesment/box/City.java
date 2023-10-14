package assesment.box;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Table(name="city")
public class City {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    @NotNull
    @Size(max=256)
    private String name;
    @Size(max=4)
    @NotNull
    private String code;
    @OneToMany(mappedBy = "city")
    private List<ParkingFacilities> ParkingFacilities;


}


