package dao;

import dto.Ejemplar;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
public class EjemplarDao implements DAO {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
    private final EntityManager em = emf.createEntityManager();
    private final Class<Ejemplar> clase = Ejemplar.class;
    private final ArrayList<String> campos = new ArrayList<>(List.of("id","isbn","estado"));

    @GetMapping("/Ejemplar/All")
    public List<Ejemplar> getEjemplar() {
        return readAll();
    }
    @GetMapping("/Ejemplar")
    public ResponseEntity<Ejemplar> getEjemplarById(@RequestParam int id) {
        return ResponseEntity.ok(read(id));
    }
    @PostMapping("/Ejemplar")
    public boolean addEjemplar(@RequestBody Ejemplar ejemplar) {
        return insert(new ObjetoGenerico(ejemplar, ejemplar.getClass()));
    }

    @Override
    public Class<?> getClase() {
        return clase;
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public ArrayList<String> getCampos() {
        return campos;
    }


}
