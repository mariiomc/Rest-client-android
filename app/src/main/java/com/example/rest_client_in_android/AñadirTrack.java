package com.example.rest_client_in_android;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class AñadirTrack extends AppCompatActivity {

    String nombre;
    String descripcion;
    Button añadir2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track);

        añadir2 = (Button) findViewById(R.id.button3);
        añadir2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                TextInputLayout nombreLayout = findViewById(R.id.nombreTrack);
                TextInputLayout descripcionLayout = findViewById(R.id.textInputLayout2);

                if (nombreLayout != null && descripcionLayout != null) {
                    TextInputEditText username = (TextInputEditText) nombreLayout.getEditText();
                    TextInputEditText descripcion1 = (TextInputEditText) descripcionLayout.getEditText();

                    if (username != null && descripcion1 != null) {
                        nombre = username.getText().toString();
                        descripcion = descripcion1.getText().toString();
                        Log.d("Nombre añadido: ", nombre);
                        Log.d("Descripcion añadida: ", descripcion);

                        Intent i = new Intent(AñadirTrack.this, MainActivity.class);
                        i.putExtra("nombre", nombre);
                        i.putExtra("descripcion", descripcion);
                        startActivity(i);
                    } else {
                        Log.e("AñadirTrack", "TextInputEditText is null");
                    }
                } else {
                    Log.e("AñadirTrack", "TextInputLayout is null");
                }

            }
        });


    }
}
