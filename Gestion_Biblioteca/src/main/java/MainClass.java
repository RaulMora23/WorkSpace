import dao.*;
import dto.Libro;
import dto.Prestamo;
import dto.Usuario;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        DAO dao = new PrestamoDao();
        ArrayList<Prestamo> arrayList = dao.readBy("usuario_id", String.valueOf(1));
        System.out.println(arrayList.getFirst());
    }
}
