import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

public class crash implements ActionListener {
    public int count = 0;
    public int count0 = 0;
    private final JLabel label;
    private final JPanel panel;
    private final JButton button;
    private final JButton button1;

    public <button> crash() {
        JFrame frame = new JFrame();

         panel = new JPanel();
         button = new JButton("click");
         button1 = new JButton("reset");
        button.addActionListener(this);
        button1.addActionListener(this);
        label = new JLabel();
        panel.setBorder(BorderFactory.createEmptyBorder(3, 3, 1, 3));
        panel.setLayout(new GridLayout(1, 2));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(button);
        panel.add(button1);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Cookie Clicker");
        frame.pack();
        frame.setVisible(true);





    }


    public static void main(String[] args) {
        new crash();

    }

    public void bruv(){
        count--;
        label.setText("Reset" + count*0);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        count++;
        if(true) {
            label.setText("Nmeber of calicas" + count);
        System.out.println(count);}
    }


}