package Modelo;

public class MejorOpcion {
    String resultado="";

    public MejorOpcion(Pared pared, Azulejo azulejo) {
        //comparación de dos paredes
        if(pared.getAzulejosTotales(azulejo)<pared.getAzulejosTotales(azulejo.invertir())){
            resultado= "La mejor opción es "+azulejo+", solo necesitas "+pared.getAzulejosTotales(azulejo)+
            " frente a los "+pared.getAzulejosTotales(azulejo.invertir())+" de "+azulejo.invertir();
        } else if (pared.getAzulejosTotales(azulejo)>pared.getAzulejosTotales(azulejo.invertir())) {
            resultado= "La mejor opción es "+azulejo.invertir()+", solo necesitas "+pared.getAzulejosTotales(azulejo.invertir())+
                    " frente a los "+pared.getAzulejosTotales(azulejo)+" de "+azulejo;
        }else {
            resultado= "Es indiferente: "+azulejo.invertir()+" necesita "+pared.getAzulejosTotales(azulejo.invertir())+
                    " frente a los "+pared.getAzulejosTotales(azulejo)+" de "+azulejo;
        }
    }

    @Override
    public String toString() {
        return resultado;
    }
}
