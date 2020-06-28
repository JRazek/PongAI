package jrazek.pong.graphics;

import jrazek.pong.abstracts.Entity;

import javax.swing.*;
import java.awt.*;

public class Graphics extends JPanel{
    public Graphics(){
        super.repaint();
    }
    public void paint(java.awt.Graphics gp){
        super.paintComponent(gp);
    }
}
