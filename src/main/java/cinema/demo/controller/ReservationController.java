package cinema.demo.controller;

import cinema.demo.dto.ReservationDetailsDto;
import cinema.demo.repository.ReservationRepository;
import cinema.demo.service.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ReservationController {
    private ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/reservations")
    @CrossOrigin(origins = "http://localhost:9990")
    public ResponseEntity<Integer> addNewReservation(@RequestBody Map<String, String> emailMap) {
        Integer rezerwacjaID = reservationService.insertEntityAndGetId(emailMap.get("email"));

        return ResponseEntity.ok(rezerwacjaID);
    }

    @PostMapping("/my-reservations")
    @CrossOrigin(origins = "http://localhost:9990")
    public ResponseEntity<List<ReservationDetailsDto>> showReservation(@RequestBody Map<String, String> emailMap) {
        List<ReservationDetailsDto> reservationDetailsDtos = reservationService.getReservationsByEmail(emailMap.get("email"));
        return ResponseEntity.ok(reservationDetailsDtos);
    }

    @DeleteMapping("/my-reservations/cancel/{rezerwacjaID}")
    @CrossOrigin(origins = "http://localhost:9990")
    public ResponseEntity<String> deleteReservation(@PathVariable Integer rezerwacjaID) {
        reservationService.deleteReservation(rezerwacjaID);

        return ResponseEntity.ok("Usunięto rezerwację!");
    }
}
