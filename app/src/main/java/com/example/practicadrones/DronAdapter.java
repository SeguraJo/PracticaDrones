package com.example.practicadrones;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class DronAdapter extends RecyclerView.Adapter<DronAdapter.ViewHolder> {

    Context context;
    private final ArrayList<Integer> imagesArray;
    private final ArrayList<String> textoArray;

    private final ArrayList<String> descArray;

    DronAdapter(Context context, ArrayList<Integer> imagesArray, ArrayList<String> textoArray, ArrayList<String> descArray){
        this.context = context;
        this.imagesArray = imagesArray;
        this.textoArray = textoArray;
        this.descArray = descArray;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.imagen.setImageResource(imagesArray.get(position));
        holder.texto.setText(textoArray.get(position));
    }

    @Override
    public int getItemCount() {
        return textoArray.size();
    }

        public class ViewHolder extends RecyclerView.ViewHolder {
            ImageView imagen;
            TextView texto;


            public ViewHolder(View itemView) {
                super(itemView);
                imagen = itemView.findViewById(R.id.imagen);
                texto = itemView.findViewById(R.id.texto);

                itemView.setOnClickListener(v -> {

                    int position = getAdapterPosition();

                    if (position != RecyclerView.NO_POSITION){
                        String nombre = textoArray.get(position);
                        int imagen = imagesArray.get(position);
                        String descripcion = descArray.get(position);

                        Intent intent = new Intent(context, InfoDrone.class);
                        intent.putExtra("nombre", nombre);
                        intent.putExtra("imagen", imagen);
                        intent.putExtra("descripcion", descripcion);

                        context.startActivity(intent);

                    }
                });

            }
        }

}
