package cinema.demo.request;

import java.util.List;

public class ReserveSeatsRequest {
    private List<Integer> miejsceIDs;
    private Integer rezerwacjaID;

    public List<Integer> getMiejsceIDs() {
        return miejsceIDs;
    }

    public void setMiejsceIDs(List<Integer> miejsceIDs) {
        this.miejsceIDs = miejsceIDs;
    }

    public Integer getRezerwacjaID() {
        return rezerwacjaID;
    }

    public void setRezerwacjaID(Integer rezerwacjaID) {
        this.rezerwacjaID = rezerwacjaID;
    }
}
