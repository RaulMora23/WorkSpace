package com.example.examen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText numeroBici, numeroPatinete, numeroMonopatin;
    private RadioButton rbBici, rbPatinete, rbMonopatin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        numeroBici = (EditText) findViewById(R.id.nBici);
        numeroPatinete = (EditText) findViewById(R.id.nPatinete);
        numeroMonopatin = (EditText) findViewById(R.id.nMonopatin);
        rbBici = (RadioButton) findViewById(R.id.rbBici);
        rbPatinete = (RadioButton) findViewById(R.id.rbPatinete);
        rbMonopatin = (RadioButton) findViewById(R.id.rbMonopatin);
    }

    public void calcular(View view) {
        String vadim = numeroBici.getText().toString();
        System.out.println(vadim);
        int total = 0;
        int totalBici = 0;
        int totalPatinete = 0;
        int totalMonopatin = 0;
        if (rbBici.isChecked()) {
            totalBici = (Integer.parseInt(numeroBici.getText().toString()) * 2);
            total = total + totalBici;
        }
        if (rbPatinete.isChecked()) {
            totalPatinete = (Integer.parseInt(numeroPatinete.getText().toString()) * 3);
            total = total + totalPatinete;
        }
        if (rbMonopatin.isChecked()) {
            totalMonopatin = (Integer.parseInt(numeroMonopatin.getText().toString()) * 5);
            total = total + totalMonopatin;
        }
        Intent intent = new Intent(MainActivity.this, Resultado.class);
        intent.putExtra("Bici", totalBici);
        intent.putExtra("Monopatin", totalMonopatin);
        intent.putExtra("Patinete", totalPatinete);
        intent.putExtra("resultado", total);
        startActivity(intent);
    }
}