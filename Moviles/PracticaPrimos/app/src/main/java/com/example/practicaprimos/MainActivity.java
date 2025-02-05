package com.example.practicaprimos;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> listaCadenas= new ArrayList<>();
    private ArrayList<Integer> listaNumeros= new ArrayList<>();
    private GridView vistaArray;
    private Button but;
    private EditText entrada;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        vistaArray = findViewById(R.id.gridNumeros);
        but= findViewById(R.id.button);
        entrada= findViewById(R.id.entrada);
        //asignamos el metodo al boton
        but.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                detectarPrimos(Integer.parseInt(String.valueOf(entrada.getText())));
            }
        });
    }
    //Metodo que maneja la lógica del programa
    public void detectarPrimos(int n){
        for (int i = 1; i <= n; i++) {
            listaNumeros.add(i);
            listaCadenas.add(i+"");
        }
        for (int i = 1; i < listaNumeros.size(); i++) {
            if(listaNumeros.contains(i+1)){
                int multiplo =2;
                while(listaNumeros.get(i)*multiplo<n) {
                    if (listaNumeros.contains(listaNumeros.get(i)*multiplo)){
                        listaNumeros.remove(listaNumeros.indexOf(listaNumeros.get(i)*multiplo));
                        listaCadenas.set(listaCadenas.indexOf(listaNumeros.get(i)*multiplo+""),"");
                    }
                    multiplo++;
                }
            }
        }
        //"Instanciamos" la vista del array
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.list_items,  // Layout de cada ítem (usa uno por defecto)
                listaCadenas
        );
        vistaArray.setAdapter(adapter);
    }
}