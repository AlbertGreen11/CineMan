package cinema.demo.repository;

import cinema.demo.entity.Kino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CinemaRepository extends JpaRepository<Kino, Integer> {
    List<Kino> findByMiasto(String miasto);
}
