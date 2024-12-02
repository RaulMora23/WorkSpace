package dao;

import dto.Ejemplar;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.io.DataOutput;
import java.util.ArrayList;

public abstract class EjemplarDao implements DAO {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Biblioteca");
    private static EntityManager em = emf.createEntityManager();
    private static final Class<Ejemplar> clase = Ejemplar.class;

}
