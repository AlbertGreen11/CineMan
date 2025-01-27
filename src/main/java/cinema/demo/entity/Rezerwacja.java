package cinema.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Rezerwacja")
public class Rezerwacja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rezerwacjaID;

    @ManyToOne
    @JoinColumn(name = "uzytkownikID")
    private Uzytkownik uzytkownik;

    public Rezerwacja() {
    }

    public Rezerwacja(Integer rezerwacjaID, Uzytkownik uzytkownik) {
        this.rezerwacjaID = rezerwacjaID;
        this.uzytkownik = uzytkownik;
    }

    public Integer getRezerwacjaID() {
        return rezerwacjaID;
    }

    public void setRezerwacjaID(Integer rezerwacjaID) {
        this.rezerwacjaID = rezerwacjaID;
    }

    public Uzytkownik getUzytkownik() {
        return uzytkownik;
    }

    public void setUzytkownik(Uzytkownik uzytkownik) {
        this.uzytkownik = uzytkownik;
    }
}
