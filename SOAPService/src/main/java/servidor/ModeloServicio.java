package servidor;

import javax.jws.WebMethod;
import javax.jws.WebService;
/** Esta interfaz define un servicio web SOAP
el cliente debe tener una copia de esta interfaz,
que es lo que se va a manejar en el cliente*/
@WebService

public interface ModeloServicio {

    @WebMethod
    String getEntrenador(int indice);
    @WebMethod
    int getPlantilla(int indice);

    String getEquipos();
}
