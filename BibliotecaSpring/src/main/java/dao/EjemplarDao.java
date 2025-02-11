package dao;

import dto.Ejemplar;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

public class EjemplarDao implements DAO {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
    private final EntityManager em = emf.createEntityManager();
    private final Class<Ejemplar> clase = Ejemplar.class;
    private final ArrayList<String> campos = new ArrayList<>(List.of("id","isbn","estado"));
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

    @Override
    public <T> T getSimpleData(Object o) {
        return (T) new EjemplarData((Ejemplar) o);
    }


}
