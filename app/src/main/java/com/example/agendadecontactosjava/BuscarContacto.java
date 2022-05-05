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

public class BuscarContacto extends Activity {

    EditText txtNombre,txtDatos;

    Button btnGuardar, btnBuscar, btnLimpiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_contacto);
        txtNombre = findViewById(R.id.txtNombre);
        txtDatos = findViewById(R.id.txtDatos);

        btnBuscar = findViewById(R.id.btnBuscar);
        btnGuardar = findViewById(R.id.btnEditar);
        btnLimpiar = findViewById(R.id.btnLimpiar);

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

    public void Buscar(View view){
        String nombre = txtNombre.getText().toString();

        SharedPreferences preferencias = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        String Datos = preferencias.getString(nombre, "");

        if(Datos.length() == 0){
            Toast.makeText(this,"No se encontro ningun registro",Toast.LENGTH_LONG).show();
        }else{
            txtDatos.setText(Datos);
        }
    }



}