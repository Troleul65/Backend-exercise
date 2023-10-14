package assesment.box;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {
   @Autowired
    private CityRepository cityRepository;
    @PostMapping
    public City createCity(@RequestBody City city){
        return cityRepository.save(city);
    }
    @GetMapping("/{id}")
    public City getCityById(@PathVariable String id){
        return cityRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("City not found with id" + id));
    }
    @GetMapping("/code/{code}")
    public City getCityByCode(@PathVariable String code){
        return cityRepository.findByCode(code)
                .orElseThrow(() -> new NotFoundException("City not found with code" + code));

    }
    @GetMapping
    public List<City> getAllCities(){
        return cityRepository.findAll();
    }

}
