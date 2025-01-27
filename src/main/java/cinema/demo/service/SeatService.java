package cinema.demo.service;

import cinema.demo.dto.SeatDto;

import java.util.List;

public interface SeatService {
    List<SeatDto> seatsByShowtime(Integer seansID);
    void updateReservationID(List<Integer> miejsceIDs, Integer rezerwacjaID);
}
