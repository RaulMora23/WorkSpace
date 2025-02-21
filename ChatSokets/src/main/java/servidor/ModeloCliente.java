package servidor;

import java.io.*;
import java.net.Socket;
import java.time.LocalDate;

public class ModeloCliente implements Runnable {
    private String nombre;
    private BufferedReader lectura;
    private BufferedWriter escritura;
    private Socket socket;
    private Servidor servidor;

    //Representacion de un cliente
    public ModeloCliente(Socket socket, Servidor servidor) throws IOException {
        this.servidor = servidor;
        this.socket = socket;
        this.escritura = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        this.lectura = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.nombre = null;
    }

    @Override
    public void run() {
        try {
            escritura.write("Introduce un nombre: ");
            escritura.newLine();
            escritura.flush();
            //Lectura Constante
            while (true) {
                String mensaje = lectura.readLine();
                if (mensaje != null) {
                    //El primer mensaje es el nombre
                    if (nombre == null) {
                        setNombre(mensaje);
                        escritura.write("Bienvenido " + nombre);
                        escritura.newLine();
                        escritura.flush();
                    } else {
                        //Acceso sincronizado a un array manejado por varios hilos
                        synchronized (servidor.getClientes()) {
                            //Escribir al resto de sockets
                            for (ModeloCliente modeloCliente : servidor.getClientes()) {
                                if (!modeloCliente.getNombre().equals(nombre)) {
                                    modeloCliente.getEscritura().write(LocalDate.now() + " " + nombre + ": " + mensaje);
                                    modeloCliente.getEscritura().newLine();
                                    modeloCliente.getEscritura().flush();
                                }
                            }
                        }
                        escritura.write("Mensaje enviado a: " + servidor.imprimirClientes(nombre));
                        escritura.newLine();
                        escritura.flush();
                    }

                }
            }
        } catch (IOException e) {
            System.err.println("Error en la comunicación con el cliente: " + e.getMessage());
        } finally {
            try {
                if (socket != null) socket.close();
                if (lectura != null) lectura.close();
                if (escritura != null) escritura.close();
            } catch (IOException e) {
                System.err.println("Error al cerrar los recursos: " + e.getMessage());
            }
        }
    }

    public BufferedWriter getEscritura() {
        return escritura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
