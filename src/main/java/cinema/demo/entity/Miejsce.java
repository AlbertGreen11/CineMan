package cinema.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Miejsce")
public class Miejsce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer miejsceID;

    @ManyToOne
    @JoinColumn(name = "seansID")
    private Seans seans;

    @Column(name = "Rzad")
    private Character rzad;

    @Column(name = "numermiejsca")
    private Integer numerMiejsca;

    @ManyToOne
    @JoinColumn(name = "rezerwacjaID")
    private Rezerwacja rezerwacja;

    public Miejsce() {
    }

    public Miejsce(Integer miejsceID, Seans seans, Character rzad, Integer numerMiejsca, Rezerwacja rezerwacja) {
        this.miejsceID = miejsceID;
        this.seans = seans;
        this.rzad = rzad;
        this.numerMiejsca = numerMiejsca;
        this.rezerwacja = rezerwacja;
    }

    public Integer getMiejsceID() {
        return miejsceID;
    }

    public void setMiejsceID(Integer miejsceID) {
        this.miejsceID = miejsceID;
    }

    public Seans getSeans() {
        return seans;
    }

    public void setSeans(Seans seans) {
        this.seans = seans;
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

    public Rezerwacja getRezerwacja() {
        return rezerwacja;
    }

    public void setRezerwacja(Rezerwacja rezerwacja) {
        this.rezerwacja = rezerwacja;
    }
}
