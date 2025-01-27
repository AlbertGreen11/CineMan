package cinema.demo.controller;

import cinema.demo.dto.ShowtimeDto;
import cinema.demo.repository.ShowtimeRepository;
import cinema.demo.service.ShowtimeService;
import cinema.demo.service.impl.ShowtimeServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/showtimes")
public class ShowtimeController {
    private ShowtimeService showtimeService;

    public ShowtimeController(ShowtimeService showtimeService) {
        this.showtimeService = showtimeService;
    }

    @GetMapping("/{nazwaKina}")
    @CrossOrigin(origins = "http://localhost:9990")
    public ResponseEntity<List<ShowtimeDto>> showShowtimes(@PathVariable("nazwaKina") String nazwaKina) {
        List<ShowtimeDto> showtimes = showtimeService.showtimesByCinema(nazwaKina);

        return ResponseEntity.ok(showtimes);
    }

    @GetMapping("/showtime/{seansID}")
    @CrossOrigin(origins = "http://localhost:9990")
    public ResponseEntity<ShowtimeDto> showShowtimeDetailsById(@PathVariable("seansID") Integer seansID) {
        ShowtimeDto showtimeDto = showtimeService.showtimeById(seansID).getFirst();

        return ResponseEntity.ok(showtimeDto);
    }
}
