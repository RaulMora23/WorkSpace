package com.example.examen;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Resultado extends AppCompatActivity {
    private TextView tvResultado, resultadoBici, resultadoPatinete, resultadoMonopatin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultado);
        Intent intent = getIntent();
        Bundle datos = getIntent().getExtras();
        tvResultado = (TextView) findViewById(R.id.res);
        resultadoBici = (TextView) findViewById(R.id.resultadoBici);
        resultadoPatinete = (TextView) findViewById(R.id.resultadoPatinete);
        resultadoMonopatin = (TextView) findViewById(R.id.resultadoMonopatín);
        assert datos != null;
        int bici = datos.getInt("Bici");
        int patinete = datos.getInt("Patinete");
        int monopatin = datos.getInt("Monopatin");
        int resultado = datos.getInt("resultado");
        tvResultado.setText(String.valueOf(resultado));
        resultadoBici.setText(String.valueOf(bici));
        resultadoPatinete.setText(String.valueOf(patinete));
        resultadoMonopatin.setText(String.valueOf(monopatin));
    }
}