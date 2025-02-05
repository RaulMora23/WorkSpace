package com.example.libreriapancho;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Libro> libros = new ArrayList<>();
    LibroAdapter adapter = new LibroAdapter(libros);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        libros.add(new Libro("978-3-16-148410-0", "El Quijote", "Miguel de Cervantes", false, "Un clásico de la literatura española."));
        libros.add(new Libro("978-0-7432-7356-5", "1984", "George Orwell", true, "Distopía futurista sobre el totalitarismo."));
        RecyclerView rv = findViewById(R.id.recyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this));
        LibroAdapter adapter = new LibroAdapter(libros);
        rv.setAdapter(adapter);
    }
    public void crearLibro(View view) {
        Libro libro = new Libro("ISBN", "Título", "Autor", false, "Descripción");
        libros.add(libro);
        adapter.notifyItemInserted(libros.size());
    }
}