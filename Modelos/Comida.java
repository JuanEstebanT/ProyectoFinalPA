package Modelos;

import java.awt.*;

public class Comida extends Parte {
    // uso como puntaje
    private int Comida_generada = 0;

    public Comida(int x,int y){
        this.x = x;
        this.y = y;
    }

    public void setComida_generada(int comida_generada) {
        Comida_generada = comida_generada;
    }

    public int getComida_generada() {
        return Comida_generada;
    }

    public void agregarCuerpo(){
        if (this.siguiente==null){
            Comida cuerponuevo = new Comida(Ramdonx(),Ramdony());
            this.siguiente = cuerponuevo;
        }
        else{
            ((Comida) this.siguiente).agregarCuerpo();
        }
    }
    public static int Ramdonx(){
        int x = (int) Math.floor(Math.random()*32);
        return x;
    }
    public static int Ramdony(){
        int y = (int)Math.floor(Math.random()*21);
        return y;
    }
    @Override
    public void mover() {
        //No tiene movimiento propio
    }

    @Override
    public void mover(int x, int y) {
        if(this.siguiente!=null)
            this.siguiente.mover(Ramdony(),Ramdony());
        this.x = x;
        this.y =y;

    }
    public void agregarCo(){
        ((Comida)this.siguiente).agregarCuerpo();
    }
    @Override
    public void dibujar(Graphics2D g) {
        g.setColor(Color.red);
        g.fillOval(x*20, y*20, 20, 20);
        if(this.siguiente!=null){
            this.siguiente.dibujar(g);
        }
    }
}
