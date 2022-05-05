package com.example.agendadecontactosjava;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class CargaPantalla extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carga_pantalla);

        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                Intent i = new Intent(CargaPantalla.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        };

        Timer tiempo = new Timer();
        tiempo.schedule(tarea,4000);
    }


}