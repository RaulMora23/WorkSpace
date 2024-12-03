import dao.DAO;
import dao.LibroDao;
import dao.PrestamoDao;
import dao.UsuarioDao;
import dto.Usuario;

public class MainClass {
    public static void main(String[] args) {
        DAO dao = new UsuarioDao();
        System.out.println(dao.getClase().cast(dao.read(1).getInstancia()));
    }
}
