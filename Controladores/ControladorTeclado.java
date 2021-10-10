package Controladores;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class ControladorTeclado implements KeyListener{
  
  //UP = 224, DOWN = 225, LEFT = 226, RIGHT = 227
  @Override
  public void keyPressed(KeyEvent e){
    switch (e.getKeyCode()){
      case KeyEvent.VK_UP:
        Controlador_juego.cambiarDireccion(4);
        break;
      case KeyEvent.VK_DOWN:
        Controlador_juego.cambiarDireccion(2);
        break;
      case KeyEvent.VK_LEFT:
        Controlador_juego.cambiarDireccion(3);
        break;
      case KeyEvent.VK_RIGHT:
        Controlador_juego.cambiarDireccion(1);
        break;

    }
  }

  @Override
  public void keyTyped(KeyEvent e){}
  
  @Override
  public void keyReleased(KeyEvent e){}
}

