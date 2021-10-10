package Controladores;

import Vistas.Vista_prin;

public class Controlador_principal{
    public Controlador_principal(Vista_prin Vista){
        Vista.setVisible(true);
        Vista.playButton.addActionListener(e -> {
               Controlador_juego.iniciar();
               Vista.dispose();
        });
        Vista.scoresButton.addActionListener(e -> {

        });
    }

}
