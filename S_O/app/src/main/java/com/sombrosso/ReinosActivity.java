package com.sombrosso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

public class ReinosActivity extends AppCompatActivity {
    ImageButton btnMenu4;
    Button btnLocal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reinos);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btnMenu4 = findViewById(R.id.btnMenu4);
        btnLocal=findViewById(R.id.btnLocal);

        btnMenu4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (getApplicationContext(), MenuActivity.class);
                startActivity(intent);
            }
        });

        btnLocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (getApplicationContext(), BussolaActivity.class);
                startActivity(intent);
            }
        });


    }
}