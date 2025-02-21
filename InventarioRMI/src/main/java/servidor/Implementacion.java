package servidor;

import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class Implementacion extends UnicastRemoteObject implements Interfaz {
    Map<String,Integer> almacen = new HashMap<>();


    public Implementacion() throws java.rmi.RemoteException {
        super();
        almacen.put("papel", 10);
        almacen.put("libro", 10);
        almacen.put("celular", 10);
        almacen.put("pantalla", 10);
    }

    @Override
    public String consultarProductos() {
        return String.join(",",almacen.keySet());
    }

    @Override
    public int consultarStock(String producto) {
        return almacen.get(producto);
    }

    @Override
    public String modificarStock(String producto, int cantidad) {
        almacen.put(producto, almacen.get(producto) + cantidad);
        return producto +": "+almacen.get(producto);
    }

    @Override
    public String anadirProducto(String nombre, int cantidad) {
        almacen.put(nombre, cantidad);
        return "Producto añadido";
    }
}
