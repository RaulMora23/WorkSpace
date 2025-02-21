package servidor;

public interface Interfaz extends java.rmi.Remote{
    public String consultarProductos() throws java.rmi.RemoteException;
    public int consultarStock(String indice) throws java.rmi.RemoteException;
    public String modificarStock(String indice,int cantidad) throws java.rmi.RemoteException;
    public String anadirProducto(String nombre,int cantidad) throws java.rmi.RemoteException;
}
