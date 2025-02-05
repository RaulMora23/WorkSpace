package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentoNumeros extends Fragment {

    private EditText editable;
    private Button but;
    private TextView resultado;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_numeros, container, false);
        editable = view.findViewById(R.id.editNumeros);
        but = view.findViewById(R.id.botonPalabra);
        resultado = view.findViewById(R.id.resultadoPalabra);
        //EN LUGAR DE HACERLO DESDE EL XML QUE NO FUNCIONA LO HAGO ASÍ, SEGUN MI PRIMO CUANDO PULSO EL BOTON ESTA BUSCANDO EL METODO EN LA CLASE MAIN Y NO EN EL FRAGMENT
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularParImpar(but.getRootView());
            }
        });
        return view;
    }

    public void calcularParImpar(View view){
        Double entrada = Double.parseDouble(String.valueOf(editable.getText())) ;
        if(entrada%2==0){
            resultado.setText("El número es par");
        }else{
            resultado.setText("El número es impar");
        }
    }
}
