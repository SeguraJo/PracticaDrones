package com.example.practicadrones;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button b1;
    TextView u1;
    TextView p1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        b1 = findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                u1 = (TextView) findViewById(R.id.u1);
                p1 = (TextView) findViewById(R.id.p1);

                String user = u1.getText().toString();
                String pass = p1.getText().toString();

                Login login = new Login(user, pass);
                if (login.acceso()) {
                    loguearse();
                } else {
                    Toast.makeText(getApplicationContext(), "Usuario incorrecto", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    public void loguearse(){

        Intent intent = new Intent(this, PantallaDrones.class);
        startActivity(intent);
    }
}