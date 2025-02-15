package com.example.modificarfichero;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private EditText etNombre, etContenido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        etNombre = findViewById(R.id.etNombre);
        etContenido = findViewById(R.id.etContenido);
    }

    public void crearFichero(View view) throws IOException {
        String nombreFichero = etNombre.getText().toString();
        File fichero = new File(getFilesDir(), nombreFichero);
        fichero.createNewFile();
    }
    public void leerFichero(View view) throws IOException {
        String nombreFichero = etNombre.getText().toString();
        crearFichero(view);
        BufferedReader br = new BufferedReader(new FileReader(new File(getFilesDir(), nombreFichero)));
        String contenido = "";
        String linea = br.readLine();
        while (linea!=null) {
            contenido += linea;
            linea = br.readLine();
        }
        etContenido.setText(contenido);
        br.close();
    }
    public void guardarFichero(View view) throws IOException {
        String contenido = etContenido.getText().toString();
        String nombreFichero = etNombre.getText().toString();
        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(getFilesDir(), nombreFichero)));
        bw.write(contenido);
        bw.close();
    }

}