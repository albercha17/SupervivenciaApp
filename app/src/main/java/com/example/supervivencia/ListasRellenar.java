package com.example.supervivencia;

import java.util.ArrayList;

public class ListasRellenar {

    ArrayList<String> listaMuertes;
    ArrayList<String> listaNadaDuos;
    ArrayList<String> listaSuicidios;
    ArrayList<String> combateFinal;
    ArrayList<String> Traicion;
    public ListasRellenar(){
        listaMuertes=new ArrayList<String>();
        listaNadaDuos=new ArrayList<String>();
        listaSuicidios=new ArrayList<String>();
        combateFinal=new ArrayList<String>();
        Traicion=new ArrayList<String>();
    }
    public ArrayList<String> rellenarMuertes(){
        listaMuertes.clear();
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
        return listaMuertes;
    }
    public ArrayList<String> rellenarSuicidios(){
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
        return listaSuicidios;
    }
    public ArrayList<String> rellenarCombateFinal(){
        combateFinal.add("escupió a ");
        combateFinal.add("hizó el mataleones a ");
        combateFinal.add("esquivó un puñetazo a ");
        combateFinal.add("parece que está un nivel por encima de ");
        return combateFinal;
    }
    public ArrayList<String> rellenarNadaDuo(){
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

        return listaNadaDuos;
    }

    public ArrayList<String> rellenarTraicion() {
        Traicion.add("se ha cambiado de equipo");
        Traicion.add("se ha vendido por 5€");
        Traicion.add("ha traicionado a sus amigos");
        return Traicion;
    }
}
