package com.example.supervivencia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

public class LibreD extends AppCompatActivity {
    int numDia=0;
    int numAccion=3;
    int accion;
    int numeroMuerto;
    int numeroDelQueMata;
    int numeroFormaMorir;
    int numeroFormaSuicicio;
    int numeroNormalDuo;
    String nombre_supervivientes="";
    String muertes_frase="";
    private TextView listaSuperView;   // LA VENTANA QUE LO  MUESTRA
    private TextView muertesView;   // LA VENTANA QUE LO  MUESTRA
    private TextView numDias;
    private TextView muerteV;
    private TextView suicidioV;
    private TextView nadaV;
    ArrayList<String> listaNombres;
    ArrayList<String> listaFormasMuerte;
    ArrayList<String> listaSuicidio;
    ArrayList<String>listaNormalDuo;
    ArrayList<SupervivienteDuos> listaS;  // LA LISTA DE SUPERVIVIENTES
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
        listaS = new ArrayList<SupervivienteDuos>();
        listaNombres = new ArrayList<String>();
        listaFormasMuerte=new ArrayList<String>();
        listaSuicidio=new ArrayList<String>();
        listaNormalDuo=new ArrayList<String>();
        listas= new ListasRellenar();




        listaNombres.clear();
        listaS.clear();
        listaFormasMuerte.clear();
        nombre_supervivientes="";
        rellenarListas();
        for(int i=0;i<listaNombres.size();i++){
            int x=listaS.size()-1;
            if(i%2==0){
                listaS.add(new SupervivienteDuos(listaNombres.get(i)));
            }
            else{
                listaS.get(x).añadir_compi(listaNombres.get(i));
            }

        }
        for(int i=0; i<listaS.size();i++){
            nombre_supervivientes+=listaS.get(i).getNombre();
            if(listaS.get(i).getNombre2()!=null){
                nombre_supervivientes+=" y "+listaS.get(i).getNombre2();
            }
            nombre_supervivientes+=" |, ";        }
        muertesView.setText("");
        listaSuperView.setText(nombre_supervivientes);
    }


    // RELLENAR LISTAS //

    public void rellenarListas(){
        rellenarMuertes();
        rellenarSuicidio();
        rellenarNormalDuo();
        rellenarNombres();
    }

    public void rellenarNombres(){
        listaNombres.clear();
        listaS.clear();
        listaNombres.clear();
        Bundle extras= getIntent().getExtras();
        String x= extras.getString("nombres");
        String [] partes= x.split(",");
        for(int i=0; i<partes.length;i++){
            listaNombres.add(partes[i]);
        }
        ArrayList<String> z = new ArrayList<String>();
        while(listaNombres.size()>0){
            int y=(int)(Math.random()*listaNombres.size());
            z.add(listaNombres.get(y));
            listaNombres.remove(y);
        }
        listaNombres=z;
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

    public  void aleatorio(){
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

        if (listaS.size() > 1) {
            aleatorio();
            muertes_frase = null;

            // MUERTE
            if(accion==0) {
                muertes_frase = listaS.get(numeroDelQueMata).getNombre() + " " + listaFormasMuerte.get(numeroFormaMorir) + " " + listaS.get(numeroMuerto).matar();
                if(listaS.get(numeroMuerto).eliminar()){
                    listaS.remove(numeroMuerto);
                }
                muerteV.setText("MUERTE");
            }
            // SUICIDIO
            else if(accion==1){
                muertes_frase = listaS.get(numeroMuerto).matar() + " " + listaSuicidio.get(numeroFormaSuicicio);
                if(listaS.get(numeroMuerto).eliminar()){
                    listaS.remove(numeroMuerto);
                }
                suicidioV.setText("SUICIDIO");
            }
            //COSAS NORMALES POR PAREJAS
            else if(accion==2){
                if(listaS.get(numeroDelQueMata).getNombre2()!=null) {
                    muertes_frase = listaS.get(numeroDelQueMata).getNombre() + " " + listaNormalDuo.get(numeroNormalDuo) + " " + listaS.get(numeroDelQueMata).getNombre2();
                }
                else{
                    muertes_frase=listaS.get(numeroDelQueMata).getNombre() +" echa de menos a su pareja...";
                }
                nadaV.setText("NADA");
            }




            // vuelve a calcular el numero de personas que viven
            numDia++;
            for(int i=0; i<listaS.size();i++){
                nombre_supervivientes+=listaS.get(i).getNombre();
                if(listaS.get(i).getNombre2()!=null){
                    nombre_supervivientes+=" y "+listaS.get(i).getNombre2();
                }
                nombre_supervivientes+=" |, ";
            }
        }
        else{
            nombre_supervivientes="";
            muertes_frase= "Ha ganado " + listaS.get(0).getpareja();

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
            int x=listaS.size()-1;
            if(i%2==0){
                listaS.add(new SupervivienteDuos(listaNombres.get(i)));
            }
            else{
                listaS.get(x).añadir_compi(listaNombres.get(i));
            }

        }
        for(int i=0; i<listaS.size();i++){
            nombre_supervivientes+=listaS.get(i).getNombre();
            if(listaS.get(i).getNombre2()!=null){
                nombre_supervivientes+=" y "+listaS.get(i).getNombre2();
            }
            nombre_supervivientes+=" |, ";        }
        muertesView.setText("");
        listaSuperView.setText(nombre_supervivientes);
    }
}