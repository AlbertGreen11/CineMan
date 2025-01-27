package cinema.demo.service;

import cinema.demo.dto.CinemaDto;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CinemaService {
    List<String> getCinemasByCity(String city);
    List<String> getAllCities();

}
