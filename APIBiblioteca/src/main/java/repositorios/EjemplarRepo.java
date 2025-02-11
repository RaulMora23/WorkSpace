package repositorios;

import dto.Ejemplar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface EjemplarRepo extends JpaRepository<Ejemplar,Integer>{
}
