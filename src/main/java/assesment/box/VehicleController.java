package assesment.box;

import org.springframework.beans.factory.BeanNotOfRequiredTypeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities/{cityCode}/vehicles")
public class VehicleController {
    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private ParkingFacilitiesRepository parkingFacilitiesRepository;

    @PostMapping("/car")
    public Car createCar(@PathVariable String cityCode, @RequestBody Car car){
        return cityRepository.findByCode(cityCode).map(city -> {
            car.setCity(city);
            return vehicleRepository.save(car);
        }).orElseThrow(() -> new NotFoundException("City not found with code "+cityCode));
    }
    @PostMapping("/bike")
    public Bike createBike(@PathVariable String cityCode, @RequestBody Bike bike){
        return cityRepository.findByCode(cityCode).map(city -> {
            bike.setCity(city);
            return vehicleRepository.save(bike);
        }).orElseThrow(() -> new NotFoundException("City not found with code "+ cityCode));
    }
    @GetMapping
    public List<Vehicle> getVehiclesByCityCode(@PathVariable String cityCode){
        return vehicleRepository.findByCityCode(cityCode);
    }
    @PutMapping("/{id}/park/{ParkingFacilityId}")
    public Vehicle parkVehicle(@PathVariable String id, @PathVariable String parkingFacilitiesId) {
        return vehicleRepository.findById(id).map(vehicle -> {
            if (vehicle instanceof Car) {
                Car car = (Car) vehicle;
                if (car.getisParked()) {
                    throw new IllegalStateException("Car is already parked");
                }
                return parkingFacilitiesRepository.findById(parkingFacilitiesId).map(parkingFacilities -> {
                    CarPark carPark = parkingFacilities.getCarPark();
                    if (carPark.getAvailableCapacity() > 0) {
                        car.setisParked(true);
                        car.setParkingFacilityId(parkingFacilitiesId.toString());
                        carPark.setAvailableCapacity(carPark.getAvailableCapacity() - 1);
                        return vehicleRepository.save(car);
                    } else {
                        throw new IllegalStateException("Car Park is full");
                    }
                }).orElseThrow(() -> new NotFoundException("Parking Facilities not found with id " + parkingFacilitiesId));
            } else if (vehicle instanceof Bike) {
                Bike bike = (Bike) vehicle;
                if (bike.getisParked()) {
                    throw new IllegalStateException("Bike is already parked");
                }
                return parkingFacilitiesRepository.findById(parkingFacilitiesId).map(parkingFacilities -> {
                    BikeRack bikeRack = parkingFacilities.getBikeRack();
                    if (bikeRack.getAvailableCapacity() > 0) {
                        bike.setisParked(true);
                        bike.setParkingFacilityId(parkingFacilitiesId.toString());
                        bikeRack.setAvailableCapacity(bikeRack.getAvailableCapacity() - 1);
                        return vehicleRepository.save(bike);
                    } else {
                        throw new IllegalStateException("Bike Rack is full");
                    }
                }).orElseThrow(() -> new NotFoundException("Parking Facilities not found with id " + parkingFacilitiesId));
            } else {
                throw new IllegalArgumentException("Unknown vehicle type");
            }
        }).orElseThrow(() -> new NotFoundException("Vehicle not found with id " + id));
    }
    @PutMapping("/{id}/unpark")
    public Vehicle unparkVehicle(@PathVariable String id) {
        return vehicleRepository.findById(id).map(vehicle -> {
            if (vehicle instanceof Car) {
                Car car = (Car) vehicle;
                if (!car.getisParked()) {
                    throw new IllegalStateException("Car is already unparked");
                }
                car.setisParked(false);
                car.setParkingFacilityId(null);
                return vehicleRepository.save(car);
            } else if (vehicle instanceof Bike) {
                Bike bike = (Bike) vehicle;
                if (!bike.getisParked()) {
                    throw new IllegalStateException("Bike is already unparked");
                }
                bike.setisParked(false);
                bike.setParkingFacilityId(null);
                return vehicleRepository.save(bike);
            } else {
                throw new IllegalArgumentException("Unknown vehicle type");
            }
        }).orElseThrow(() -> new NotFoundException("Vehicle not found with id " + id));
    }

}
