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
        Intent z= new Intent(this, Duos.class);
        z.putExtra("modo",1);
        startActivity(z);
    }
    public void madrid(View view){
        Intent z= new Intent(this, Duos.class);
        z.putExtra("modo",2);
        startActivity(z);
    }
    public void libre(View view){
        Intent z= new Intent(this, LibreDuos.class);
        startActivity(z);
    }
}