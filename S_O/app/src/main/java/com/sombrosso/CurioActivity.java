package com.sombrosso;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

public class CurioActivity extends AppCompatActivity {

        ImageButton btnMenu6;
        Button btnLocali, btnInsta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curio);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btnMenu6 = findViewById(R.id.btnMenu6);
        btnLocali = findViewById(R.id.btnLocali);
        btnInsta = findViewById(R.id.btnInsta);

        btnMenu6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(intent);
            }
        });

        btnLocali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), LocalizacaoActivity.class);
                startActivity(intent);
            }
        });

       btnInsta.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               gotoUrl("https://www.instagram.com/Lbardugo/");
           }
       });

    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }
}