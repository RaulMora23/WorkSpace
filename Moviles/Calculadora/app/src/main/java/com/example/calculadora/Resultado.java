package com.example.calculadora;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Resultado extends AppCompatActivity {
    private TextView tvResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultado);
        Bundle datos = getIntent().getExtras();
        tvResultado = (TextView) findViewById(R.id.res);
        String resultado = datos.getString("resultado");
        tvResultado.setText(resultado);
    }
}
