import Controladores.Controlador_juego;
import Controladores.Controlador_principal;
import Vistas.Vista_prin;
/**
 * Este es un Juego de snake clasico en el cual implementamos los hilos la serialización y las graphic's para el proyecto final
 * */
class Main {
  public static void main(String[] args) {
    Vista_prin Vista = new Vista_prin();
    Controlador_principal c = new Controlador_principal(Vista);
  }
}

