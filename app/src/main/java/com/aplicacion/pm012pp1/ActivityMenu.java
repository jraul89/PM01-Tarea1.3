package com.aplicacion.pm012pp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityMenu extends AppCompatActivity {
    Button btncrear,btnconsultar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btncrear = (Button) findViewById(R.id.btncrear);
        btnconsultar = (Button) findViewById(R.id.btnconsultar);


        btncrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ActivityCrear.class);

                startActivity(intent);
            }
        });


        btnconsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ActivityConsulta.class);

                startActivity(intent);
            }
        });
    }
}