package com.example.supervivencia;

import java.util.ArrayList;

public class ListasRellenar {

    ArrayList<String> listaMuertes;
    ArrayList<String> listaNadaDuos;
    ArrayList<String> listaSuicidios;
    ArrayList<String> combateFinal;
    ArrayList<String> Traicion;
    ArrayList<String> supervivientes;
    public ListasRellenar(){
        listaMuertes=new ArrayList<String>();
        listaNadaDuos=new ArrayList<String>();
        listaSuicidios=new ArrayList<String>();
        combateFinal=new ArrayList<String>();
        Traicion=new ArrayList<String>();
        supervivientes=new ArrayList<String>();
    }
    public ArrayList<String> rellenarSupervivientes(int x){
        if(x==1){
            supervivientes.add("Esther");
            supervivientes.add("Alberto");
            supervivientes.add("Molina");
            supervivientes.add("Ana");
            supervivientes.add("Maria");
            supervivientes.add("Josh");
            supervivientes.add("Arturo");
            supervivientes.add("Irene");
            supervivientes.add("Lucia");
            supervivientes.add("Claudia");
            supervivientes.add("Paquito");
            supervivientes.add("Alberto Zaragoza");
            supervivientes.add("Daniela");
            supervivientes.add("Ricar");
            supervivientes.add("Miguel");
            supervivientes.add("Cris");
        }
        else if(x==2){
            supervivientes.add("Manko");
            supervivientes.add("Chaves");
            supervivientes.add("Roca");
            supervivientes.add("Robledo");
            supervivientes.add("Martin");
            supervivientes.add("Nachete");
            supervivientes.add("Fran");
            supervivientes.add("Manuel");
            supervivientes.add("Pablito");
            supervivientes.add("Mario");
        }
        return supervivientes;
    }
    public String rellenarMuertes(){
        if(listaMuertes.isEmpty()) {
            listaMuertes.add("mató sin querer a ");
            listaMuertes.add("descuartizó a ");
            listaMuertes.add("envenenó a ");
            listaMuertes.add("disparó a quemaropa a ");
            listaMuertes.add("quemó vivo a ");
            listaMuertes.add("decapitó a ");
            listaMuertes.add("tiró por un precipicio a ");
            listaMuertes.add("contrató a un sicario y mató a ");
            listaMuertes.add("traicionó y mató a ");
            listaMuertes.add("abofeteó hasta la muerte a ");
            listaMuertes.add("apuñaló por la espalda a ");
            listaMuertes.add("se comió vivo a ");
            listaMuertes.add("envenenó un piti y se lo dió a ");
            listaMuertes.add("mató mientras dormia a ");
            listaMuertes.add("iba borracho y atropelló a  ");
            listaMuertes.add("tuvo sexo tan duro que mató sin querer a ");
            listaMuertes.add("no pudo con los celos y disparó a ");
            listaMuertes.add("le confundió con el Yeti y mató a ");
            listaMuertes.add("tiró a los tiburones a ");
            listaMuertes.add("se olvidó de apagar el gas y mató a ");
            listaMuertes.add("se convirtió en hombre lobo y se comió a ");
            listaMuertes.add("se comió unas setas y desperto con el cadaver de ");
        }
        int x=(int)(Math.random()*listaMuertes.size());
        String y=listaMuertes.get(x);
        listaMuertes.remove(x);
        return y;
    }
    public String rellenarSuicidios(){
        if(listaSuicidios.isEmpty()) {
            listaSuicidios.add("se cayó por un barranco");
            listaSuicidios.add("fué devorado por un chiguagua");
            listaSuicidios.add("le aplastó una roca gigante");
            listaSuicidios.add("le dió una sobredosis");
            listaSuicidios.add("se ahogó comiendose un chicle");
            listaSuicidios.add("le dió un coma etílico");
            listaSuicidios.add("fué asesinado por una ardilla asesina");
            listaSuicidios.add("fué secuestrado por unos extraterrestres");
            listaSuicidios.add("fué apuñalado por un gitano");
            listaSuicidios.add("murió de soledad");
            listaSuicidios.add("explotó con una mina");
            listaSuicidios.add("fué condenado a muerte");
            listaSuicidios.add("se sacrificó y salvó a la humanidad");
        }
        int x=(int)(Math.random()*listaSuicidios.size());
        String y=listaSuicidios.get(x);
        listaSuicidios.remove(x);
        return y;
    }
    public String rellenarCombateFinal(){
        if(combateFinal.isEmpty()) {
            combateFinal.add("escupió a ");
            combateFinal.add("hizó el mataleones a ");
            combateFinal.add("esquivó un puñetazo a ");
            combateFinal.add("parece que está un nivel por encima de ");
        }
        int x=(int)(Math.random()*combateFinal.size());
        String y=combateFinal.get(x);
        combateFinal.remove(x);
        return y;
    }
    public String rellenarNadaDuo(){
        if(listaNadaDuos.isEmpty()) {
            listaNadaDuos.add("está manteniendo una aventura en secreto con");
            listaNadaDuos.add("se ha ido de fiesta con ");
            listaNadaDuos.add("se ha metido unas rayas con ");
            listaNadaDuos.add("se está drogando con ");
            listaNadaDuos.add("se está peleando con ");
            listaNadaDuos.add("tiene un duelo de baile con ");
            listaNadaDuos.add("está haciendo el amor con ");
            listaNadaDuos.add("se está enamorando de ");
            listaNadaDuos.add("está durmiendo abrazado con ");
            listaNadaDuos.add("ha montado una nueva religión con ");
            listaNadaDuos.add("está fumandose un piti con ");
            listaNadaDuos.add("está fumandose un porrillo con ");
            listaNadaDuos.add("ha ido a pedirle matrimonio a ");
            listaNadaDuos.add("ha rechazado el amor de ");
            listaNadaDuos.add("va a tener un hijo con ");
            listaNadaDuos.add("ha descubierto la homosexualidad de ");
            listaNadaDuos.add("ha descubierto que su hijo/a es ");
            listaNadaDuos.add("es el fan numero 1 de ");
        }

        int x=(int)(Math.random()*listaNadaDuos.size());
        String y=listaNadaDuos.get(x);
        listaNadaDuos.remove(x);
        return y;
    }

    public String rellenarTraicion() {
        if(Traicion.isEmpty()) {
            Traicion.add("se ha cambiado de equipo");
            Traicion.add("se ha vendido por 5€");
            Traicion.add("ha traicionado a sus amigos");
            Traicion.add("es el nuevo Judas");
        }
        int x=(int)(Math.random()*Traicion.size());
        String y=Traicion.get(x);
        Traicion.remove(x);
        return y;
    }
}
