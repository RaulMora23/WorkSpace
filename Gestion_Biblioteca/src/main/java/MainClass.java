import dao.DAO;
import dao.LibroDao;
import dao.PrestamoDao;
import dao.UsuarioDao;
import dto.Libro;
import dto.Usuario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        DAO dao = new LibroDao();
        Libro libro = (Libro) dao.readBy(new ArrayList<String>(Arrays.asList("titulo")), new ArrayList<String>(Arrays.asList("1984"))).getFirst().getInstancia();
        System.out.println(libro.getEjemplares());
    }
}
