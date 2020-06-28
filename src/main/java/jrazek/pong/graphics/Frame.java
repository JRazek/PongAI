package jrazek.pong.graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;

public class Frame extends JFrame {

    public Frame(){
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setBackground(Color.GRAY);
        super.setTitle("26 need more tits");
        super.pack();
        super.setSize(1000, 1000);
        super.setVisible(true);
    }

    public void paint(Graphics g){
        g.drawRect(100,100,100,100);
    }
}
