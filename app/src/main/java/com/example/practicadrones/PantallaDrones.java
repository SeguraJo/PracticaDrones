package com.example.practicadrones;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ListView;

public class PantallaDrones extends AppCompatActivity {

    RecyclerView recyclerView;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_drones);

        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final int[] imagesArray = {
               R.drawable.dron1,
               R.drawable.dron2,
               R.drawable.dron3,
               R.drawable.dron4,
               R.drawable.drone5
       };

       final String[] textoArray =  {
               "Tricópteros",
               "Cuadricópteros",
               "Hexacópteros.",
               "Octocópteros",
               "Coaxiales."
       };

       final String descripcion = "Drone compacto y versátil con capacidades avanzadas de grabación de video y fotografía.";

       DronAdapter adapter = new DronAdapter(this, imagesArray, textoArray, descripcion);
       recyclerView.setAdapter(adapter);


    }
}
