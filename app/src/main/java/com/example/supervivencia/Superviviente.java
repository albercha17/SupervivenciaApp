package com.example.supervivencia;

public class Superviviente{
    String nombre;
    int vida;
    estado estadoS;



    enum estado{ VIVO, MUERTO}
    Superviviente(String nombre){
        this.nombre=nombre;
        this.vida=1;
        this.estadoS=estado.VIVO;
    }
    // getter and setters
    public String getNombre() {
        return this.nombre;
    }
    public Integer getVida() {
        return this.vida;
    }
    public estado getEstado() {
        return this.estadoS;
    }
    public void setNombre(String nombre) {
         this.nombre=nombre;
    }
    public void setVida(Integer vida) {
         this.vida=vida;
    }
    public void setEstado(estado estadoS) {
         this.estadoS=estadoS;
    }

    public void dañar(int daño){
        vida-=daño;
        if(vida<=0) estadoS=estado.MUERTO;
    }
    public void resucitar(){
        this.vida=1;
        estadoS=estado.VIVO;
    }
}
