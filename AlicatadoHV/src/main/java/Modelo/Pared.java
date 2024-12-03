package Modelo;

public class Pared {

    private final int ancho;
    private final int alto;
    private Azulejo azulejo;

    public Pared(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
    }

    //Supongo que no se pueden reutilizar las dos partes al fragmentar el azulejo,
    // porque de ser así se podrían fragmentar los aulejos de manera recurrente
    // y unirlos para hacer la forma deseada reduciendo el gasto de azulejos a <1 en todos los casos.
    public int getHorizontales() {
        double azulejosHorizontales = (double) ancho / azulejo.getAncho();
        //Si sale decimal necesitas un azulejo más
        if (ancho%azulejo.getAncho()!=0){
            azulejosHorizontales++;
        }
        return (int) azulejosHorizontales;
    }

    public int getVerticales() {
        double azulejosVerticales = (double) alto / azulejo.getAlto();
        if (alto%azulejo.getAlto()!=0){
            azulejosVerticales++;
        }
        return (int) azulejosVerticales;
    }

    public int getAzulejosTotales(Azulejo azulejo) {
        this.azulejo = azulejo;
        //multiplicar ancho por alto para obtener el total de azulejos
        return getVerticales()*getHorizontales();
    }

}
