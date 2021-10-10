package Controladores;

import Modelos.*;
import Vistas.Tablero;
import Vistas.Vista_prin;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class Controlador_juego {
    // Instancias
    public static Parte culebra = new Cabeza(Ramdonx(), Ramdony());
    public static Parte comida = new Comida(Ramdonx(),Ramdony());
    public static Puntaje puntaje = new Puntaje("Puntaje : ");
    public static ArrayList<Dibujable> dibujables = new ArrayList<>();
    public static JFrame ventana = new JFrame("Snake");
    public static Tablero t = new Tablero();
    public static ControladorTeclado teclado=new ControladorTeclado();
    public static Hilo h1 = new Hilo();
    public static Thread h2 = new Thread(((Cabeza) culebra));
    public static Hilo3 h3 = new Hilo3();
    public static Hilo4 h4 = new Hilo4();

    public static int Ramdonx(){
        int x = (int) Math.floor(Math.random()*32);
        return x;
    }
    public static int Ramdony(){
        int y = (int)Math.floor(Math.random()*21);
        return y;
    }
    public static void pintarDibujables(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        for(Dibujable d: dibujables){
            d.dibujar(g2);
        }
    }
    // inicio del juego
    public static void iniciar(){
        ventana = new JFrame("Snake");
        culebra = new Cabeza(Ramdonx(), Ramdony());
        comida = new Comida(Ramdonx(),Ramdony());
        puntaje = new Puntaje("Puntaje : ");
        dibujables = new ArrayList<>();
        teclado=new ControladorTeclado();
        t = new Tablero();
        h1 = new Hilo();
        h2 = new Thread(((Cabeza) culebra));
        h3 = new Hilo3();
        h4 = new Hilo4();
        dibujables.add(puntaje);
        dibujables.add(culebra);
        dibujables.add(comida);
        ventana.setBounds(0,0,657,700);
        ventana.setLocationRelativeTo(null);
        ventana.setResizable(false);
        ventana.add(t);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.addKeyListener(teclado);
        iniciarHilos();
    }

    private static void iniciarHilos() {
        h1.start();
        h2.start();
        h3.start();
        h4.start();
    }

    //direccion es 1 hacia la derecha, 2 abajo, 3 izquierda, 4 arriba.
    public static void cambiarDireccion(int dir){
        int var = Math.abs(((Cabeza) culebra).getDireccion() - dir);
        if(var!=2){
          ((Cabeza) culebra).setDireccion(dir);
        }
    }


    /* Genera nueva comida y apartir de mas de 10 genera otro cuerpo comida PD: es ejecutada por el Hilo 3*/
    public static void Gen_comida(){
        if(Comparar_pos()){
            ((Comida) comida).setComida_generada(((Comida) comida).getComida_generada()+1);
            puntaje.setPuntaje("Puntaje : "+((Comida) comida).getComida_generada());
            ((Cabeza) culebra).agregarC();
            if(((Comida) comida).getComida_generada()%10==0){
                ((Comida) comida).agregarCuerpo();
            }
        }
    }

    /* Comparar la posicion de la comida y regresa un boleano si se tocan*/
    public static boolean Comparar_pos(){
        boolean ver = false;
        if(comida.Verificar_collison(culebra.getX(), culebra.getY())){
            ver = true;
        }
        return ver;
    }

    public static void PosCul(){
        if (culebra.getX() > 31){
            culebra.setX(0);
        }
        if (culebra.getY() > 27){
            culebra.setY(0);
        }
        if (culebra.getX() < 0){
            culebra.setX(31);
        }
        if (culebra.getY() < 0){
            culebra.setY(27);
        }
    }
    /*Verifica el autochoque y es ejecutado por el hilo 4*/
    public static void VerificarAutoChoque(){
        if(((Cabeza)culebra).Verificar()){
            ventana.dispose();
            DetenerHilos();
            //lugar donde daberia ir un JOPTION para ingresar (nombre del jugador y el getComida generada)scores serializarlos
            // sugerencia crear un nuevo frame para visualizar los scores en una ventana a traves de el boton scores
        }
    }
    public static void DetenerHilos(){
        h1.detenerHilo();
        ((Cabeza)culebra).detenerHilo();
        h3.detenerHilo();
        h4.detenerHilo();
    }

    public static void repintar(){
        PosCul();
        t.repaint();
    }

    }

/*if(((Cabeza)culebra).getSiguiente().Verificar_choque(((Cabeza) culebra).getX(),((Cabeza) culebra).getY())){
        h1.setEstado(false);
        ver= true;
        }*/
