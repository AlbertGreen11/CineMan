package cinema.demo.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "Seans")
public class Seans {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seansID;

    @ManyToOne
    @JoinColumn(name = "kinoID")
    private Kino kino;

    @ManyToOne
    @JoinColumn(name = "filmID")
    private Film film;

    @Column(name = "dataseansu")
    private Timestamp dataSeansu;

    public Seans() {
    }

    public Seans(Integer seansID, Kino cinema, Film movie, Timestamp showtimeDate) {
        this.seansID = seansID;
        this.kino = cinema;
        this.film = movie;
        this.dataSeansu = showtimeDate;
    }

    public Integer getSeansID() {
        return seansID;
    }

    public void setSeansID(Integer seansID) {
        this.seansID = seansID;
    }

    public Kino getKino() {
        return kino;
    }

    public void setKino(Kino kino) {
        this.kino = kino;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Timestamp getDataSeansu() {
        return dataSeansu;
    }

    public void setDataSeansu(Timestamp dataSeansu) {
        this.dataSeansu = dataSeansu;
    }
}
