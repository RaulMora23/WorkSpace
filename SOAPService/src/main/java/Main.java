import servidor.HiloServicio;
import servidor.ModeloServicio;
import servidor.Servicio;

import javax.xml.namespace.QName;
import javax.xml.ws.Endpoint;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;


//Añadir vm option
public class Main {
    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        String ruta = "http://localhost:8080/servidor/";
        Endpoint.publish(ruta, new Servicio());
        System.out.println( "Servidor iniciado");
        // Esperamos a que cargue el servidor
        Thread.sleep(3000);

        URL url = new URL(ruta);
        //Hay que añadir Service al nombre de la clase "Servicio"
        //y la url corresponde al paquete
        QName qname = new QName("http://servidor/", "ServicioService");
        //Esta clase establece nuestro punto de acceso al servicio
        Service service = Service.create(url, qname);
        //Desde nuestra interfaz ModeloServicio almacenamos una instancia de la clase Servicio
        //Indicamos la interfaz
        ModeloServicio servicio = service.getPort(ModeloServicio.class);

        Scanner teclado = new Scanner(System.in);
        //Ahora podemos acceder a los métodos implementados en Servicio, en el servidor
        System.out.println(servicio.getEquipos());
        while(true) {
            System.out.println("Introduce el indice de un equipo");
            int indice = teclado.nextInt();
            System.out.println(servicio.getEntrenador(indice));
            System.out.println(servicio.getPlantilla(indice));
        }
    }
}
