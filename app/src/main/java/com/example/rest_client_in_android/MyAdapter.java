package com.example.rest_client_in_android;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Track> tracks;
    private OnItemClickListener onItemClickListener;


    public void setTracks(List<Track> value) {
        this.tracks = value;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Track track = tracks.get(position);
        holder.bind(track);
    }
    public interface OnItemClickListener {
        void onItemClick(Track track);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    @Override
    public int getItemCount() {
        return tracks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView nombre;
        private TextView descripcion;
        private Button boton;
        public ViewHolder(View view) {
            super(view);
            nombre = view.findViewById(R.id.firstLine);
            descripcion = view.findViewById(R.id.descripcion);
            boton = view.findViewById(R.id.button);
            boton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION && onItemClickListener != null) {
                        onItemClickListener.onItemClick(tracks.get(position));
                    }
                }
            });
        }
        public void bind(Track track) {
            nombre.setText(track.getNombre());
            descripcion.setText(track.getDescripcion());
        }
    }
}


