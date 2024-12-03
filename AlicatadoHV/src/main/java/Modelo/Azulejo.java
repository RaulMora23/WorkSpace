package Modelo;

public class Azulejo {
    private int ancho;
    private int alto;

    public Azulejo(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }

    public Azulejo invertir() {
        return new Azulejo(alto, ancho);
    }

    @Override
    public String toString() {
        return "{ancho=" + ancho +
                ", alto=" + alto +'}';
    }
}
