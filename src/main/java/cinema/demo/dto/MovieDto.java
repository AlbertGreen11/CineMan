package cinema.demo.dto;

public class MovieDto {
    private Integer filmID;
    private String tytul;
    private Integer czasTrwania;
    private String gatunek;
    private String urlPlakatu;

    public MovieDto(Integer filmID, String tytul, Integer czasTrwania, String gatunek, String urlPlakatu) {
        this.filmID = filmID;
        this.tytul = tytul;
        this.czasTrwania = czasTrwania;
        this.gatunek = gatunek;
        this.urlPlakatu = urlPlakatu;
    }

    public Integer getFilmID() {
        return filmID;
    }

    public void setFilmID(Integer filmID) {
        this.filmID = filmID;
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
