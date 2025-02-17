package com.example.daobasico;

import android.annotation.SuppressLint;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    Button modificarButton;
    Button EliminarButton;
    Button agregarButton;
    Button buscarButton;
    DAOLibros daoLibros;
    EditText isbnEditText;
    EditText tituloEditText;
    EditText autorEditText;
    RecyclerView recyclerView;
    CustomAdapter customAdapter;
    ArrayList<LibroDTO> libros;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        daoLibros = new DAOLibros(this);
        agregarButton = findViewById(R.id.agregarButton);
        isbnEditText = findViewById(R.id.isbn);
        tituloEditText = findViewById(R.id.titulo);
        autorEditText = findViewById(R.id.autor);
        buscarButton = findViewById(R.id.buscarButton);
        modificarButton = findViewById(R.id.update);
        EliminarButton = findViewById(R.id.eliminar);
        recyclerView = findViewById(R.id.reciclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        libros = new ArrayList<>();
        customAdapter = new CustomAdapter(libros);
        recyclerView.setAdapter(customAdapter);

        EliminarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                daoLibros.eliminarLibro(isbnEditText.getText().toString());
            }
        });


        agregarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                daoLibros.addLibro(isbnEditText.getText().toString(), tituloEditText.getText().toString(), autorEditText.getText().toString());
            }
        });

        buscarButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onClick(View view) {
                String isbn = isbnEditText.getText().toString();
                LibroDTO libroDTO = daoLibros.buscarLibro(isbn);
                libros.add(libroDTO);
                customAdapter.notifyDataSetChanged();
                Toast.makeText(view.getContext(), libroDTO.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        modificarButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                daoLibros.UpdateLibro(isbnEditText.getText().toString(), tituloEditText.getText().toString(), autorEditText.getText().toString());
            }
        });



    }
}