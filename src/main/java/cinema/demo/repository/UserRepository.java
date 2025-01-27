package cinema.demo.repository;

import cinema.demo.entity.Uzytkownik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Uzytkownik, Integer> {
    boolean existsByEmail(String email);
    Uzytkownik findByEmail(String email);
}
