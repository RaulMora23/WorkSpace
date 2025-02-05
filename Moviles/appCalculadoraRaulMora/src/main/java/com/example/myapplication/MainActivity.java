package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    private EditText operando1, operando2;
    private Button operar;
    private RadioButton suma, resta, multiplicacion, division;
    private double resultado;
    private String resultadoString;
    boolean dividir0 = false;
    boolean sinOperandos= false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        operando1 = (EditText) findViewById(R.id.op1);
        operando2 = (EditText) findViewById(R.id.op2);
        suma = (RadioButton) findViewById(R.id.rbSumar);
        resta = (RadioButton) findViewById(R.id.rbRestar);
        multiplicacion = (RadioButton) findViewById(R.id.rbMultiplicar);
        division = (RadioButton) findViewById(R.id.rbDividir);

    }

    public void calcular(View view) {
        if (suma.isChecked()) {
            resultado = Double.parseDouble(operando1.getText().toString()) + Double.parseDouble(operando2.getText().toString());
        } else if (resta.isChecked()) {
            resultado = Double.parseDouble(operando1.getText().toString()) - Double.parseDouble(operando2.getText().toString());
        } else if (multiplicacion.isChecked()) {
            resultado = Double.parseDouble(operando1.getText().toString()) * Double.parseDouble(operando2.getText().toString());
        } else if (division.isChecked()) {
            if (Double.parseDouble(operando2.getText().toString()) == 0) {
                resultadoString = "No se puede dividir por cero";
                dividir0=true;
            } else {
                resultado = Double.parseDouble(operando1.getText().toString()) / Double.parseDouble(operando2.getText().toString());
            }
        }else{
            resultadoString = "Debes seleccionar una operación";
            sinOperandos=true;
        }
        if(!sinOperandos && !dividir0) {
            resultadoString = "El resultado es: " + Double.toString(resultado);
        }
        Intent intent = new Intent(this, Resultado.class);
        intent.putExtra("resultado", resultadoString);
        startActivity(intent);
    }

}