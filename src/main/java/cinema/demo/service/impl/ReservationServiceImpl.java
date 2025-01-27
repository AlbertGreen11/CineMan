package cinema.demo.service.impl;

import cinema.demo.dto.ReservationDetailsDto;
import cinema.demo.dto.SeatDto;
import cinema.demo.entity.Miejsce;
import cinema.demo.repository.ReservationRepository;
import cinema.demo.service.ReservationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Transactional
    public Integer insertEntityAndGetId(String email) {
        reservationRepository.newReservation(email);
        return reservationRepository.getLastInsertedID();
    }

    public List<ReservationDetailsDto> getReservationsByEmail(String email) {
        List<Object[]> rawData = reservationRepository.getReservationsByEmail(email);

        Map<Integer, List<Object[]>> groupedByReservationId = rawData.stream()
                .collect(Collectors.groupingBy(record -> (Integer) record[0]));

        List<ReservationDetailsDto> reservations = groupedByReservationId.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(entry -> {
                    Integer rezerwacjaID = entry.getKey();
                    List<Object[]> records = entry.getValue();

                    String tytul = (String) records.get(0)[2];
                    String urlPlakatu = (String) records.get(0)[3];
                    LocalDate data = ((java.sql.Date) records.get(0)[4]).toLocalDate();
                    LocalTime godzina = ((java.sql.Time) records.get(0)[5]).toLocalTime();
                    String miasto = (String) records.get(0)[6];
                    String nazwa = (String) records.get(0)[7];

                    List<String> miejsca = records.stream()
                            .map(record -> String.valueOf(record[1]))
                            .collect(Collectors.toList());

                    return new ReservationDetailsDto(rezerwacjaID, miejsca, tytul, urlPlakatu, data, godzina, miasto, nazwa);
                })
                .collect(Collectors.toList());

        return reservations;
    }


    @Override
    public void deleteReservation(Integer rezerwacjaID) {
        reservationRepository.setReservationIDAsNullById(rezerwacjaID);
        reservationRepository.deleteReservationById(rezerwacjaID);
    }


}