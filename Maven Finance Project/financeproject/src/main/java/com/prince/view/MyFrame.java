package com.prince.view;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame{
    
    public MyFrame(){

        // JLabel label = new JLabel(" Testing");
        // this.add(label);
        this.setTitle("Secretary Application");
        this.setSize(300, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        // ImageIcon image = new ImageIcon();
        // frame.setIconImage(getIconImage());

        this.getContentPane().setBackground(new Color(252, 186, 3));
    }
}
        