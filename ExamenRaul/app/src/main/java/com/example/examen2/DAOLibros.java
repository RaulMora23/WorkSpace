package com.example.examen2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DAOLibros {
    MyDataBaseHelper con;
    SQLiteDatabase db;
    Context context;
    public DAOLibros(Context context) {
        this.context = context;
        con = new MyDataBaseHelper(context, "bd_biblioteca", null,1);
        db = con.getWritableDatabase();
    }
    public long addLibro(String titulo, String autor, Integer ano, String genero) {
        ContentValues values = new ContentValues();
        values.put(Utilidades.Campo_Genero, genero);
        values.put(Utilidades.Campo_Titulo, titulo);
        values.put(Utilidades.Campo_Autor, autor);
        values.put(Utilidades.Campo_Ano, ano);
        //Obtenemos id para verificar
        long idResultante = db.insert(Utilidades.Tabla_Libro, null, values);
        if(idResultante!=0){
            Toast.makeText(context, "Creado", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "No creado", Toast.LENGTH_SHORT).show();
        }
        //Devolvemos el id autogenerado para asignarselo a libro
        return idResultante;
    }



    public void eliminarLibro(long id){
        con = new MyDataBaseHelper(context, "bd_biblioteca", null, 1);
        db = con.getWritableDatabase();
        String[] parametros = {id+""};
        int resultado = db.delete(Utilidades.Tabla_Libro, "ID=?", parametros);
        db.close();
        if (resultado > 0) {
            Toast.makeText(context, "Eliminado", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Isbn no Encontrado", Toast.LENGTH_SHORT).show();
        }
    }
    public List<Libro> getLibros(){
        ArrayList<Libro> libros = new ArrayList<>();
        Cursor cursor = db.query(Utilidades.Tabla_Libro,null,null,null,null,null,null);
        while (cursor.moveToNext()){
            libros.add(new Libro(cursor.getLong(0),cursor.getString(1),cursor.getString(2),cursor.getInt(4),cursor.getString(3)));
        }
        return libros;
    }

}
