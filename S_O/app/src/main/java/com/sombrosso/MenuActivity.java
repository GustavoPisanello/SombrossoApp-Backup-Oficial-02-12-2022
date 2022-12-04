package com.sombrosso;

import static com.sombrosso.R.id.btnConfig;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Switch;


public class MenuActivity extends AppCompatActivity {
Button btnInicio, btnLivros, btnAtores, btnReinos, btnPoder, btnCurio, btnConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        btnInicio = findViewById(R.id.btnInicio);
        btnLivros = findViewById(R.id.btnLivros);
        btnAtores = findViewById(R.id.btnAtores);
        btnReinos = findViewById(R.id.btnReinos);
        btnPoder = findViewById(R.id.btnPoder);
        btnCurio = findViewById(R.id.btnCurio);
        btnConfig = findViewById(R.id.btnConfig);


        btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), InicioActivity.class);
                startActivity(intent);
            }
        });

      btnLivros.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent = new Intent(getApplicationContext(), BookActivity.class);
              startActivity(intent);
          }
      });


        btnAtores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), AtoresActivity.class);
                startActivity(intent);
            }
        });

        btnReinos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), ReinosActivity.class);
                startActivity(intent);
            }
        });

        btnPoder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), PoderActivity.class);
                startActivity(intent);
            }
        });

        btnCurio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), CurioActivity.class);
                startActivity(intent);
            }
        });
        btnConfig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), ConfigActivity.class);
                startActivity(intent);
            }
        });
    }
}
