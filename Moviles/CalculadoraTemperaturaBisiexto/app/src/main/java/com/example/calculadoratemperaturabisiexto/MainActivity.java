package com.example.calculadoratemperaturabisiexto;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void temperaturas(View view){
        Intent intentTemperatura = new Intent(MainActivity.this, Temperaturas.class);
        startActivity(intentTemperatura);
    }
    public void bisiextos(View view){
        Intent intentBisiextos = new Intent(MainActivity.this, Bisiextos.class);
        startActivity(intentBisiextos);
    }
}