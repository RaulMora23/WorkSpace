package cliente;

import servidor.Interfaz;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry reg = LocateRegistry.getRegistry("localhost",5000);
        Interfaz inventario = (Interfaz) reg.lookup("inventario");
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println(inventario.consultarProductos());
            System.out.println("1. Consultar Stock\n2. Modificar Stock\n3. Anadir Producto");
            int opcion = sc.nextInt();
            switch (opcion){
                case 1: {
                    System.out.println("Ingrese el nombre del producto");
                    String indice = sc.next();
                    System.out.println("El stock es: " + inventario.consultarStock(indice));
                    break;
                }
                case 2:{
                    System.out.println("Ingrese el nombre del producto");
                    String indice = sc.next();
                    System.out.println("Ingrese la cantidad a modificar");
                    int cantidad = sc.nextInt();
                    System.out.println("El stock es: "+inventario.modificarStock(indice,cantidad));
                    break;}
                case 3:{
                    System.out.println("Ingrese el nombre del producto");
                    String nombre = sc.next();
                    System.out.println("Ingrese la cantidad a anadir");
                    int cantidad = sc.nextInt();
                    System.out.println(inventario.anadirProducto(nombre,cantidad));
                }
            }
        }
    }
}
