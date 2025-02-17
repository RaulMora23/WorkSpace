package com.example.contraseas;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Map;

public class Controller extends AppCompatActivity {
    private EditText etNombre, etContrasena;
    private SharedPreferences sP;
    private ImageView imagen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        etNombre = findViewById(R.id.etNombre);
        etContrasena = findViewById(R.id.etContrasena);
        imagen = findViewById(R.id.imageView);
        sP = getSharedPreferences("contraseñas", MODE_PRIVATE);
        Map<String, ?> mapa =sP.getAll();
    }
    public void registrar(View view) {
        String nombre = etNombre.getText().toString();
        String contrasena = etContrasena.getText().toString();
        Map<String, ?> mapa =sP.getAll();
        if(!mapa.containsKey(nombre)) {
            sP.edit().putString(nombre, contrasena).apply();
        }else{
            etNombre.setError("Ya existe ese nombre");
        }
    }
    public void acceder(View view) {
        Map<String, ?> mapa =sP.getAll();
        try{
            if(mapa.get(etNombre.getText().toString()).equals(etContrasena.getText().toString())){
                imagen.setVisibility(View.VISIBLE);
            }else{
                etContrasena.setError("Contraseña incorrecta");
                imagen.setVisibility(View.INVISIBLE);
            }
        }catch (NullPointerException e){
            etContrasena.setError("Contraseña incorrecta");
            imagen.setVisibility(View.INVISIBLE);
        }
    }
}
