package com.example.supervivencia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ElegirModoEquipos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegir_modo_equipos);
    }

    public void pueblo(View view){
        Intent i= new Intent(this, PuebloEquipos.class);
        startActivity(i);
    }
    public void madrid(View view){
        Intent y= new Intent(this, MadridEquipos.class);
        startActivity(y);
    }
    public void libre(View view){
        Intent z= new Intent(this, LibreEquipo.class);
        startActivity(z);
    }
    public void unovsuno(View view){
        Intent z= new Intent(this, UnoVsUno_I.class);
        startActivity(z);
    }
}