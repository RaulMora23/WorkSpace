package com.example.examen2;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Libro> libros = new ArrayList<>();
    LibroAdapter adapter;
    DAOLibros dao;
    EditText etTitulo, etAutor, etAno, etGenero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //Recogemos los nodos de la vista
        etTitulo = findViewById(R.id.etTitulo);
        etAutor = findViewById(R.id.etAutor);
        etAno = findViewById(R.id.etAno);
        etGenero = findViewById(R.id.etGenero);

        //Configuramos el RV
        RecyclerView rv = findViewById(R.id.rV);
        rv.setLayoutManager(new LinearLayoutManager(this));
        LibroAdapter adapter = new LibroAdapter(libros,this);
        rv.setAdapter(adapter);

        //Instanciamos el Dao
        dao = new DAOLibros(this);
    }
    public void crearLibro(View view) {
        Libro libro= null;
        if (etTitulo.getText()!=null && etAutor.getText()!=null && etAno.getText() != null && etGenero.getText()!=null ) {
            long id = dao.addLibro(etTitulo.getText().toString(), etAutor.getText().toString(), Integer.parseInt(etAno.getText().toString()), etGenero.getText().toString());
            //Se creo en la bbdd, lo añadimos a la lista
            if(id!=0){
                libro = new Libro(id,etTitulo.getText().toString(), etAutor.getText().toString(), Integer.parseInt(etAno.getText().toString()), etGenero.getText().toString());
                libros.add(libro);
                adapter.notifyItemInserted(libros.size());
            }
        }
    }
}