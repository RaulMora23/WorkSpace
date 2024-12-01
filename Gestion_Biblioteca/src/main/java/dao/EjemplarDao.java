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

    public static boolean findEjemplar(Ejemplar e) {
        if (em.find(clase,e)!=null) {
            return true;
        }else {
            return false;
        }
    }
    public static ArrayList<Ejemplar> getEjemplares() {
        em.getTransaction().begin();
        ArrayList<Ejemplar> lista = (ArrayList<Ejemplar>) em.createQuery("select e from Ejemplar e", Ejemplar.class).getResultList();
        em.getTransaction().commit();
        return lista;
    }
    public static Ejemplar getEjemplar(int id) {
        Ejemplar ejemplar = null;
        em.getTransaction().begin();
        try {
            ejemplar = em.createQuery("select e from Ejemplar e where e.id = :id", Ejemplar.class).getSingleResult();
        }catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println("No se ha encontrado el ejemplar con id = "+id);
        }
        em.getTransaction().commit();
        if(ejemplar != null) {
            return ejemplar;
        }else {
            return null;
        }
    }

    public static boolean create(Ejemplar ejemplar) {
        em.getTransaction().begin();
        em.persist(ejemplar);
        em.getTransaction().commit();
        return true;
    }
    public static boolean update(Ejemplar ejemplar) {
        em.getTransaction().begin();
        em.merge(ejemplar);
        em.getTransaction().commit();
        return true;
    }
    public static boolean delete(Ejemplar ejemplar) {
        em.getTransaction().begin();
        if (findEjemplar(ejemplar)) {
            em.remove(ejemplar);
        }
        em.getTransaction().commit();
        return true;
    }
}
