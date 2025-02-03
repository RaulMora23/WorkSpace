package com.example.calculadoratemperaturabisiexto;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Temperaturas extends AppCompatActivity {
    private EditText etTemperatura;
    private Switch switchTemperaturas;
    private TextView tvResultado;
    private RadioButton celsiusUp;
    private RadioButton centigradosUp;
    private RadioButton FHUp;
    private RadioButton celsiusDown;
    private RadioButton centigradosDown;
    private RadioButton FHDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.temperaturas);
        etTemperatura = (EditText) findViewById(R.id.temperatura);
        celsiusUp = (RadioButton) findViewById(R.id.celsiusUp);
        centigradosUp = (RadioButton) findViewById(R.id.centigradosUp);
        FHUp = (RadioButton) findViewById(R.id.FHUp);
        celsiusDown = (RadioButton) findViewById(R.id.celsiusDown);
        centigradosDown = (RadioButton) findViewById(R.id.centigradosDown);
        FHDown = (RadioButton) findViewById(R.id.FHDown);
        tvResultado = (TextView) findViewById(R.id.tvResultadoAño);
    }
    public void calcularTemperatura(View view){
        Double resultado;
        Double temp =Double.parseDouble(etTemperatura.getText().toString());
        String resultadoString;
        if(celsiusUp.isChecked()&&centigradosDown.isChecked()){
         temp=temp+273.15;
         resultadoString="La temperatura en kelvin es: "+temp;
        } else if(celsiusUp.isChecked()&&FHDown.isChecked()){
            temp=(temp*9/5)+32;
            resultadoString="La temperatura en Fahrenheit es: "+temp;
        }else if(centigradosUp.isChecked()&&celsiusDown.isChecked()){
            temp=temp-273.15;
            resultadoString="La temperatura en celsius es: "+temp;
        }else if(centigradosUp.isChecked()&&FHDown.isChecked()){
            temp=(temp-273.15)*9/5+32;
            resultadoString="La temperatura en Fahrenheit es: "+temp;
        }else if(FHUp.isChecked()&&celsiusDown.isChecked()){
            temp=(temp-32)*5/9;
            resultadoString="La temperatura en celsius es: "+temp;
        }else if(FHUp.isChecked()&&centigradosDown.isChecked()){
            temp=(temp-32)*5/9+273.15;
            resultadoString="La temperatura en kelvin es: "+temp;
        }else {
            resultadoString="No has seleccionado una conversion correcta";
        }
        tvResultado.setText(resultadoString);
    }
}
