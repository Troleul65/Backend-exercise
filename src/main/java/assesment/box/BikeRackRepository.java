package assesment.box;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BikeRackRepository extends JpaRepository<BikeRack,Long> {
}
