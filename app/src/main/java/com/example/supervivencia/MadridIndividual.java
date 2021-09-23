package com.example.supervivencia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

public class MadridIndividual extends AppCompatActivity {
    int numDia=0;
    int numAccion=5;
    int accion;
    int numeroMuerto;
    int numeroDelQueMata;
    int numeroFormaMorir;
    int numeroFormaSuicicio;
    int numeroNormalDuo;
    int numComF;
    String nombre_supervivientes="";
    String muertes_frase="";
    private TextView listaSuperView;   // LA VENTANA QUE LO  MUESTRA
    private TextView muertesView;   // LA VENTANA QUE LO  MUESTRA
    private TextView numDias;
    private TextView muerteV;
    private TextView suicidioV;
    private TextView nadaV;
    ArrayList<String> listaNombres;
    ArrayList<String> combateFinal;
    ArrayList<String> listaFormasMuerte;
    ArrayList<String> listaSuicidio;
    ArrayList<String>listaNormalDuo;
    ArrayList<Superviviente> listaS;  // LA LISTA DE SUPERVIVIENTES
    ListasRellenar listas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pueblo_individual);
        listaSuperView=findViewById(R.id.listaSu1View);
        muertesView=findViewById(R.id.muertesV);
        numDias=findViewById(R.id.numDias2);
        muerteV=findViewById(R.id.muertePI);
        suicidioV=findViewById(R.id.suicidioPI);
        nadaV=findViewById(R.id.nadaPI);
        listaS = new ArrayList<Superviviente>();
        listaNombres = new ArrayList<String>();
        listaFormasMuerte=new ArrayList<String>();
        listaSuicidio=new ArrayList<String>();
        listaNormalDuo=new ArrayList<String>();
        combateFinal=new ArrayList<String>();
        listas= new ListasRellenar();




        listaNombres.clear();
        listaS.clear();
        listaFormasMuerte.clear();
        nombre_supervivientes="";
        rellenarListas();
        for(int i=0;i<listaNombres.size();i++){
            listaS.add(new Superviviente(listaNombres.get(i)));
        }
        for(int i=0; i<listaS.size();i++){
            nombre_supervivientes+=listaS.get(i).getNombre();
            nombre_supervivientes+=", ";
        }
        muertesView.setText("");
        listaSuperView.setText(nombre_supervivientes);
    }


    // RELLENAR LISTAS //

    public void rellenarListas(){
        rellenarMuertes();
        rellenarSuicidio();
        rellenarNormalDuo();
        rellenarNombres();
        rellenarComabteFinal();
    }

    public void rellenarNombres(){
        listaNombres.clear();
        listaNombres.add("Manko");
        listaNombres.add("Chaves");
        listaNombres.add("Roca");
        listaNombres.add("Robledo");
        listaNombres.add("Martin");
        listaNombres.add("Nachete");
        listaNombres.add("Fran");
        listaNombres.add("Manuel");
    }
    public void rellenarNormalDuo(){
        listaNormalDuo.clear();
        listaNormalDuo=listas.rellenarNadaDuo();
    }
    public void rellenarMuertes(){
        listaFormasMuerte.clear();
        listaFormasMuerte=listas.rellenarMuertes();
    }
    public void rellenarSuicidio(){
        listaSuicidio.clear();
        listaSuicidio=listas.rellenarSuicidios();
    }
    public void rellenarComabteFinal(){
        combateFinal.clear();
        combateFinal=listas.rellenarCombateFinal();
    }

    public  void aleatorio(){
        numComF=(int)(Math.random()*combateFinal.size());
        accion=(int)(Math.random()*numAccion);
        numeroFormaSuicicio=(int)(Math.random()*listaSuicidio.size());
        numeroFormaMorir = (int)(Math.random()*listaFormasMuerte.size());
        numeroMuerto = (int)(Math.random()*listaS.size());
        numeroDelQueMata = (int)(Math.random()*listaS.size());
        numeroNormalDuo= (int)(Math.random()*listaNormalDuo.size());
        while(numeroMuerto==numeroDelQueMata){
            numeroMuerto = (int)(Math.random()*listaS.size());
            numeroDelQueMata = (int)(Math.random()*listaS.size());
        }
    }





    // BOTONES
    public void siguiente(View view) {
        nombre_supervivientes = null;
        nombre_supervivientes = " ";
        muerteV.setText("");
        suicidioV.setText("");
        nadaV.setText("");

        if (listaS.size()>2) {
            aleatorio();
            muertes_frase = null;

            // MUERTE
            if(accion==0) {
                muertes_frase = listaS.get(numeroDelQueMata).getNombre() + " " + listaFormasMuerte.get(numeroFormaMorir) + " " + listaS.get(numeroMuerto).getNombre();
                listaS.remove(numeroMuerto);
                muerteV.setText("MUERTE");
            }
            // SUICIDIO
            else if(accion==1){
                muertes_frase = listaS.get(numeroMuerto).getNombre() + " " + listaSuicidio.get(numeroFormaSuicicio);
                listaS.remove(numeroMuerto);
                suicidioV.setText("SUICIDIO");
            }
            //COSAS NORMALES POR PAREJAS
            else if(accion>=2){
                muertes_frase = listaS.get(numeroDelQueMata).getNombre() + " " + listaNormalDuo.get(numeroNormalDuo) + " " + listaS.get(numeroMuerto).getNombre();
                nadaV.setText("NADA");
            }




            // vuelve a calcular el numero de personas que viven
            numDia++;
            for (int i = 0; i < listaS.size(); i++) {
                nombre_supervivientes += listaS.get(i).getNombre();
                nombre_supervivientes+=", ";
            }
        }
        else if(listaS.size()==2){
            aleatorio();
            if(accion==0){
                muertes_frase = listaS.get(numeroDelQueMata).getNombre() + " " + listaFormasMuerte.get(numeroFormaMorir) + " " + listaS.get(numeroMuerto).getNombre();
                listaS.remove(numeroMuerto);
                muerteV.setText("MUERTE");
            }
            else{
                muertes_frase = listaS.get(numeroDelQueMata).getNombre() + " " + combateFinal.get(numComF) + " " + listaS.get(numeroMuerto).getNombre();
                muerteV.setText("COMBATE FINAL");
            }
            numDia++;
            for (int i = 0; i < listaS.size(); i++) {
                nombre_supervivientes += listaS.get(i).getNombre();
                nombre_supervivientes+=", ";
            }
        }
        else{
            nombre_supervivientes="";
            muertes_frase= "Ha ganado " + listaS.get(0).getNombre();

        }
        numDias.setText("DIA "+numDia);
        muertesView.setText(muertes_frase);
        listaSuperView.setText(nombre_supervivientes);
    }




    public void empezarPueblo(View view) throws IOException {
        numDia=0;
        listaNombres.clear();
        listaS.clear();
        listaFormasMuerte.clear();
        nombre_supervivientes="";
        rellenarListas();
        for(int i=0;i<listaNombres.size();i++){
            listaS.add(new Superviviente(listaNombres.get(i)));
        }
        for(int i=0; i<listaS.size();i++){
            nombre_supervivientes+=" ";
            nombre_supervivientes+=listaS.get(i).getNombre();
        }
        muertesView.setText("");
        listaSuperView.setText(nombre_supervivientes);
    }
}