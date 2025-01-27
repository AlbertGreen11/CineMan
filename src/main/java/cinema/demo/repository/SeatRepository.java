package cinema.demo.repository;

import cinema.demo.entity.Miejsce;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SeatRepository extends JpaRepository<Miejsce, Integer> {
    @Query(value = "SELECT m.miejsceID, m.seansID, m.rzad, m.numermiejsca, m.rezerwacjaID " +
            "FROM miejsce m " +
            "WHERE m.seansID = :seansID " +
            "ORDER BY m.rzad, m.numermiejsca",
            nativeQuery = true)
    List<Object[]> findAllSeatsWithDetailsByShowtimeID(Integer seansID);

    @Modifying
    @Transactional
    @Query(value = "UPDATE miejsce m SET m.rezerwacjaID = :rezerwacjaID WHERE m.miejsceID IN (:miejsceIds)", nativeQuery = true)
    void updateReservationIDByMiejsceIds(List<Integer> miejsceIds, Integer rezerwacjaID);
}
