package com.example.firebase;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
//Antes de nada Tool, firebase, realtime database, connect, configurar privacidad(true), sdk
public class MainActivity extends AppCompatActivity {
    //Componentes activity
    private EditText et;
    private ListView list;
    private ArrayList<String> array;
    private ArrayAdapter<String> adapter;
    //Firebase
    FirebaseDatabase database;
    DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Inicializar componentes
        list = findViewById(R.id.list);
        et = findViewById(R.id.et);
        list = findViewById(R.id.list);
        array = new ArrayList<>();
        //Crear adaptador con la vista y el array
        adapter = new ArrayAdapter<String>(this, R.layout.lista, array);
        //Unir adaptador y ListView
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Eliminar nota seleccionada
                array.remove(position);
                adapter.notifyDataSetChanged();
                dbRef.getRef().child(String.valueOf(id)).removeValue();
            }
        });
        // Inicializar Firebase con la URL de la base de datos en tu perfil de Firebase
        database = FirebaseDatabase.getInstance("https://fir-bbdd-e6698-default-rtdb.europe-west1.firebasedatabase.app");
        //Para leer el nodo "notas", es decir sus hijos
        dbRef = database.getReference("notas2");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                array.clear(); // Limpiar la lista antes de actualizar
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String nota = snapshot.getValue(String.class);
                    array.add(nota);
                }
                adapter.notifyDataSetChanged(); // Notificar cambios al adaptador
            }
            //obligatorio
            public void onCancelled(DatabaseError error) {
                Log.w("TAG", "Failed to read value.", error.toException());
            }


        });



    }
    //Metodo para añadir nota
    public void anadirNota(View view) {
        //Utilizamos push para que se añada al final de la lista con id random
        dbRef.push().setValue(et.getText().toString());
        adapter.notifyDataSetChanged();
    }
}