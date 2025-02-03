package com.example.list;

import android.annotation.SuppressLint;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private String paises[] = {"Alemania","Andorra","Austria", "España","Francia","Italia","Portugal", "Reino Unido","Rusia","San Marino","Suiza","Vaticano"};
    private String poblacion[] = {"81.861.000","77.000","8.457.000","47.244.000","63.604.000", "59.649.000","10.588.000","63.214.000","143.184.000","32.000","7.986.000","800"};
    private ListView listView;
    private TextView textView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.layout_list, paises);
        if (adapter != null) {
            listView.setAdapter(adapter);
        }
        textView = findViewById(R.id.textView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                textView.setText(poblacion[position]);
            }
        });

    }

}