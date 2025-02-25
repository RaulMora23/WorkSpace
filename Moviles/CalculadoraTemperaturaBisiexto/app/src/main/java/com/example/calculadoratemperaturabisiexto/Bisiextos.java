package com.example.calculadoratemperaturabisiexto;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Bisiextos extends AppCompatActivity {
    private EditText etAño;
    private TextView tvResultadoAño;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.bisiextos);
        etAño = (EditText) findViewById(R.id.etAño);
        tvResultadoAño = (TextView) findViewById(R.id.tvResultadoAño);
    }
    public void CalcularBisiextos(View view){
        int año = Integer.parseInt(etAño.getText().toString());
        if(año%4==0){
            tvResultadoAño.setText("El año es bisiesto");
        }else{
            tvResultadoAño.setText("El año no es bisiesto");
        }
    }
    public void volver(View view){
        finish();
    }
}

