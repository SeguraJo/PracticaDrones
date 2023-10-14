package com.example.practicadrones;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class InfoDrone extends AppCompatActivity {

    ImageView v2;

    TextView text2;

    TextView text3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_drone);

        Intent intent = getIntent();
        v2 = findViewById(R.id.v2);
        text2 = findViewById(R.id.text2);
        text3 = findViewById(R.id.text3);

        int position = getIntent().getIntExtra("position", -1);

        if (position != -1){
            String nombre = String.valueOf(getIntent().getStringExtra("name"));
            int image = getIntent().getIntExtra("image", -1);

            v2.setImageResource(image);
            text2.setText(nombre);
        }
    }
}
