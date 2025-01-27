package cinema.demo.repository;

import cinema.demo.entity.Rezerwacja;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Rezerwacja, Integer> {
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO rezerwacja(uzytkownikID) SELECT u.uzytkownikID FROM uzytkownik u WHERE u.email = :email",
            nativeQuery = true)
    void newReservation(String email);

    @Query(value = "SELECT r.rezerwacjaID FROM rezerwacja r ORDER BY r.rezerwacjaID DESC LIMIT 1", nativeQuery = true)
    Integer getLastInsertedID();

    @Query(value = "SELECT r.rezerwacjaID, " +
            "GROUP_CONCAT(CONCAT(m.rzad, m.numermiejsca) SEPARATOR ', ') AS miejsca, " +
            "f.tytul, f.urlPlakatu, " +
            "CAST(s.dataSeansu AS DATE) AS data, " +
            "CAST(s.dataSeansu AS TIME) AS godzina, " +
            "k.miasto, k.nazwa " +
            "FROM seans s " +
            "JOIN film f ON s.filmid = f.filmid " +
            "JOIN kino k ON s.kinoid = k.kinoid " +
            "JOIN miejsce m ON m.seansID = s.seansID " +
            "JOIN rezerwacja r ON r.rezerwacjaID = m.rezerwacjaID " +
            "JOIN uzytkownik u ON u.uzytkownikID = r.uzytkownikID " +
            "WHERE u.email = :email " +
            "GROUP BY r.rezerwacjaID, f.tytul, f.urlPlakatu, data, godzina, k.miasto, k.nazwa",
            nativeQuery = true)
    List<Object[]> getReservationsByEmail(String email);

    @Transactional
    @Modifying
    @Query(value = "UPDATE miejsce SET rezerwacjaID = null WHERE rezerwacjaID = :rezerwacjaID",
            nativeQuery = true)
    void setReservationIDAsNullById(Integer rezerwacjaID);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM rezerwacja WHERE rezerwacjaID = :rezerwacjaID",
            nativeQuery = true)
    void deleteReservationById(Integer rezerwacjaID);


}
