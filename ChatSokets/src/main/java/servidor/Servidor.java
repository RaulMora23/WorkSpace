package servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor implements Runnable {
    private ArrayList<ModeloCliente> modeloClientes = new ArrayList<>();
    private ServerSocket serverSocket;

    public Servidor(int puerto) throws IOException {
        this.serverSocket = new ServerSocket(puerto);
    }

    @Override
    public void run() {
        try {
            while (true) {
                Socket socket = serverSocket.accept();
                ModeloCliente modeloCliente = new ModeloCliente(socket, this);
                synchronized (modeloClientes) {
                    modeloClientes.add(modeloCliente);
                }
                new Thread(modeloCliente).start();
                System.out.println("Conectado");
            }
        } catch (IOException e) {
            System.err.println("Error en el servidor: " + e.getMessage());
        } finally {
            try {
                if (serverSocket != null) serverSocket.close();
            } catch (IOException e) {
                System.err.println("Error al cerrar el servidor: " + e.getMessage());
            }
        }
    }

    public synchronized ArrayList<ModeloCliente> getClientes() {
        return modeloClientes;
    }

    public synchronized String imprimirClientes(String nombre) {
        StringBuilder cadena = new StringBuilder();
        for (ModeloCliente modeloCliente : modeloClientes) {
            if( !modeloCliente.getNombre().equals(nombre)) {
                cadena.append(modeloCliente.toString()).append(",");
            }
        }
        if (cadena.length() > 0) cadena.setLength(cadena.length() - 1);
        return cadena.toString();
    }
}
