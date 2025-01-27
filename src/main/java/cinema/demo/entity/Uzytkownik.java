package cinema.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Uzytkownik")
public class Uzytkownik {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer uzytkownikID;

        @Column(name = "email")
        private String email;

        @Column(name = "haslo")
        private String haslo;

        @Transient
        private String powtorzoneHaslo;

    public String getPowtorzoneHaslo() {
        return powtorzoneHaslo;
    }

    public void setPowtorzoneHaslo(String powtorzoneHaslo) {
        this.powtorzoneHaslo = powtorzoneHaslo;
    }

    public Uzytkownik(Integer userID, String email, String password, String powtorzoneHaslo) {
        this.uzytkownikID = userID;
        this.email = email;
        this.haslo = password;
        this.powtorzoneHaslo = powtorzoneHaslo;
    }

    public Uzytkownik() {
    }

    public Integer getUzytkownikID() {
        return uzytkownikID;
    }

    public void setUzytkownikID(Integer uzytkownikID) {
        this.uzytkownikID = uzytkownikID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }
}
