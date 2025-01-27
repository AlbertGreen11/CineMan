package cinema.demo.service.impl;

import cinema.demo.dto.SeatDto;
import cinema.demo.repository.SeatRepository;
import cinema.demo.service.SeatService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeatServiceImpl implements SeatService {
    private SeatRepository seatsRepository;

    public SeatServiceImpl(SeatRepository seatRepository) {
        this.seatsRepository = seatRepository;
    }

    @Override
    public List<SeatDto> seatsByShowtime(Integer seansID) {
        List<SeatDto> seats = seatsRepository.findAllSeatsWithDetailsByShowtimeID(seansID).stream()
                .map(record -> new SeatDto(
                        (Integer) record[0],
                        (Integer) record[1],
                        (Character) record[2],
                        (Integer) record[3],
                        (Integer) record[4]
                ))
                .collect(Collectors.toList());

        return seats;
    }

    @Override
    public void updateReservationID(List<Integer> miejsceIDs, Integer rezerwacjaID) {
        seatsRepository.updateReservationIDByMiejsceIds(miejsceIDs, rezerwacjaID);
    }
}
