package dao;

import dto.Ejemplar;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

public abstract class EjemplarDao {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
    private static EntityManager em = emf.createEntityManager();

    public static Ejemplar findEjemplar(Ejemplar e) {
        return em.find(Ejemplar.class, e);
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
    }EQWTQERWTGQRGQRG
    public static boolean update(Ejemplar ejemplar) {
        em.getTransaction().begin();
        em.merge(ejemplar);
        em.getTransaction().commit();
        return true;
    }
    public static boolean delete(Ejemplar ejemplar) {
        em.getTransaction().begin();
        em.remove(ejemplar);
        em.getTransaction().commit();
        return true;
    }
}
