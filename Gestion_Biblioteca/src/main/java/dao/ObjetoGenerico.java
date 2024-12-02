package dao;

public class ObjetoGenerico {
    private final Object instancia;
    private final Class<?> clase;
    public ObjetoGenerico(Object instancia, Class<?> clase) {
        this.instancia = instancia;
        this.clase = clase;
    }
    public Object getInstancia() {
        return instancia;
    }
    public Class<?> getClase() {
        return clase;
    }
}
