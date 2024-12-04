package dao;

import dto.Ejemplar;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.io.DataOutput;
import java.util.ArrayList;

public class EjemplarDao implements DAO {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
    private final EntityManager em = emf.createEntityManager();
    private final Class<Ejemplar> clase = (Class<Ejemplar>) new Ejemplar().getClass();

    @Override
    public Class<?> getClase() {
        return clase;
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
}
