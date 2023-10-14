package com.example.practicadrones;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class DronAdapter extends BaseAdapter {

    Context context;

    private final int[] imagesArray = {
            R.drawable.dron1,
            R.drawable.dron2,
            R.drawable.dron3,
            R.drawable.dron4
    };

    DronAdapter(Context context){ this.context = context; }
    private final String[] textoArray =  {
            "Tricópteros",
            "Cuadricópteros",
            "Hexacópteros.",
            "Octocópteros",
            "Coaxiales."
    };


    @Override
    public int getCount() {
        return imagesArray.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        if (view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item, null);

            ImageView imagen = view.findViewById(R.id.imagen);
            imagen.setImageResource(imagesArray[i]);

            TextView texto = view.findViewById(R.id.texto);
            texto.setText(textoArray[i]);
        }

        return view;
    }


}
