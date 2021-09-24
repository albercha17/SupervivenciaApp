package com.example.supervivencia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

public class Equipo extends AppCompatActivity {
    ListasRellenar listas;
    int numDia=0;
    int numAccion=4;
    int accion;
    int numeroMuerto1;
    int numeroMuerto2;
    int numeroDelQueMata1;
    int numeroDelQueMata2;
    int numeroFormaMorir;
    int numeroFormaSuicicio;
    int numeroNormalDuo;
    int numeroTraicion;
    int equipo;
    String nombre_supervivientes_1 ="";
    String nombre_supervivientes_2 ="";
    String muertes_frase="";
    private TextView listaSuper1View;   // LA VENTANA QUE LO  MUESTRA
    private TextView listaSuper2View;
    private TextView muertesView;   // LA VENTANA QUE LO  MUESTRA
    private TextView numDias;
    private TextView muerteV;
    private TextView suicidioV;
    private TextView nadaV;
    ArrayList<String> listaNombres;
    ArrayList<String> listaFormasMuerte;
    ArrayList<String> listaSuicidio;
    ArrayList<String>listaNormalDuo;
    ArrayList<String> listaTraicion;
    ArrayList<Superviviente> equipo1;  // LA LISTA DE SUPERVIVIENTES
    ArrayList<Superviviente> equipo2;  // LA LISTA DE SUPERVIVIENTES

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pueblo_equipos);
        listaSuper1View=findViewById(R.id.listaSu1View);
        listaSuper2View=findViewById(R.id.listaSu2View);
        muertesView=findViewById(R.id.muertesV);
        numDias=findViewById(R.id.numDias2);
        muerteV=findViewById(R.id.muertePI);
        suicidioV=findViewById(R.id.suicidioPI);
        nadaV=findViewById(R.id.nadaPI);
        equipo1 = new ArrayList<Superviviente>();
        equipo2 = new ArrayList<Superviviente>();
        listaNombres = new ArrayList<String>();
        listaFormasMuerte=new ArrayList<String>();
        listaSuicidio=new ArrayList<String>();
        listaNormalDuo=new ArrayList<String>();
        listaTraicion=new ArrayList<String>();
        listas= new ListasRellenar();




        listaNombres.clear();
        equipo1.clear();
        equipo2.clear();
        listaFormasMuerte.clear();
        nombre_supervivientes_1 ="";
        nombre_supervivientes_2 ="";
        rellenarListas();
        int contador=0;
        while(listaNombres.size()>0){
            int x=(int)(Math.random()*listaNombres.size());
            if(contador%2==0) {
                equipo1.add(new Superviviente(listaNombres.get(x)));
            }
            else{
                equipo2.add(new Superviviente(listaNombres.get(x)));
            }
            contador++;
            listaNombres.remove(x);
        }
        for(int i = 0; i< equipo1.size(); i++){

            nombre_supervivientes_1 += equipo1.get(i).getNombre();
            nombre_supervivientes_1+=", ";

        }
        for(int i = 0; i< equipo2.size(); i++){

            nombre_supervivientes_2 += equipo2.get(i).getNombre();
            nombre_supervivientes_2+=", ";

        }
        muertesView.setText("");
        listaSuper1View.setText(nombre_supervivientes_1);
        listaSuper2View.setText(nombre_supervivientes_2);
    }


    // RELLENAR LISTAS //

    public void rellenarListas(){

        rellenarNombres();
    }

    public void rellenarNombres(){
        int modo=0;
        listaNombres.clear();
        Bundle extras= getIntent().getExtras();
        modo=extras.getInt("modo");
        if(modo==3) {
            String x = extras.getString("nombres");
            String[] partes = x.split(",");
            for (int i = 0; i < partes.length; i++) {
                listaNombres.add(partes[i]);
            }
        }
        if(modo==2) {
            listaNombres=listas.rellenarSupervivientes(2);
        }
        if(modo==1) {
            listaNombres=listas.rellenarSupervivientes(1);
        }

        ArrayList<String> z = new ArrayList<String>();
        while(listaNombres.size()>0){
            int x=(int)(Math.random()*listaNombres.size());
            z.add(listaNombres.get(x));
            listaNombres.remove(x);
        }
        listaNombres=z;
    }
    public  void aleatorio(){
        accion=(int)(Math.random()*numAccion);
        equipo=(int)(Math.random()*2);

        numeroMuerto1 = (int)(Math.random()* equipo1.size());
        numeroMuerto2 = (int)(Math.random()* equipo2.size());
        numeroDelQueMata1 = (int)(Math.random()* equipo1.size());
        numeroDelQueMata2 = (int)(Math.random()* equipo2.size());
        if(accion==2&&(equipo1.size()==1||equipo2.size()==1)) accion--;
        if(accion==2) {
            while (numeroMuerto1 == numeroDelQueMata1) {
                numeroMuerto1 = (int) (Math.random() * equipo1.size());
                numeroDelQueMata1 = (int) (Math.random() * equipo1.size());

            }
            while (numeroMuerto2 == numeroDelQueMata2) {
                numeroMuerto2 = (int) (Math.random() * equipo2.size());
                numeroDelQueMata2 = (int) (Math.random() * equipo2.size());

            }
        }
    }





    // BOTONES
    public void siguiente(View view) {
        nombre_supervivientes_1 = null;
        nombre_supervivientes_1 = " ";
        nombre_supervivientes_2 = null;
        nombre_supervivientes_2 = " ";
        muerteV.setText("");
        suicidioV.setText("");
        nadaV.setText("");

        if (equipo1.size() >= 1 && equipo2.size()>=1) {
            aleatorio();
            muertes_frase = null;
            if(equipo==1) {
                // MUERTE
                if (accion == 0) {
                    muertes_frase = equipo1.get(numeroDelQueMata1).getNombre() + " " + listas.rellenarMuertes()+ " " + equipo2.get(numeroMuerto2).getNombre();
                    equipo2.remove(numeroMuerto2);
                    muerteV.setText("MUERTE");
                }
                // SUICIDIO
                else if (accion == 1) {
                    muertes_frase = equipo1.get(numeroMuerto1).getNombre() + " " + listas.rellenarSuicidios();
                    equipo1.remove(numeroMuerto1);
                    suicidioV.setText("SUICIDIO");
                }
                //COSAS NORMALES POR PAREJAS
                else if (accion == 2) {
                    muertes_frase = equipo1.get(numeroDelQueMata1).getNombre() + " " + listas.rellenarNadaDuo() + " " + equipo1.get(numeroMuerto1).getNombre();
                    nadaV.setText("NADA");
                }
                //TRAICION
                else if (accion == 3) {
                    muertes_frase = equipo1.get(numeroDelQueMata1).getNombre() + " " + listas.rellenarTraicion();
                    equipo2.add(equipo1.get(numeroDelQueMata1));
                    equipo1.remove(numeroDelQueMata1);
                    suicidioV.setText("TRAICIÓN");
                }
            }
            else{
                // MUERTE
                if (accion == 0) {
                    muertes_frase = equipo2.get(numeroDelQueMata2).getNombre() + " " + listas.rellenarMuertes()+ " " + equipo1.get(numeroMuerto1).getNombre();
                    equipo1.remove(numeroMuerto1);
                    muerteV.setText("MUERTE");
                }
                // SUICIDIO
                else if (accion == 1) {
                    muertes_frase = equipo2.get(numeroMuerto2).getNombre() + " " + listas.rellenarSuicidios();
                    equipo2.remove(numeroMuerto2);
                    suicidioV.setText("SUICIDIO");
                }
                //COSAS NORMALES POR PAREJAS
                else if (accion == 2) {
                    muertes_frase = equipo2.get(numeroDelQueMata2).getNombre() + " " + listas.rellenarNadaDuo()+ " " + equipo2.get(numeroMuerto2).getNombre();
                    nadaV.setText("NADA");
                }
                else if (accion == 3) {
                    muertes_frase = equipo2.get(numeroDelQueMata2).getNombre() + " " + listas.rellenarTraicion();
                    equipo1.add(equipo2.get(numeroDelQueMata2));
                    equipo2.remove(numeroDelQueMata2);
                    suicidioV.setText("TRAICIÓN");
                }
            }



            // vuelve a calcular el numero de personas que viven

        }
        else{
            if(equipo1.size()>1) {
                muertes_frase = "Ha ganado el equipo 1!!!!!";
            }
            else{
                muertes_frase = "Ha ganado el equipo 2!!!!!";
            }
        }
        numDia++;
        for (int i = 0; i < equipo1.size(); i++) {
            nombre_supervivientes_1 += equipo1.get(i).getNombre();
            nombre_supervivientes_1+=", ";
        }
        for (int i = 0; i < equipo2.size(); i++) {
            nombre_supervivientes_2 += equipo2.get(i).getNombre();
            nombre_supervivientes_2+=", ";
        }
        numDias.setText("DIA "+numDia);
        muertesView.setText(muertes_frase);
        listaSuper1View.setText(nombre_supervivientes_1);
        listaSuper2View.setText(nombre_supervivientes_2);
    }




    public void empezarPueblo(View view) throws IOException {
        numDia=0;
        listaNombres.clear();
        equipo1.clear();
        equipo2.clear();
        listaFormasMuerte.clear();
        nombre_supervivientes_1 ="";
        nombre_supervivientes_2 ="";
        rellenarListas();
        int contador=0;
        while(listaNombres.size()>0){
            int x=(int)(Math.random()*listaNombres.size());
            if(contador%2==0) {
                equipo1.add(new Superviviente(listaNombres.get(x)));
            }
            else{
                equipo2.add(new Superviviente(listaNombres.get(x)));
            }
            contador++;
            listaNombres.remove(x);
        }
        for(int i = 0; i< equipo1.size(); i++){
            nombre_supervivientes_1 += equipo1.get(i).getNombre();
            nombre_supervivientes_1+=", ";
        }
        for(int i = 0; i< equipo2.size(); i++){
            nombre_supervivientes_2 += equipo2.get(i).getNombre();
            nombre_supervivientes_2+=", ";
        }
        muertesView.setText("");
        listaSuper1View.setText(nombre_supervivientes_1);
        listaSuper2View.setText(nombre_supervivientes_2);
    }
}