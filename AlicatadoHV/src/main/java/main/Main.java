package main;

import Modelo.Azulejo;
import Modelo.MejorOpcion;
import Modelo.Pared;

public class Main {
    public static void main(String[] args) {
        System.out.println(new MejorOpcion(new Pared(11,7),new Azulejo(1,2)));
    }
}
