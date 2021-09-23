package com.example.supervivencia;

public class SupervivienteDuos {
    String nombre1;
    String nombre2;
    String pareja;
    int vida;

    estado estadoS;



    enum estado{ VIVO, MUERTO}
    SupervivienteDuos(String nombre){
        this.nombre1=nombre;
        this.nombre2=null;
        this.vida=1;
        this.estadoS= estado.VIVO;
        this.pareja=nombre;
    }
    // getter and setters
    public String getNombre() {
        return this.nombre1;
    }
    public String getNombre2(){return this.nombre2;}
    public String getpareja(){return this.pareja;}
    public Integer getVida() {
        return this.vida;
    }
    public estado getEstado() {
        return this.estadoS;
    }
    public void setVida(Integer vida) {
         this.vida=vida;
    }
    public void setEstado(estado estadoS) {
         this.estadoS=estadoS;
    }

    public void dañar(int daño){
        vida-=daño;
        if(vida<=0) estadoS= estado.MUERTO;
    }
    public void añadir_compi(String x){

        this.nombre2=x;
        pareja+=" y "+x;
    }
    public String matar(){
        String muerto=null;
        if(this.nombre1!=null && this.nombre2!=null) {
            int x = (int) (Math.random() * 2);
            if (x == 0) {
                muerto=this.nombre1;
                this.nombre1 = this.nombre2;
            }
            else{
                muerto=this.nombre2;
            }
            this.nombre2 = null;
        }
        else if(this.nombre2==null){
            muerto=this.nombre1;
            this.nombre1=null;

        }
        return muerto;
    }
    public String asesino(){
        String y=this.nombre1;
        if(this.nombre2!=null) {
            int x = (int) (Math.random() * 2);
            if (x == 0) {
                return y;
            } else { return this.getNombre2();
            }
        }
        return y;
    }
    public boolean eliminar(){
        if(this.nombre1==null) {
            return true;
        }
        else return false;
    }
    public void resucitar(){
        this.vida=1;
        estadoS= estado.VIVO;
    }
}
