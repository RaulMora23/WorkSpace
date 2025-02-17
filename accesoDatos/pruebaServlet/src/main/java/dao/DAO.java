package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * Interfaz base para las operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre entidades.
 *
 * Esta interfaz proporciona métodos predeterminados para realizar operaciones comunes de acceso a datos,
 * como lectura, inserción, actualización y eliminación, utilizando JPA (Jakarta Persistence API).
 * Los métodos están diseñados para ser utilizados con entidades genéricas.
 *
 *
 */
public interface DAO {

    /**
     * Lee una entidad por su ID (entero).
     *
     * @param id El ID de la entidad a leer.
     * @param <T> El tipo de la entidad.
     * @return La entidad correspondiente al ID proporcionado, o null si no se encuentra.
     */
    public default <T> T read(int id){
        EntityManager em = getEntityManager();
        return (T) em.find(getClase(), id);
    };

    /**
     * Lee una entidad por su ID (cadena).
     *
     * @param id El ID de la entidad a leer.
     * @param <T> El tipo de la entidad.
     * @return La entidad correspondiente al ID proporcionado, o null si no se encuentra.
     */
    public default <T> T read(String id){
        EntityManager em = getEntityManager();
        return (T) em.find(getClase(), id);
    };

    /**
     * Lee todas las entidades de la clase correspondiente.
     *
     * @param <T> El tipo de la entidad.
     * @return Una lista de todas las entidades de la clase.
     */
    public default <T> ArrayList<T> readAll() {
        EntityManager em = getEntityManager();

        // Construcción dinámica de la consulta SQL
        String query = "select * from " + getClase().getSimpleName();

        // Ejecutar la consulta y convertir los resultados a una lista de ObjetoGenerico
        ArrayList<T> resultado = (ArrayList<T>) em.createNativeQuery(query, getClase()).getResultList();

        return resultado;
    }

    /**
     * Lee las entidades filtradas por un campo y valor específicos.
     *
     * @param campo El nombre del campo para aplicar el filtro.
     * @param valor El valor del campo para el filtro.
     * @param <T> El tipo de la entidad.
     * @return Una lista de entidades que cumplen con la condición del campo y valor.
     */
    public default <T> ArrayList<T> readBy(String campo, String valor) {
        EntityManager em = getEntityManager();

        // Construcción dinámica de la consulta SQL
        String query = ("select * from " + getClase().getSimpleName() + " where "+campo+" = ?");

        // Crear la consulta nativa
        Query sentencia = em.createNativeQuery(query, getClase());

        // Asignar los valores de los parámetros en la consulta
        sentencia.setParameter(1, valor);

        // Ejecutar la consulta y convertir los resultados a una lista de ObjetoGenerico
        ArrayList<T> resultado = (ArrayList<T>) sentencia.getResultList();

        return resultado;
    }

    /**
     * Lee las entidades filtradas por varios campos y valores.
     *
     * @param campos Una lista de nombres de campos para aplicar el filtro.
     * @param valores Una lista de valores de los campos para los filtros.
     * @param <T> El tipo de la entidad.
     * @return Una lista de entidades que cumplen con todas las condiciones.
     */
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

    /**
     * Inserta una nueva entidad en la base de datos.
     *
     * @param objetoGenerico El objeto a insertar en la base de datos.
     * @return true si la inserción fue exitosa.
     */
    public default boolean insert(ObjetoGenerico objetoGenerico){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        // El cast en el main no funciona
        em.persist(objetoGenerico.getClase().cast(objetoGenerico.getInstancia()));
        em.getTransaction().commit();
        return true;
    };

    /**
     * Actualiza una entidad existente en la base de datos.
     *
     * @param objetoGenerico El objeto a actualizar.
     * @return true si la actualización fue exitosa.
     */
    public default boolean update(ObjetoGenerico objetoGenerico){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(objetoGenerico.getClase().cast(objetoGenerico.getInstancia()));
        em.getTransaction().commit();
        return true;
    };

    /**
     * Elimina una entidad de la base de datos.
     *
     * @param objetoGenerico El objeto a eliminar.
     * @return true si la eliminación fue exitosa.
     */
    public default boolean delete(ObjetoGenerico objetoGenerico){
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.remove(objetoGenerico.getClase().cast(objetoGenerico.getInstancia()));
        em.getTransaction().commit();
        return true;
    };

    /**
     * Devuelve la clase de la entidad con la que trabaja la implementación.
     *
     * @return La clase de la entidad.
     */
    public Class<?> getClase();

    /**
     * Devuelve el EntityManager para realizar operaciones JPA.
     *
     * @return El EntityManager.
     */
    public EntityManager getEntityManager();

    /**
     * Devuelve una lista de los campos relevantes de la entidad.
     *
     * @return Una lista de nombres de campos.
     */
    public ArrayList<String> getCampos();

    public <T> T getSimpleData(Object o);

}


