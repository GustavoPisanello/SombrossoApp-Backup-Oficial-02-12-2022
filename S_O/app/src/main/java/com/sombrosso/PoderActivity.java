package com.sombrosso;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

public class PoderActivity extends AppCompatActivity {

    ImageButton btnMenu5;
    Button btnTeste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poder);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btnMenu5 = findViewById(R.id.btnMenu5);
        btnTeste = findViewById(R.id.btnTeste);

        btnMenu5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(intent);
            }
        });

        btnTeste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), TesteActivity.class);
                startActivity(intent);
            }
        });
    }
}