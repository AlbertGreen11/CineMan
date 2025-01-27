package cinema.demo.controller;

import cinema.demo.dto.CinemaDto;
import cinema.demo.service.CinemaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cinemas")
public class CinemaController {
    private CinemaService cinemaService;


    public CinemaController(CinemaService cinemaService) {
        this.cinemaService = cinemaService;
    }

    @CrossOrigin(origins = "http://localhost:9990")
    @GetMapping("{city}")
    public ResponseEntity<List<String>> getCinemasByCity(@PathVariable("city") String cinemaCity) {
        List<String> cinemas = cinemaService.getCinemasByCity(cinemaCity);
        return ResponseEntity.ok(cinemas);
    }

    @CrossOrigin(origins = "http://localhost:9990")
    @GetMapping("cities")
    public ResponseEntity<List<String>> getAllCities() {
        List<String> cities = cinemaService.getAllCities();
        return ResponseEntity.ok(cities);
    }
}
