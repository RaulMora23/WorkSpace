package dao;

import dto.Ejemplar;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.sql.ResultSet;
import java.util.ArrayList;

public interface DAO {

    public default ObjetoGenerico read(int id){
        EntityManager em = getEntityManager();
        return new ObjetoGenerico(em.find(getClase(), id),getClase());
    };

    public default ArrayList<ObjetoGenerico> readBy(ArrayList<String> campos,ArrayList<String> valores){
        EntityManager em = getEntityManager();
        String query = "select * from "+getClase().getName()+" where ";
        int i = 0;
        while(i<campos.size()-1){
            query += "? = ? AND ";
            i++;
        }
        i++;
        query += "? = ?";

        Query sentencia = em.createNativeQuery(query, getClase());
        for(int j=1;j<campos.size();j=j+2){
            sentencia.setParameter(j,campos.get(j));
        }
        for(int j=2;j<valores.size();j=j+2){
            sentencia.setParameter(j,valores.get(j));
        }
        ArrayList<ObjetoGenerico> resultado = new ArrayList<>();
        ArrayList<Object> instancias = (ArrayList<Object>) sentencia.getResultList();
        for(Object o : instancias){
            resultado.add(new ObjetoGenerico(o,getClase()));
        }
        return resultado;
    };

    public default boolean insert(ObjetoGenerico objetoGenerico){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.persist(objetoGenerico.getClase().cast(objetoGenerico.getInstancia()));
        em.getTransaction().commit();
        return true;
    };

    public default boolean update(ObjetoGenerico objetoGenerico){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(objetoGenerico.getClase().cast(objetoGenerico.getInstancia()));
        em.getTransaction().commit();
        return true;
    };

    public default boolean delete(ObjetoGenerico objetoGenerico){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.remove(objetoGenerico.getClase().cast(objetoGenerico.getInstancia()));
        em.getTransaction().commit();
        return true;
    };

    public Class<?> getClase();

    public EntityManager getEntityManager();


}


