package dao;

import dto.Ejemplar;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public interface DAO {

    public default ObjetoGenerico read(int id){
        EntityManager em = getEntityManager();
        return new ObjetoGenerico(em.find(getClase(), id),getClase());
    };
    public default ObjetoGenerico read(String id){
        EntityManager em = getEntityManager();
        return new ObjetoGenerico(em.find(getClase(), id),getClase());
    };

    public default ArrayList<ObjetoGenerico> readAll() {
        EntityManager em = getEntityManager();

        // Construcción dinámica de la consulta SQL
        String query = "select * from " + getClase().getSimpleName();

        // Ejecutar la consulta y convertir los resultados a una lista de ObjetoGenerico
        ArrayList<ObjetoGenerico> resultado = new ArrayList<>();
        List<Object> instancias = (List<Object>) em.createNativeQuery(query, getClase()).getResultList();

        // Convertir las instancias a ObjetoGenerico y agregarlas a la lista de resultados
        for (Object o : instancias) {
            resultado.add(new ObjetoGenerico(o, getClase()));
        }

        return resultado;
    }

    public default ArrayList<ObjetoGenerico> readBy(ArrayList<String> campos, ArrayList<String> valores) {
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
        for (int i = 0; i < campos.size(); i++) {
            sentencia.setParameter(i + 1, valores.get(i));  // Usar i + 1 para el índice de parámetro
        }

        // Ejecutar la consulta y convertir los resultados a una lista de ObjetoGenerico
        ArrayList<ObjetoGenerico> resultado = new ArrayList<>();
        List<Object> instancias = sentencia.getResultList();

        // Convertir las instancias a ObjetoGenerico y agregarlas a la lista de resultados
        for (Object o : instancias) {
            resultado.add(new ObjetoGenerico(o, getClase()));
        }

        return resultado;
    }

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

//    public Object castObject(Object objeto);


}


