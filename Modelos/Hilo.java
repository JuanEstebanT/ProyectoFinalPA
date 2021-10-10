package Modelos;

import Controladores.Controlador_juego;
/*
* Ejecuata el repintar tablero
* */
public class Hilo extends Thread{
    private boolean estado = true;
    @Override
    public void run() {
        while(estado){
            while(estado){
                Controlador_juego.repintar();
                try {
                    sleep(200);
                }catch (Exception e) {

                }
            }
        }
    }
    public void detenerHilo(){
        estado = false;
    }
}