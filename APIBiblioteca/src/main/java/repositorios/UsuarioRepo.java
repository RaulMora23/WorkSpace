package repositorios;

import dto.Ejemplar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepo extends JpaRepository<Ejemplar,Integer> {
}

