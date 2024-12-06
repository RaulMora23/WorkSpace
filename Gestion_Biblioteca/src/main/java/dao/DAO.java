package dao;

import dto.Ejemplar;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public interface DAO {

    public default <T> T read(int id){
        EntityManager em = getEntityManager();
        return (T) em.find(getClase(), id);
    };
    public default <T> T read(String id){
        EntityManager em = getEntityManager();
        return (T) em.find(getClase(), id);
    };

    public default <T> ArrayList<T> readAll() {
        EntityManager em = getEntityManager();

        // Construcción dinámica de la consulta SQL
        String query = "select * from " + getClase().getSimpleName();

        // Ejecutar la consulta y convertir los resultados a una lista de ObjetoGenerico
        ArrayList<T> resultado = (ArrayList<T>) em.createNativeQuery(query, getClase()).getResultList();

        return resultado;
    }
    public default <T> ArrayList<T> readBy(String campo, String valor) {
        EntityManager em = getEntityManager();

        // Construcción dinámica de la consulta SQL
        String query = ("select * from " + getClase().getSimpleName() + " where "+campo+" = ?");


        // Crear la consulta nativa
        Query sentencia = em.createNativeQuery(query, getClase());

        // Asignar los valores de los parámetros en la consulta
            sentencia.setParameter(1,valor);

        // Ejecutar la consulta y convertir los resultados a una lista de ObjetoGenerico
        ArrayList<T> resultado = (ArrayList<T>) sentencia.getResultList();

        return resultado;
    }

    public default <T> ArrayList<T> readBy(List<String> campos, List<String> valores) {
        EntityManager em = getEntityManager();

        // Construcción dinámica de la consulta SQL
        StringBuilder query = new StringBuilder("select * from " + getClase().getSimpleName() + " where ");

        // Iterar sobre campos y valores para crear las condiciones WHERE
        for (int i = 0; i < campos.size(); i++) {
            query.append(campos.get(i)).append(" = ?");  // Agregar cada condición
            if (i < campos.size() - 1) {
                query.append(" AND ");  // Agregar el "AND" entre condiciones
            }
        }

        // Crear la consulta nativa
        Query sentencia = em.createNativeQuery(query.toString(), getClase());

        // Asignar los valores de los parámetros en la consulta
        for (int i = 0; i < valores.size(); i++) {
            sentencia.setParameter(i + 1, valores.get(i));  // Usar i + 1 para el índice de parámetro
        }

        return (ArrayList<T>) sentencia.getResultList();
    }

    public default boolean insert(ObjetoGenerico objetoGenerico){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        //El cast en el main no funciona
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

//    public Object castObject(Object objeto);


}


