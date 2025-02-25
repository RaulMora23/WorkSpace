package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText operando1, operando2;
    private RadioButton suma, resta, multiplicacion, division;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        operando1 = findViewById(R.id.op1);
        operando2 = findViewById(R.id.op2);
        suma = findViewById(R.id.rbSumar);
        resta = findViewById(R.id.rbRestar);
        multiplicacion = findViewById(R.id.rbMultiplicar);
        division = findViewById(R.id.rbDividir);
    }

    public void calcular(View view) {
        String op1Str = operando1.getText().toString();
        String op2Str = operando2.getText().toString();

        // Input validation
        if (op1Str.isEmpty() || op2Str.isEmpty()) {
            Toast.makeText(this, "Por favor, ingresa ambos operandos", Toast.LENGTH_SHORT).show();
            return;
        }

        double op1, op2;
        try {
            op1 = Double.parseDouble(op1Str);
            op2 = Double.parseDouble(op2Str);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Por favor, ingresa números válidos", Toast.LENGTH_SHORT).show();
            return;
        }

        String resultadoString;

        if (suma.isChecked()) {
            resultadoString = "El resultado es: " + (op1 + op2);
        } else if (resta.isChecked()) {
            resultadoString = "El resultado es: " + (op1 - op2);
        } else if (multiplicacion.isChecked()) {
            resultadoString = "El resultado es: " + (op1 * op2);
        } else if (division.isChecked()) {
            if (op2 == 0) {
                resultadoString = "No se puede dividir por cero";
            } else {
                resultadoString = "El resultado es: " + (op1 / op2);
            }
        } else {
            resultadoString = "Debes seleccionar una operación";
        }

        // Pass the result to the Resultado activity
        Intent intent = new Intent(this, Resultado.class);
        intent.putExtra("resultado", resultadoString);
        startActivity(intent);
    }
}