import dao.*;
import dto.Libro;
import dto.Prestamo;
import dto.Usuario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        DAO dao = new UsuarioDao();
//        dao.getClase().cast(dao.readBy(new ArrayList<String>(Arrays.asList("titulo")), new ArrayList<String>(Arrays.asList("1984"))).getFirst().getInstancia());
//        System.out.println(libro.getEjemplares());
//        Libro libro = (Libro) dao.readBy(new ArrayList<String>(Arrays.asList("titulo")), new ArrayList<String>(Arrays.asList("1988"))).getFirst().getInstancia();
//        libro.setTitulo("1988");
//        dao.update(new ObjetoGenerico(libro,libro.getClass()));
//        for(ObjetoGenerico o : dao.readAll()){
//            System.out.println(o.getInstancia().getClass().getSimpleName());
//        }
        Usuario u = (Usuario) dao.read(1).getInstancia();
        dao= new PrestamoDao();
        Prestamo p = (Prestamo) dao.read(3).getInstancia();
        u.devolverPrestamo(p);
        u.actualizarRegistro();
        p.actualizarRegistro();
        System.out.println(u);
        System.out.println(u.getPrestamos());
        System.out.println(p);

    }
}
