package com.example.calculadoratemperaturabisiexto;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Temperaturas extends AppCompatActivity {
    private EditText etTemperatura;
    private Switch switchTemperaturas;
    private TextView tvResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.temperaturas);
        etTemperatura = (EditText) findViewById(R.id.temperatura);
        switchTemperaturas = (Switch) findViewById(R.id.switchTemperaturas);
        tvResultado = (TextView) findViewById(R.id.tvResultado);
    }
    public void calcularTemperatura(View view){
        Double resultado;
        Double temp =Double.parseDouble(etTemperatura.getText().toString());
        String resultadoString;
        if(switchTemperaturas.isChecked()){
            resultado = temp * 1.8 + 32;
            resultadoString = "El resultado es: " + resultado + " grados farenheit";
        }
        else {
            resultado = (temp - 32) / 1.8;
            resultadoString = "El resultado es: " + resultado + " grados celsius";
        }
        tvResultado.setText(resultadoString);
    }
}
