package cinema.demo.mapper;

import cinema.demo.dto.CinemaDto;
import cinema.demo.entity.Kino;

public class CinemaMapper {
    public static CinemaDto mapToCinemaDto(Kino cinema) {
        return new CinemaDto(
                cinema.getKinoID(),
                cinema.getNazwa(),
                cinema.getMiasto()
        );
    }

    public static Kino mapToCinema(CinemaDto cinemaDto) {
        return new Kino(
                cinemaDto.getKinoID(),
                cinemaDto.getNazwa(),
                cinemaDto.getMiasto()
        );
    }
}
