package cinema.demo.dto;

public class CinemaDto {
    private Integer kinoID;
    private String nazwa;
    private String miasto;

    public CinemaDto() {
    }

    public CinemaDto(Integer id, String name, String city) {
        this.kinoID = id;
        this.nazwa = name;
        this.miasto = city;
    }

    public Integer getKinoID() {
        return kinoID;
    }

    public void setKinoID(Integer kinoID) {
        this.kinoID = kinoID;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }
}
