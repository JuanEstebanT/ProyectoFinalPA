package Modelos;

import Modelos.Dibujable;

import java.awt.*;

/**
 * Esta Clase maneja el dibujo de el contador de puntaje
 * el puntaje es llevado por la clase comida en su atributo comida generada
 * */
public class Puntaje implements Dibujable {
    // texto de el letrero
    String puntaje = "";

    public Puntaje(String puntaje){
        this.puntaje = puntaje;
    }
    public void setPuntaje(String puntaje) {
        this.puntaje = puntaje;
    }

    @Override
    public void dibujar(Graphics2D g) {

        g.clearRect(239, 590,200 , 42); // borrador
        Color Celeste = new Color(112,255,245);
        Color Rosita = new Color(255,43,174);
        Color verde = new Color(72,245,56);
        g.setColor(Rosita);
        g.fillRoundRect(10,565,620,85,7,7);
        g.setColor(verde);
        g.fillRoundRect(20,570,600,75,7,7);
        Font myFont = new Font ("outrun future", 1, 28);
        g.setFont(myFont);
        g.setColor(Color.black);
        g.drawString(puntaje,240,620);

    }
}
