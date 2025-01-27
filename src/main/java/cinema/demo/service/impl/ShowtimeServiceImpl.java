package cinema.demo.service.impl;

import cinema.demo.dto.CinemaDto;
import cinema.demo.dto.MovieDto;
import cinema.demo.dto.ShowtimeDto;
import cinema.demo.repository.ShowtimeRepository;
import cinema.demo.service.ShowtimeService;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShowtimeServiceImpl implements ShowtimeService {
    private ShowtimeRepository showtimeRepository;

    public ShowtimeServiceImpl(ShowtimeRepository showtimeRepository) {
        this.showtimeRepository = showtimeRepository;
    }

    @Override
    public List<ShowtimeDto> showtimesByCinema(String nazwaKina) {
        List<ShowtimeDto> showtimes = showtimeRepository.findAllShowtimesWithDetailsByCinemaName(nazwaKina).stream()
                .map(record -> new ShowtimeDto(
                        (Integer) record[0],
                        new MovieDto(
                                (Integer) record[1],
                                (String) record[2],
                                (Integer) record[3],
                                (String) record[4],
                                (String) record[5]
                        ),
                        ((java.sql.Date) record[6]).toLocalDate(),
                        ((java.sql.Time) record[7]).toLocalTime(),
                        new CinemaDto(
                                (Integer) record[8],
                                (String) record[9],
                                (String) record[10]
                )
                ))
                .collect(Collectors.toList());

        return showtimes;
    }

    @Override
    public List<ShowtimeDto> showtimeById(Integer seansID) {
        List<ShowtimeDto> showtimeDto = showtimeRepository.findShowtimeById(seansID).stream()
                .map(record -> new ShowtimeDto(
                        (Integer) record[0],
                        new MovieDto(
                                (Integer) record[1],
                                (String) record[2],
                                (Integer) record[3],
                                (String) record[4],
                                (String) record[5]
                        ),
                        ((java.sql.Date) record[6]).toLocalDate(),
                        ((java.sql.Time) record[7]).toLocalTime(),
                        new CinemaDto(
                                (Integer) record[8],
                                (String) record[9],
                                (String) record[10]
                        )
                ))
                .collect(Collectors.toList());

        return showtimeDto;
    }
}
