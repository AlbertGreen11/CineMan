package cinema.demo.dto;

public class SeatDto {
    private Integer miejsceID;
    private Integer seansID;
    private Character rzad;
    private Integer numerMiejsca;
    private Integer rezerwacjaID;

    public SeatDto() {
    }

    public SeatDto(Integer miejsceID, Integer seansID, Character rzad, Integer numerMiejsca, Integer rezerwacjaID) {
        this.miejsceID = miejsceID;
        this.seansID = seansID;
        this.rzad = rzad;
        this.numerMiejsca = numerMiejsca;
        this.rezerwacjaID = rezerwacjaID;
    }

    public Integer getMiejsceID() {
        return miejsceID;
    }

    public void setMiejsceID(Integer miejsceID) {
        this.miejsceID = miejsceID;
    }

    public Integer getSeansID() {
        return seansID;
    }

    public void setSeansID(Integer seansID) {
        this.seansID = seansID;
    }

    public Character getRzad() {
        return rzad;
    }

    public void setRzad(Character rzad) {
        this.rzad = rzad;
    }

    public Integer getNumerMiejsca() {
        return numerMiejsca;
    }

    public void setNumerMiejsca(Integer numerMiejsca) {
        this.numerMiejsca = numerMiejsca;
    }

    public Integer getRezerwacjaID() {
        return rezerwacjaID;
    }

    public void setRezerwacjaID(Integer rezerwacjaID) {
        this.rezerwacjaID = rezerwacjaID;
    }
}
