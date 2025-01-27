package cinema.demo.controller;

import cinema.demo.dto.SeatDto;
import cinema.demo.entity.Miejsce;
import cinema.demo.entity.Rezerwacja;
import cinema.demo.repository.SeatRepository;
import cinema.demo.request.ReserveSeatsRequest;
import cinema.demo.service.SeatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/showtime")
public class SeatController {
    private SeatService seatService;

    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @GetMapping("/{seansID}/seats")
    @CrossOrigin(origins = "http://localhost:9990")
    public ResponseEntity<List<SeatDto>> getSeatsByShowtime(@PathVariable("seansID") Integer seansID) {
        List<SeatDto> seatDtoList = seatService.seatsByShowtime(seansID);

        return ResponseEntity.ok(seatDtoList);
    }

    @PutMapping("/reserve-seats")
    @CrossOrigin(origins = "http://localhost:9990")
    public ResponseEntity<String> reserveSeats(@RequestBody ReserveSeatsRequest reserveSeatsRequest) {
        seatService.updateReservationID(reserveSeatsRequest.getMiejsceIDs(), reserveSeatsRequest.getRezerwacjaID());

        return ResponseEntity.ok("Zarezerwowano!");
    }
}
