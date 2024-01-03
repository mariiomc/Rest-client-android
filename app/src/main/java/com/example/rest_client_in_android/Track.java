package com.example.rest_client_in_android;

import java.util.ArrayList;
import java.util.List;

public class Track {
    private String nombre;
    private String descripcion;


    public Track (String nombre, String descripcion){
        this.nombre=nombre;
        this.descripcion=descripcion;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public void setData(String nombre, String descripcion){
        List<Track> tracks = new ArrayList<>();

        tracks.add(new Track(nombre, descripcion));
    }

    public static List<Track> getData() {
        // Aquí deberías crear y devolver una lista de artículos
        List<Track> tracks = new ArrayList<>();

        // Agregar artículos a la lista (esto es solo un ejemplo, ajusta según tus necesidades)
        tracks.add(new Track("A","B"));
        tracks.add(new Track("NOMBRE","DESCRIPCION"));
        tracks.add(new Track("1","2"));

        return tracks;
    }
}
