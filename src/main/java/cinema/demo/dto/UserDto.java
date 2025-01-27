package cinema.demo.dto;

public class UserDto {
    private int uzytkownikID;
    private String email;
    private String haslo;

    public UserDto(int userID, String email, String password) {
        this.uzytkownikID = userID;
        this.email = email;
        this.haslo = password;
    }

    public UserDto() {
    }

    public int getUzytkownikID() {
        return uzytkownikID;
    }

    public void setUzytkownikID(int uzytkownikID) {
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
