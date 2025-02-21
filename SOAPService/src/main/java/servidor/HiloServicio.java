package servidor;

import javax.xml.ws.Endpoint;

public class HiloServicio implements Runnable{

    private String ruta;
    //Esto no hace falta, pero no quería correr dos main
    public HiloServicio(String ruta) {
        this.ruta=ruta;
    }
    @Override
    public void run() {

    }
}
