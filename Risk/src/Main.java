public class Main {
    public static void main(String[] args) {
        Ejercito ejercitoRojo = new Ejercito("R",true,5);
        Ejercito ejercitoAzul = new Ejercito("A",false,5);
        while(ejercitoRojo.getTropas()>0 && ejercitoAzul.getTropas()>0){
            ejercitoRojo.batallar(ejercitoAzul);
        }
        if(ejercitoRojo.getTropas()>0){
            System.out.println("Ejercito Rojo gana: " + ejercitoRojo.getTropas()+" tropas a 0");
        }else{
            System.out.println("Ejercito Azul gana: " + ejercitoAzul.getTropas()+" tropasa a 0");
        }
    }
}