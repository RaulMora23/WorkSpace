package dao;

import dto.Ejemplar;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.sql.ResultSet;
import java.util.ArrayList;

public interface DAO {

    public default Object read(int id){
        EntityManager em = getEntityManager();
        return em.find(getClase(), id);
    };

    public default ArrayList<Object> readBy(ArrayList<String> campos,ArrayList<String> valores){
        EntityManager em = getEntityManager();
        String query = "select * from "+getClase().getName()+" where ";
        int i = 0;
        while(i<campos.size()-1){
            query += campos.get(i) + " = "+valores.get(i)+" AND ";
            i++;
        }
        i++;
        query += campos.get(i) + " = "+valores.get(i);
        TypedQuery<?> query1 = em.createQuery(query, getClase());
    };

    public boolean insert();

    public boolean update();

    public boolean delete();

    public Class<?> getClase();

    public EntityManager getEntityManager();


}


