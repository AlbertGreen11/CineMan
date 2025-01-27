package cinema.demo.dto;

import cinema.demo.entity.Miejsce;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ReservationDetailsDto {
    private Integer rezerwacjaID;
    private List<String> miejsca;
    private String tytul;
    private String urlPlakatu;
    private String dataSeansu;
    private String godzinaSeansu;
    private String miasto;
    private String nazwaKina;

    public ReservationDetailsDto() {
    }

    public ReservationDetailsDto(Integer rezerwacjaID, List<String> miejsca, String tytul, String urlPlakatu, LocalDate data, LocalTime godzina, String miasto, String nazwa) {
        this.rezerwacjaID = rezerwacjaID;
        this.miejsca = miejsca;
        this.tytul = tytul;
        this.urlPlakatu = urlPlakatu;
        this.dataSeansu = data.format(DateTimeFormatter.ofPattern("d MMMM", Locale.forLanguageTag("pl")));
        this.godzinaSeansu = godzina.toString();
        this.miasto = miasto;
        this.nazwaKina = nazwa;
    }

    public Integer getRezerwacjaID() {
        return rezerwacjaID;
    }

    public void setRezerwacjaID(Integer rezerwacjaID) {
        this.rezerwacjaID = rezerwacjaID;
    }

    public List<String> getMiejsca() {
        return miejsca;
    }

    public void setMiejsca(List<String> miejsca) {
        this.miejsca = miejsca;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public String getUrlPlakatu() {
        return urlPlakatu;
    }

    public void setUrlPlakatu(String urlPlakatu) {
        this.urlPlakatu = urlPlakatu;
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

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getNazwaKina() {
        return nazwaKina;
    }

    public void setNazwaKina(String nazwaKina) {
        this.nazwaKina = nazwaKina;
    }
}
