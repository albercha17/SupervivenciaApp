package com.example.supervivencia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class ElegirModoDuo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegir_modo_duo);
    }

    public void pueblo(View view){
        Intent i= new Intent(this, PuebloDuos.class);
        startActivity(i);
    }
    public void madrid(View view){
        Intent y= new Intent(this, MadridDuos.class);
        startActivity(y);
    }
    public void libre(View view){
        Intent z= new Intent(this, LibreDuos.class);
        startActivity(z);
    }
}