package com.example.agendadecontactosjava;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GuardarContacto extends Activity {
    EditText txtNombre,txtDatos;
    Button btnGuardar,btnLimpiar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guardar_contacto);

        txtNombre = findViewById(R.id.txtNombre1);
        txtDatos = findViewById(R.id.txtDatos1);

        btnGuardar = findViewById(R.id.btnGuardar1);
        btnLimpiar = findViewById(R.id.btnLimpiar1);

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtDatos.setText("");
                txtNombre.setText("");
            }
        });


    }

    public void Guardar(View view){
        String nombre = txtNombre.getText().toString();
        String datos = txtDatos.getText().toString();

        SharedPreferences preferencias = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        SharedPreferences.Editor obj_editor = preferencias.edit();
        obj_editor.putString(nombre, datos);
        obj_editor.commit();

        Toast.makeText(this, "El contacto a sido guardado",Toast.LENGTH_SHORT).show();
    }
}