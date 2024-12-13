package dao;

import dto.Ejemplar;
import dto.Libro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

public class LibroDao implements DAO {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
    private final EntityManager em = emf.createEntityManager();
    private final Class<Libro> clase = Libro.class;
    private final ArrayList<String> campos = new ArrayList<>(List.of("isbn", "titulo", "autor"));
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
