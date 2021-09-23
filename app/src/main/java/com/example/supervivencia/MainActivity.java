package com.example.supervivencia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void elegirModo(View view){
        Intent i= new Intent(this, ElegirModo.class);
        startActivity(i);
    }
    public void elegirModoDuo(View view){
        Intent i= new Intent(this, ElegirModoDuo.class);
        startActivity(i);
    }
    public void elegirModoEquipos(View view){
        Intent i= new Intent(this, ElegirModoEquipos.class);
        startActivity(i);
    }
}
