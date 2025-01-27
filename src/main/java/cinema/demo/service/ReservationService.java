package cinema.demo.service;

import cinema.demo.dto.ReservationDetailsDto;

import java.util.List;

public interface ReservationService {
   Integer insertEntityAndGetId(String email);
   List<ReservationDetailsDto> getReservationsByEmail(String email);
   void deleteReservation(Integer rezerwacjaID);
}
