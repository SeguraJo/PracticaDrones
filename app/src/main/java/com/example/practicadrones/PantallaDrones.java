package com.example.practicadrones;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PantallaDrones extends AppCompatActivity {

    RecyclerView recyclerView;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_drones);

        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

       ArrayList<Integer> imagesArray = new ArrayList<>();
       ArrayList<String> textoArray = new ArrayList<>();
       ArrayList<String> descripcion = new ArrayList<>();

        try {
            InputStreamReader inputStreamReader = new InputStreamReader(getAssets().open("notas.txt"));
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String linea;

            while ((linea = bufferedReader.readLine())!=null) {

                String[] campos = linea.split(",");

                int imageResourceId = getResources().getIdentifier(campos[0], "drawable", getPackageName());
                imagesArray.add(imageResourceId);
                textoArray.add(campos[1]);
                descripcion.add(campos[2]);

            }
            bufferedReader.close();
            inputStreamReader.close();
        }catch (IOException e){
            e.printStackTrace();
        }


       DronAdapter adapter = new DronAdapter(this, imagesArray, textoArray, descripcion);
       recyclerView.setAdapter(adapter);


    }
}
