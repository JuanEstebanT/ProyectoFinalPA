package Modelos;

import java.awt.Color;
import java.awt.Graphics2D;

public class Cuerpo extends Parte {
    
    public Cuerpo(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public void agregarCuerpo(){
        if (this.siguiente==null){
            Cuerpo cuerponuevo = new Cuerpo(this.x, this.y);
            this.siguiente = cuerponuevo;
        }
        else{
            ((Cuerpo) this.siguiente).agregarCuerpo();
        }
    }
    @Override
    public void mover() {
        //No tiene movimiento propio
    }

    @Override
    public void mover(int x, int y) {
        if(this.siguiente!=null)
            this.siguiente.mover(this.x,this.y);
        this.x = x;
        this.y =y;
        
    }

    @Override
    public void dibujar(Graphics2D g) {
        
        g.setColor(Color.green);
        g.fillOval(x*20, y*20, 20, 20);
        if(this.siguiente!=null){
            this.siguiente.dibujar(g);
        }else{
            g.setColor(Color.white);
            g.fillOval(x*20, y*20, 20, 20);
        }
        
    }
    
}
