package Vistas;

import Controladores.Controlador_juego;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Tablero extends JPanel{
    String puntaje = "";
    public Tablero(){
        setSize(100,100);
        this.setBackground(Color.gray);
    }
    public void setPuntaje(String puntaje) {
        this.puntaje = puntaje;
    }

    @Override
    public void paint(Graphics g){
        Controlador_juego.pintarDibujables(g);
    }
    
}
