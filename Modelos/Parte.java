package Modelos;

public abstract class Parte implements Movible, Dibujable {
    
    protected int x;
    protected int y;
    protected Parte siguiente = null;
    
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Parte getSiguiente(){ return siguiente;}


    // Verifica el auto choque
    public boolean Verificar_choque(int x, int y){
        boolean ver = false;
        if(this.x == x && this.y == y){
            ver = true;
        }else{
            if(this.siguiente == null){
                ver = false;
            }else{
                return this.siguiente.Verificar_choque(x,y);
            }
        }
        return ver;
    }
    // verifica el contacto entre la comida y el snake
    public  boolean Verificar_collison(int x, int y){
        boolean ver = false;
        if (this.x == x && this.y == y){
            ver = true;
            this.x = Ramdonx();
            this.y = Ramdony();
        }else{
            if(this.siguiente == null){
                ver = false;
            }else{
                return this.siguiente.Verificar_collison(x,y);
            }
        }
        return ver;
    }
    // posiciones random
    public static int Ramdonx(){
        int x = (int) Math.floor(Math.random()*32);
        return x;
    }
    public static int Ramdony(){
        int y = (int)Math.floor(Math.random()*21);
        return y;
    }
}
