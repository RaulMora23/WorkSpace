import dao.DAO;
import dao.PrestamoDao;
import dao.UsuarioDao;
import dto.Prestamo;
import dto.Usuario;

public class Test {
    public static void main(String[] args) {
        DAO dao = new UsuarioDao();
        Usuario u = dao.read(1);
        System.out.println(u);
        System.out.println(u.getPrestamos());
        dao = new PrestamoDao();
        Prestamo p = dao.read(7);
        System.out.println(p);
        u.devolverPrestamo(p);
        System.out.println(u);
        System.out.println(u.getPrestamos());
        System.out.println(p);
        u.adquirirPrestamo("9781234567890");
        System.out.println(u);
    }
}
