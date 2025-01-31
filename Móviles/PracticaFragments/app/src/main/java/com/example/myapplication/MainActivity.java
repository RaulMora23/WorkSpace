package com.example.myapplication;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentoNumeros fragmentoNumeros = new FragmentoNumeros();
        FragmentoPalabras fragmentoPalabras = new FragmentoPalabras();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //AÑADIMOS LOS FRAGMENTOS A SUS ESPACIOS RESERVADOS "numeros" y "palabras" e indicamos la clase de esos fragmentos, estos a su vez hacen referencia al XML de la vista
        fragmentTransaction.add(R.id.numeros, fragmentoNumeros);
        fragmentTransaction.add(R.id.palabras, fragmentoPalabras);
        fragmentTransaction.commit();
    }

}