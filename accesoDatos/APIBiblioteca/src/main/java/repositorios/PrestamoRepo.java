package repositorios;

import dto.Ejemplar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrestamoRepo extends JpaRepository<Ejemplar,Integer> {
}
