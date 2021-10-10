package Modelos;

import java.awt.Color;
import java.awt.Graphics2D;

public class Cabeza extends Parte implements Runnable{
    
    //direccion es 1 hacia la derecha, 2 abajo, 3 izquierda, 4 arriba.
    private int direccion;
    private boolean estado = true;
    public boolean ver = false;
    public Cabeza(int x, int y){
        this.x = x;
        this.y = y;
        this.direccion = 1;
        this.siguiente = new Cuerpo(this.x, this.y);
        agregarC();
    }

    @Override
    public void run() {
        while(estado){
            mover();
                try {
                    Thread.sleep(200);
                }catch (Exception e) {
                    System.err.println(e);
                }
        }
    }
    public void detenerHilo(){
        estado = false;
    }
    @Override
    public void mover() {
        this.siguiente.mover(this.x, this.y);
        switch(direccion){
            case 1:
                x++;
                break;
            case 2:
                y++;
                break;
            case 3:
                x--;
                break;
            case 4:
                y--;
                break;
            }
    }

    @Override
    public void mover(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void dibujar(Graphics2D g) {
        this.siguiente.dibujar(g);
        g.setColor(Color.black);
        g.fillOval(x*20, y*20, 20, 20);
    }

    public void setDireccion(int direccion){
      this.direccion = direccion;
    }
    public int getDireccion(){
      return this.direccion;
    }
    public void agregarC(){
        ((Cuerpo)this.siguiente).agregarCuerpo();
    }
    // verifica autochoque
    public boolean Verificar(){
        if(((Cuerpo)this.siguiente).getSiguiente().Verificar_choque(this.x,this.y)){
            ver = true;
        }else{
            ver = false;
        }
        return ver;
    }

    public void setVer(boolean ver) {
        this.ver = ver;
    }
}
