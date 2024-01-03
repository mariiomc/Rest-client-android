package com.example.rest_client_in_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    Button añadir;
    String nombre;
    String descripcion;
    static List<Track> tracks = new ArrayList<>();


    public void setData(String nombre, String descripcion){
        tracks.add(new Track(nombre, descripcion));
    }
    public void delData(Track track){
        tracks.remove(track);
    }
    public static List<Track> getData() {
        return tracks;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = new Intent (MainActivity.this, AñadirTrack.class);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        MyAdapter adapter = new MyAdapter();
        recyclerView.setAdapter(adapter);
        adapter.setTracks(getData());

        nombre = getIntent().getStringExtra("nombre");
        descripcion = getIntent().getStringExtra("descripcion");

        if (nombre != null && descripcion != null) {
            if (!nombre.isEmpty() && !descripcion.isEmpty()) {
                setData(nombre, descripcion);
            }
        }
        adapter.setOnItemClickListener(new MyAdapter.OnItemClickListener(){
            @Override
            public void onItemClick(Track track) {
                String nombre;
                String descripcion;
                nombre = track.getNombre();
                Log.d("Nombre item: ","" + nombre);
                descripcion = track.getDescripcion();
                Log.d("Descripcion item: ","" + descripcion);
                delData(track);
                adapter.setTracks(getData());
            }
        });
        añadir = (Button) findViewById(R.id.button2);
        añadir.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(i);
            }
        });

    }


}