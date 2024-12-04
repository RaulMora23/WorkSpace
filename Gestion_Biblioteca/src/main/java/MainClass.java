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
        Usuario u = dao.read(1);
        dao= new PrestamoDao();
        Prestamo p = dao.read(1);
        System.out.println(u);
        System.out.println(u.getPrestamos());
        System.out.println(p);
        u.getPrestamos().contains(p);
        u.devolverPrestamo(p);
        System.out.println(u);
        System.out.println(u.getPrestamos());
        System.out.println(p);
        dao = new UsuarioDao();
        u = dao.read(1);
        dao= new PrestamoDao();
        p = dao.read(1);
        System.out.println(u);
        System.out.println(u.getPrestamos());
        System.out.println(p);

    }
}
