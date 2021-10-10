package Modelos;

import Controladores.Controlador_juego;
/**
 * Este hilo ejecuta la generación de comida
 * */
public class Hilo3 extends Thread{
    private boolean estado = true;
    @Override
    public void run() {
        while(estado){
            while(estado){
                Controlador_juego.Gen_comida();
                try {
                    sleep(100);
                }catch (Exception e) {

                }
            }
        }
    }
    public void detenerHilo(){
        estado = false;
    }
}