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

public class DronAdapter extends RecyclerView.Adapter<DronAdapter.ViewHolder> {

    Context context;
    private int[] imagesArray;
    private String[] textoArray;

    private String descripcion;

    DronAdapter(Context context, int[] imagesArray, String[] textoArray, String descripcion){ this.context = context;
        this.imagesArray = imagesArray;
        this.textoArray = textoArray;
        this.descripcion = descripcion;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.imagen.setImageResource(imagesArray[position]);
        holder.texto.setText(textoArray[position]);

    }

    @Override
    public int getItemCount() {
        return textoArray.length;
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
                        String nombre = textoArray[position];
                        int imagen = imagesArray[position];

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
