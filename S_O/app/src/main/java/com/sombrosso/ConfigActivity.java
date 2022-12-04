package com.sombrosso;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Switch;

public class ConfigActivity extends AppCompatActivity {

    /* Variáveis */

    ImageButton btnMenu;
    Button btnCad;
    Switch switcher;
    boolean ModoDark;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    /* ------------- */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        btnMenu = findViewById(R.id.btn_menu);
        btnCad = findViewById(R.id.btnCadastro1);


        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(intent);
            }

        });

        btnCad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), Cadastro.class);
                startActivity(intent);
            }
        });

        switcher = findViewById(R.id.switchExibe);

        sharedPreferences = getSharedPreferences("MODE", Context.MODE_PRIVATE );
        ModoDark = sharedPreferences.getBoolean("night", false);

        if(ModoDark){
            switcher.setChecked(true);
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

        }
        else{
            /* Comando para alterar uma imagem junto do dark mode */
            btnMenu.setImageDrawable(getDrawable(R.drawable.ic_menup));
        }

        switcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ModoDark) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    editor = sharedPreferences.edit();
                    editor.putBoolean("night", false);



                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    editor = sharedPreferences.edit();
                    editor.putBoolean("night", true);

                }
                editor.apply();
            }
        });
        }
    }
