package com.example.supervivencia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LibreEquipo extends AppCompatActivity {
    private EditText nombres;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libre_equipo);
        nombres= findViewById(R.id.nombresEditText);
    }
    public void empezar(View view){
        String x= nombres.getText().toString();
        Intent z= new Intent(this, Equipo.class);
        z.putExtra("nombres",x);
        z.putExtra("modo",3);
        startActivity(z);
    }
}