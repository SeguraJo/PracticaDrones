package com.example.practicadrones;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class PantallaDrones extends AppCompatActivity {

    ListView listView;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_drones);

        listView = (ListView) findViewById(R.id.lView);
        ArrayAdapter < String > adapterSpinner = new ArrayAdapter<>(PantallaDrones.this, android.R.layout.simple_spinner_item);

        listView.setAdapter(adapterSpinner);

        listView = findViewById(R.id.lView);

        listView.setAdapter(new DronAdapter(PantallaDrones.this));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            Intent intent = new Intent(PantallaDrones.this, InfoDrone.class);
            intent.putExtra("position", position);
            intent.putExtra("name", ((DronAdapter)listView.getAdapter()).getItem(position));
            intent.putExtra("image", ((DronAdapter)listView.getAdapter()).getImagesArray(position));
            startActivity(intent);
        }
      });

    }
}
