package cliente;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        try {
            //Conexion
            Socket socket = new Socket("localhost", 8080);
            System.out.println("Conectado");
            //Tuberías con el servidor
            BufferedReader lectura = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter escritura = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            //Hilo de lecturascritura.wri
            new Thread(() -> {
                try {
                    String linea;
                    while ((linea = lectura.readLine()) != null) {
                        System.out.println(linea);
                    }
                } catch (IOException e) {
                    System.err.println("Error en la lectura del servidor: " + e.getMessage());
                }
            }).start();
            //Hilo de escritura
            new Thread(() -> {
                try {
                    Scanner teclado = new Scanner(System.in);
                    while (true) {
                        String mensaje = teclado.nextLine();
                        escritura.write(mensaje);
                        escritura.newLine();
                        escritura.flush();
                    }
                } catch (IOException e) {
                    System.err.println("Error en la escritura al servidor: " + e.getMessage());
                }
            }).start();
        } catch (IOException e) {
            System.err.println("Error al conectar con el servidor: " + e.getMessage());
        }
    }
}
