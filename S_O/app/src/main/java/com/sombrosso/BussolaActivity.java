package com.sombrosso;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


public class BussolaActivity extends AppCompatActivity  {
    ImageButton btn_menu7;
    Animation animation;
    ImageView imgBussola;

    TextView txtProximity;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bussola);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btn_menu7 = findViewById(R.id.btn_menu7);
        imgBussola = findViewById(R.id.imgBussola);





        btn_menu7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(intent);
            }
        });

    }

    public void fun4(View view) {
        animation= AnimationUtils.loadAnimation(this, R.anim.rotate);
        imgBussola.startAnimation(animation);
    }

}