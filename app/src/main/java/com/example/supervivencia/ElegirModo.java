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
        Intent z= new Intent(this, Individual.class);
        z.putExtra("modo",1);
        startActivity(z);
    }
    public void madrid(View view){
        Intent z= new Intent(this, Individual.class);
        z.putExtra("modo",2);
        startActivity(z);
    }
    public void libre(View view){
        Intent z= new Intent(this, LibreIndividual.class);
        startActivity(z);
    }
}