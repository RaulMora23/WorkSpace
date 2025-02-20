package servidor;

import javax.xml.ws.Endpoint;

public class HiloServicio implements Runnable{

    private String ruta;

    public HiloServicio(String ruta) {
        this.ruta=ruta;
    }
    @Override
    public void run() {
        Endpoint.publish(ruta, new Servicio());
        System.out.println( "Servidor iniciado");
    }
}
