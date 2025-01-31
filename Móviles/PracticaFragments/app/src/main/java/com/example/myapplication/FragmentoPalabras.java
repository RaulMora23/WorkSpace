package com.example.myapplication;

import android.graphics.Typeface;
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

public class FragmentoPalabras extends Fragment {
    private EditText editable;
    private Button but;
    private TextView resultado;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_palabras, container, false);
        editable = view.findViewById(R.id.editPalabras);
        but = view.findViewById(R.id.botonPalabra);
        resultado = view.findViewById(R.id.resultadoPalabra);
        //EN LUGAR DE HACERLO DESDE EL XML QUE NO FUNCIONA LO HAGO ASÍ, SEGUN MI PRIMO CUANDO PULSO EL BOTON ESTA BUSCANDO EL METODO EN LA CLASE MAIN Y NO EN EL FRAGMENT
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertirPalabra(but.getRootView());
            }
        });
        return view;
    }
    public void convertirPalabra(View view){
        String entrada = String.valueOf(editable.getText()) ;
        resultado.setTypeface(null, Typeface.BOLD);
        resultado.setText(entrada.toUpperCase());
    }
}
