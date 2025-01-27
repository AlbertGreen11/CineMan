package cinema.demo.entity;

import jakarta.persistence.*;

@Entity
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer filmID;

    @Column(name = "tytul")
    private String tytul;

    @Column(name = "czastrwania")
    private Integer czasTrwania;

    @Column(name = "gatunek")
    private String gatunek;

    @Column(name = "urlplakatu")
    private String urlPlakatu;

    public Film() {
    }

    public Film(Integer filmId, String title, Integer duration, String type, String urlPoster) {
        this.filmID = filmId;
        this.tytul = title;
        this.czasTrwania = duration;
        this.gatunek = type;
        this.urlPlakatu = urlPoster;
    }

    public Integer getFilmId() {
        return filmID;
    }

    public void setFilmId(Integer filmId) {
        this.filmID = filmId;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public Integer getCzasTrwania() {
        return czasTrwania;
    }

    public void setCzasTrwania(Integer czasTrwania) {
        this.czasTrwania = czasTrwania;
    }

    public String getGatunek() {
        return gatunek;
    }

    public void setGatunek(String gatunek) {
        this.gatunek = gatunek;
    }

    public String getUrlPlakatu() {
        return urlPlakatu;
    }

    public void setUrlPlakatu(String urlPlakatu) {
        this.urlPlakatu = urlPlakatu;
    }
}
