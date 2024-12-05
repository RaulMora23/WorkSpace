import dao.*;
import dto.Libro;
import dto.Prestamo;
import dto.Usuario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        DAO dao = new EjemplarDao();
        System.out.println(dao.readBy(List.of("isbn", "estado"),List.of("9781111111111", "DISPONIBLE")));

    }
}
