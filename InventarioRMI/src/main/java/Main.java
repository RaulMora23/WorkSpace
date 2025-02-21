import servidor.Implementacion;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        System.getProperties().put("","localhost");
        Registry registry = LocateRegistry.createRegistry(5000);
        Implementacion imp = new Implementacion();
        registry.bind("inventario",imp);
    }
}
