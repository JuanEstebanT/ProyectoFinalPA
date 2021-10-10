package Modelos;

import Controladores.Controlador_juego;
// Verifica el Autochoque en un hilo ya que en pintar ocurre un error de autochoque inmediato
public class Hilo4 extends Thread{
    private boolean estado = true;
    @Override
    public void run() {
        while(estado){
            while(estado){
                Controlador_juego.VerificarAutoChoque();
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
