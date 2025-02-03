package com.example.intent_implicito;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/**
 * Intent => es una clase fundamental que sirve para comunicar diferentes componentes dentro de una aplicación o entre aplicaciones distintas
 *  Intent explicito => Se utiliza cuando deseas lanzar una actividad específica dentro de tu propia aplicación.
 *      Ej => Intent intent = new Intent(MainActivity.this, DetailsActivity.class); startActivity(intent);
 *  Intent implicito => Se utiliza cuando deseas realizar una acción sin especificar qué componente exacto la ejecutará
 */

public class MainActivity extends AppCompatActivity {
    private EditText editTextRecipient;
    private EditText editTextSubject;
    private EditText editTextBody;
    private Button buttonSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inicializacion de los elementos
        editTextRecipient = findViewById(R.id.editTextRecip);
        editTextSubject = findViewById(R.id.editTextSub);
        editTextBody = findViewById(R.id.editTextBody);
        buttonSend = findViewById(R.id.buttonSend);

        //Que tiene que hacer el boton cuando le pulsen
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });
    }

    //Metodo que se encarga de mandar el mensaje
    private void sendEmail() {
        //Obtiene el texto escrito en los campos
        String recipient = editTextRecipient.getText().toString().trim();
        String subject = editTextSubject.getText().toString().trim();
        String body = editTextBody.getText().toString().trim();

        //Comprueba que el destinatario este vacio
        if (recipient.isEmpty()) {
            Toast.makeText(this, "Por favor ingresa un destinatario", Toast.LENGTH_SHORT).show(); //Toast=> Lanzar excepciones
            return;
        }

        //Intent que envia el correo
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto:" + recipient));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, body);

    }
}