package com.sombrosso;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

public class InicioActivity extends AppCompatActivity {

    ImageButton btnMenu;
    Button btnTrailer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btnMenu = findViewById(R.id.btnMenu);
        btnTrailer = findViewById(R.id.btnTrailer);

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(intent);
            }
        });

        btnTrailer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goLink("https://www.youtube.com/watch?v=jLKiB0kNk5A&t=6s&ab_channel=NetflixBrasil");
            }
        });

    }

    private void goLink(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}