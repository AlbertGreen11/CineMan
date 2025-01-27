package cinema.demo.repository;

import cinema.demo.entity.Seans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShowtimeRepository extends JpaRepository<Seans, Integer> {
    @Query(value = "SELECT s.seansID, f.filmID, f.tytul, f.czasTrwania AS czasTrwania, f.gatunek, f.urlPlakatu AS urlPlakatu, " +
            "CAST(s.dataSeansu AS DATE) AS data, " +
            "CAST(s.dataSeansu AS TIME) AS godzina, " +
            "k.kinoID, k.nazwa AS nazwaKina, k.miasto " +
            "FROM seans s " +
            "JOIN film f ON s.filmid = f.filmid " +
            "JOIN kino k ON s.kinoid = k.kinoid " +
            "WHERE k.nazwa = :nazwaKina " +
            "ORDER BY CAST(s.dataSeansu AS DATE), CAST(s.dataSeansu AS TIME)",
            nativeQuery = true)
    List<Object[]> findAllShowtimesWithDetailsByCinemaName(String nazwaKina);

    @Query(value = "SELECT s.seansID, f.filmID, f.tytul, f.czasTrwania AS czasTrwania, f.gatunek, f.urlPlakatu AS urlPlakatu, " +
            "CAST(s.dataSeansu AS DATE) AS data, " +
            "CAST(s.dataSeansu AS TIME) AS godzina, " +
            "k.kinoID, k.nazwa AS nazwaKina, k.miasto " +
            "FROM seans s " +
            "JOIN film f ON s.filmid = f.filmid " +
            "JOIN kino k ON s.kinoid = k.kinoid " +
            "WHERE s.seansID = :seansID ",
            nativeQuery = true)
    List<Object[]> findShowtimeById(Integer seansID);
}
