package com.sombrosso;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

public class BookActivity extends AppCompatActivity {

    ImageButton btnBook;
    TextView txtAdquira;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btnBook = findViewById(R.id.btnBook);
        txtAdquira = findViewById(R.id.txtAdquira);

        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnBook.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });

        txtAdquira.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goLink("https://www.amazon.com.br/Shadow-Bone-Trilogy-Boxed-Set/dp/125019623X/ref=asc_df_125019623X/?tag=googleshopp00-20&linkCode=df0&hvadid=379726163686&hvpos=&hvnetw=g&hvrand=17716465455505246807&hvpone=&hvptwo=&hvqmt=&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=1001773&hvtargid=pla-384124475734&psc=1");
            }
        });

    }

    private void goLink(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}