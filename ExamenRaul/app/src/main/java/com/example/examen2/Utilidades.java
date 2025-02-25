package com.example.examen2;

public class Utilidades {


    public static final String Tabla_Libro = "Libro";
    public static final String Campo_Genero = "Genero";
    public static final String Campo_Titulo = "Titulo";
    public static final String Campo_Autor = "Autor";

    public static final String Campo_Ano = "Ano";


    public static final String Crear_tabla_Libro = "CREATE TABLE " + Tabla_Libro + " ("
            + "ID" + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + Campo_Titulo + " TEXT NOT NULL, "
            + Campo_Autor + " TEXT NOT NULL, "
            + Campo_Genero + " TEXT NOT NULL, "
            + Campo_Ano + " INTEGER NOT NULL "
            + ");";
}
