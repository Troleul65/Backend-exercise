package assesment.box;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ParkingFacilitiesRepository extends JpaRepository<ParkingFacilities,String> {
    List<ParkingFacilities> findByCityId(String cityId);
}
