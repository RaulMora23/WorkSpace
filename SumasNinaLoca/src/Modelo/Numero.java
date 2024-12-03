package Modelo;

import java.util.ArrayList;
import java.util.Arrays;

public class Numero {
    int numero;
    String numeroString;
    ArrayList<Character> caracteres= new ArrayList<>();
    
    public Numero(int numero) {
        this.numero = numero;
        numeroString = String.valueOf(numero);
        for (char c:String.valueOf(numero).toCharArray()){
            caracteres.add(c);
        }

    }
}
