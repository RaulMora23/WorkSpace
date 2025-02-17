package com.example.daobasico;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class DAOLibros {
    MyDataBaseHelper con;
    SQLiteDatabase db;
    Context context;
    public DAOLibros(Context context) {
        this.context = context;
        con = new MyDataBaseHelper(context, "bd_biblioteca", null,1);
        db = con.getWritableDatabase();
    }
    public void addLibro(String isbn, String titulo, String autor) {
        ContentValues values = new ContentValues();
        values.put(Utilidades.Campo_ISBN, isbn);
        values.put(Utilidades.Campo_Titulo, titulo);
        values.put(Utilidades.Campo_Autor, autor);
        long idResultante = db.insert(Utilidades.Tabla_Libro, Utilidades.Campo_ISBN, values);

        Toast.makeText(context, "ID Resultante: " + idResultante, Toast.LENGTH_SHORT).show();
    }
    public LibroDTO buscarLibro(String isbn){
        String[] campos =  {Utilidades.Campo_Titulo, Utilidades.Campo_ISBN, Utilidades.Campo_Autor};
        String[] parametros = {isbn};
        Cursor cursor = db.query(Utilidades.Tabla_Libro, campos, Utilidades.Campo_ISBN +"=?",parametros,null,null,null);

        if (cursor.moveToFirst()){
            String Isbn = cursor.getString(0);
            String titulo = cursor.getString(1);
            String autor = cursor.getString(2);

            return new LibroDTO(Isbn, titulo, autor);

        }
        return null;
    }
    public void UpdateLibro(String isbn, String titulo, String autor) {
        String[] parametros = {isbn};
        String[] camposVisualizados = {Utilidades.Campo_Titulo, Utilidades.Campo_ISBN, Utilidades.Campo_Autor};

        Cursor cursor = db.query(Utilidades.Tabla_Libro, camposVisualizados, Utilidades.Campo_ISBN + "=?", parametros, null, null, null);
        if (cursor.moveToFirst()) {
            String libroTitulo = cursor.getString(1);
            String libroAutor = cursor.getString(2);
            ContentValues contentValues = new ContentValues();
            contentValues.put(Utilidades.Campo_Titulo, campoNoVacio(titulo, libroTitulo));
            contentValues.put(Utilidades.Campo_Autor, campoNoVacio(autor, libroAutor));
            int filasAfectadas = db.update(Utilidades.Tabla_Libro, contentValues, Utilidades.Campo_ISBN + "=?", parametros);
            if (filasAfectadas > 0) {
                mostrarMensaje("Los valores se han modificado correctamente.");
            } else {
                mostrarMensaje("No se realizaron cambios.");
            }
        }
    }

    public void eliminarLibro(String isbn){
        con = new MyDataBaseHelper(context, "bd_biblioteca", null, 1);
        db = con.getWritableDatabase();
        String[] parametros = {isbn};
        int resultado = db.delete(Utilidades.Tabla_Libro, Utilidades.Campo_ISBN + "=?", parametros);
        db.close();
        if (resultado > 0) {
            Toast.makeText(context, "Eliminado", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Isbn no Encontrado", Toast.LENGTH_SHORT).show();
        }
    }
    private String campoNoVacio(String texto, String valorPorDefecto) {
        return texto.isEmpty() ? valorPorDefecto : texto;
    }
    private void mostrarMensaje(String mensaje) {
        Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show();
    }

}
