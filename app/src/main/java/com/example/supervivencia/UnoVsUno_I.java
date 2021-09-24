package com.example.supervivencia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class UnoVsUno_I extends AppCompatActivity {
    private EditText nombres;
    private EditText nombres2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uno_vs_uno__i);
        nombres= findViewById(R.id.nombresEditText);
        nombres2= findViewById(R.id.nombres2EditText);
    }
    public void empezar(View view){
        String x= nombres.getText().toString();
        String y= nombres2.getText().toString();
        Intent z= new Intent(this, UNOVSUNO.class);
        z.putExtra("nombres",x);
        z.putExtra("nombres2",y);
        startActivity(z);
    }
}
