package cinema.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Kino")
public class Kino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer kinoID;

    @Column(name = "nazwa")
    private String nazwa;

    @Column(name = "miasto")
    private String miasto;

    public Kino(Integer id, String name, String city) {
        this.kinoID = id;
        this.nazwa = name;
        this.miasto = city;
    }

    public Kino() {
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
