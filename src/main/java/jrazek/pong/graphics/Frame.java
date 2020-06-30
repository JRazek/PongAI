package jrazek.pong.graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;

public class Frame extends JFrame {

    GraphicsDraw graphicsDraw = new GraphicsDraw();

    public Frame(){
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setTitle("26 need more tits");
        super.pack();
        super.setSize(1000, 1000);
        super.setVisible(true);
        this.add(graphicsDraw);
    }
    public GraphicsDraw getGraphicsDraw() {
        return graphicsDraw;
    }
}
