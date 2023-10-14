package assesment.box;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface CityRepository extends JpaRepository<City,String> {
    Optional<City> findByCode(String code);

}
