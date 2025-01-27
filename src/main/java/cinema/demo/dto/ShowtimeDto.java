package cinema.demo.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ShowtimeDto {
    private Integer seansID;
    private MovieDto film;
    private String dataSeansu;
    private String godzinaSeansu;
    private CinemaDto kino;

    public ShowtimeDto() {
    }

    public ShowtimeDto(Integer seansID, MovieDto movie, LocalDate date, LocalTime hour, CinemaDto cinema) {
        this.seansID = seansID;
        this.film = movie;
        this.dataSeansu = date.format(DateTimeFormatter.ofPattern("d MMMM", Locale.forLanguageTag("pl")));
        this.godzinaSeansu = hour.toString();
        this.kino = cinema;
    }

    public Integer getSeansID() {
        return seansID;
    }

    public void setSeansID(Integer seansID) {
        this.seansID = seansID;
    }

    public MovieDto getFilm() {
        return film;
    }

    public void setFilm(MovieDto film) {
        this.film = film;
    }

    public String getDataSeansu() {
        return dataSeansu;
    }

    public void setDataSeansu(String dataSeansu) {
        this.dataSeansu = dataSeansu;
    }

    public String getGodzinaSeansu() {
        return godzinaSeansu;
    }

    public void setGodzinaSeansu(String godzinaSeansu) {
        this.godzinaSeansu = godzinaSeansu;
    }

    public CinemaDto getKino() {
        return kino;
    }

    public void setKino(CinemaDto kino) {
        this.kino = kino;
    }
}
