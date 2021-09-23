package com.example.supervivencia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ElegirModo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elegir_modo);
    }

    public void pueblo(View view){
        Intent i= new Intent(this, PuebloIndividual.class);
        startActivity(i);
    }
    public void madrid(View view){
        Intent y= new Intent(this, MadridIndividual.class);
        startActivity(y);
    }
    public void libre(View view){
        Intent z= new Intent(this, LibreIndividual.class);
        startActivity(z);
    }
}