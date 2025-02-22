package varios;

import java.sql.Connection;
import java.sql.SQLException;

import sql.SQL;

public class CrearGestionBiblioteca {
    public static void ejecutar(Connection conx) throws SQLException {
        try {
            // Crear la base de datos 'Biblioteca'
            SQL.ejecutarSql(conx, "CREATE DATABASE IF NOT EXISTS Biblioteca");

            // Usar la base de datos 'Biblioteca'
            SQL.ejecutarSql(conx, "USE Biblioteca");

            // Crear la tabla 'Usuario'
            SQL.ejecutarSql(conx, "CREATE TABLE IF NOT EXISTS Usuario (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "nombre VARCHAR(100) NOT NULL" +
                    ")");

            // Crear la tabla 'Autor'
            SQL.ejecutarSql(conx, "CREATE TABLE IF NOT EXISTS Autor (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "nombre VARCHAR(100) NOT NULL" +
                    ")");

            // Crear la tabla 'Libro'
            SQL.ejecutarSql(conx, "CREATE TABLE IF NOT EXISTS Libro (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "titulo VARCHAR(100) NOT NULL, " +
                    "isbn VARCHAR(20) NOT NULL" +
                    ")");

            // Crear la tabla 'Prestamo'
            SQL.ejecutarSql(conx, "CREATE TABLE IF NOT EXISTS Prestamo (" +
                    "id INT PRIMARY KEY AUTO_INCREMENT, " +
                    "fechaInicio DATE NOT NULL, " +
                    "fechaFin DATE NOT NULL, " +
                    "usuarioId INT NOT NULL, " +
                    "libroId INT NOT NULL, " +
                    "FOREIGN KEY (usuarioId) REFERENCES Usuario(id) ON DELETE CASCADE, " +
                    "FOREIGN KEY (libroId) REFERENCES Libro(id) ON DELETE CASCADE" +
                    ")");

            // Crear la tabla intermedia 'Libro_Autor'
            SQL.ejecutarSql(conx, "CREATE TABLE IF NOT EXISTS Libro_Autor (" +
                    "idLibro INT NOT NULL, " +
                    "idAutor INT NOT NULL, " +
                    "PRIMARY KEY (idLibro, idAutor), " +
                    "FOREIGN KEY (idLibro) REFERENCES Libro(id) ON DELETE CASCADE, " +
                    "FOREIGN KEY (idAutor) REFERENCES Autor(id) ON DELETE CASCADE" +
                    ")");

            // Insertar datos en la tabla 'Usuario'
            SQL.ejecutarSql(conx, "INSERT INTO Usuario (nombre) VALUES " +
                    "('Juan Pérez'), " +
                    "('María López'), " +
                    "('Carlos García'), " +
                    "('Ana Fernández'), " +
                    "('Luis Martínez');");

            // Insertar datos en la tabla 'Autor'
            SQL.ejecutarSql(conx, "INSERT INTO Autor (nombre) VALUES " +
                    "('Gabriel García Márquez'), " +
                    "('Isabel Allende'), " +
                    "('Mario Vargas Llosa'), " +
                    "('Jorge Luis Borges'), " +
                    "('Julio Cortázar');");

            // Insertar datos en la tabla 'Libro'
            SQL.ejecutarSql(conx, "INSERT INTO Libro (titulo, isbn) VALUES " +
                    "('Cien Años de Soledad', '978-8437604947'), " +
                    "('La Casa de los Espíritus', '978-8497592200'), " +
                    "('La Ciudad y los Perros', '978-0679733038'), " +
                    "('El Aleph', '978-8420658728'), " +
                    "('Rayuela', '978-8466332525');");

            // Insertar datos en la tabla intermedia 'Libro_Autor'
            SQL.ejecutarSql(conx, "INSERT INTO Libro_Autor (idLibro, idAutor) VALUES " +
                    "(1, 1), " + // Cien Años de Soledad -> Gabriel García Márquez
                    "(2, 2), " + // La Casa de los Espíritus -> Isabel Allende
                    "(3, 3), " + // La Ciudad y los Perros -> Mario Vargas Llosa
                    "(4, 4), " + // El Aleph -> Jorge Luis Borges
                    "(5, 5), " + // Rayuela -> Julio Cortázar
                    "(5, 4);"); // Rayuela también está relacionado con Jorge Luis Borges

            // Insertar datos en la tabla 'Prestamo'
            SQL.ejecutarSql(conx, "INSERT INTO Prestamo (fechaInicio, fechaFin, usuarioId, libroId) VALUES " +
                    "('2023-10-01', '2023-10-15', 1, 1), " + // Juan Pérez -> Cien Años de Soledad
                    "('2023-09-20', '2023-10-05', 2, 2), " + // María López -> La Casa de los Espíritus
                    "('2023-10-05', '2023-10-20', 3, 3), " + // Carlos García -> La Ciudad y los Perros
                    "('2023-09-30', '2023-10-15', 4, 4), " + // Ana Fernández -> El Aleph
                    "('2023-10-01', '2023-10-10', 5, 5);"); // Luis Martínez -> Rayuela

            System.out.println("Base de datos 'Biblioteca' creada con tablas y registros insertados.");
        } catch (SQLException e) {
            System.err.println("Error al ejecutar las operaciones en la base de datos: " + e.getMessage());
            throw e; // Opcionalmente puedes volver a lanzar la excepción
        }
    }
}
