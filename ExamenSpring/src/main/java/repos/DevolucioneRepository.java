package repos;

import entidades.Devolucione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevolucioneRepository extends JpaRepository<Devolucione, Integer> {
}