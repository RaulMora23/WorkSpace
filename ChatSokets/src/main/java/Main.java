import servidor.ModeloCliente;
import servidor.Servidor;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    ArrayList<ModeloCliente> modeloClientes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Servidor servidor = new Servidor(8080);
        new Thread(servidor).start();
        System.out.println("Servidor iniciado");
        //Se podría abrir mas de un chat
    }
}
