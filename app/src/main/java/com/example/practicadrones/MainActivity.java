package com.example.practicadrones;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.lView);

      /*  ArrayAdapter<String> adapterSpinner = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item);
        listView.setAdapter(adapterSpinner);*/

        listView = (ListView) findViewById(R.id.lView);

        listView.setAdapter(new DronAdapter(this));


    }
}