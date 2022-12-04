package com.sombrosso;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class TesteActivity extends AppCompatActivity implements SensorEventListener {
    ImageButton btnMenu9;
    ImageView imgPoder;
    public static final String poder = "Poder.txt";
    private EditText editText;

    // As duas linhas abaixo: variaveis necessárias para gerenciar o sensor e definir qual sensor é respectivamente.
    SensorManager sensorManager;
    Sensor sensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste);

        editText = findViewById(R.id.editText);
        btnMenu9 = findViewById(R.id.btnMenu9);
        imgPoder = findViewById(R.id.imgPoder);


        // Permite o uso dos serviços de sensor
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        // Define o tipo do sensor.
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        // "Liga o sensor" (faz com que o sensor reaja as mudanças na variação e passe essas informações.)
        sensorManager.registerListener( this, sensor, SensorManager.SENSOR_DELAY_NORMAL);

        btnMenu9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivity(intent);
            }
        });
    }
    public void Salvar(View view){
        String texto = editText.getText().toString();
        FileOutputStream fos = null;
        try {
            fos = openFileOutput(poder, MODE_PRIVATE);
            fos.write(texto.getBytes());
            editText.getText().clear();
            Toast.makeText(this, "Salvo em: " + getFilesDir(), Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            if(fos!= null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void Ler(View view){
        FileInputStream fis = null;

        try {
            fis = openFileInput(poder);
            InputStreamReader inputStreamReader = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(inputStreamReader);
            StringBuilder sb = new StringBuilder();
            String texto;

            while ((texto = br.readLine()) != null){
                sb.append(texto).append("\n");
            }
            editText.setText(sb.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            if (fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Override
    public void onSensorChanged(SensorEvent event){
        // A funcionalidade do sensor vai aqui
        float direção = event.values[0];
        if(direção < -0.5)
            imgPoder.setImageResource(R.drawable.sol_poder);
        else if(direção > 0.5)
            imgPoder.setImageResource(R.drawable.escuro_poder);
        else
            imgPoder.setImageResource(R.drawable.no_poder);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
    }
}