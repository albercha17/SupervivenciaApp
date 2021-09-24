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
        Intent z= new Intent(this, Equipo.class);
        z.putExtra("modo",1);
        startActivity(z);
    }
    public void madrid(View view){
        Intent z= new Intent(this, Equipo.class);
        z.putExtra("modo",2);
        startActivity(z);
    }
    public void libre(View view){
        Intent z= new Intent(this, LibreEquipo.class);
        startActivity(z);
    }
    public void UnosVsUno(View view){
        Intent z= new Intent(this, UnoVsUno_I.class);
        startActivity(z);
    }
}