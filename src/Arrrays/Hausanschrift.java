package Arrrays;

import javax.swing.JFrame;
import java.awt.*;

public class Hausanschrift extends JFrame {
    public Hausanschrift()
    {
        setTitle("Sheeeeeesh");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public static void disp(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Hausanschrift a = new Hausanschrift();
                a.setVisible(true);
            }
        });

    }

}










