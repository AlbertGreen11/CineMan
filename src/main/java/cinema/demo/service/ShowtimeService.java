package cinema.demo.service;

import cinema.demo.dto.ShowtimeDto;

import java.util.List;

public interface ShowtimeService {
    List<ShowtimeDto>showtimesByCinema(String nazwaKina);
    List<ShowtimeDto> showtimeById(Integer seansID);
}
