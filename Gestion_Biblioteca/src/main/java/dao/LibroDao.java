package dao;

import dto.Ejemplar;
import dto.Libro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;

public class LibroDao implements DAO {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
    private final EntityManager em = emf.createEntityManager();
    private final Class<Libro> clase = Libro.class;

    @Override
    public Class<?> getClase() {
        return clase;
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

}
