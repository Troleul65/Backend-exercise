package assesment.box;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities/{cityId}/ParkingFacilities")
public class ParkingFacilitiesController {
    @Autowired
    private ParkingFacilitiesRepository parkingFacilitiesRepository;
    @Autowired
    private CityRepository cityRepository;

    @PostMapping
    public ParkingFacilities createParkingFacilities(@PathVariable String cityId, @RequestBody ParkingFacilities parkingfacilities){
        return cityRepository.findById(cityId).map(city -> {
            parkingfacilities.setCity(city);
            return parkingFacilitiesRepository.save(parkingfacilities);
        }).orElseThrow(() -> new NotFoundException("City not found with id" + cityId));
    }
    @GetMapping("id")
    public ParkingFacilities getParkingFacilitiesById(@PathVariable String id){
        return parkingFacilitiesRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Parking Facility not found with id "+id));
    }
    @GetMapping
    public List<ParkingFacilities> getAllParkingFacilities(@PathVariable String cityId){
        return parkingFacilitiesRepository.findByCityId(cityId);
    }

}
