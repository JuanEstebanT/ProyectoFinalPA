package Vistas;

import javax.swing.*;
import java.awt.*;

public class Vista_prin extends JFrame{

    public JButton playButton;
    public JButton scoresButton;
    public JButton resetButton;
    private JPanel panel1;

    public Vista_prin(){
        setContentPane(panel1);
        setSize(400, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Snake_UD 1.0");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createUIComponents() {
        Color celeste = new Color(134,245,227);
        panel1 = new JPanel();
        panel1.setBackground(celeste);
    }
}
