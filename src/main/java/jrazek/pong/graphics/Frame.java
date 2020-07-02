package jrazek.pong.graphics;

import jrazek.pong.Map;

import javax.swing.*;
public class Frame extends JFrame {

    GraphicsDraw graphicsDraw = new GraphicsDraw();
    Map map;
    public Frame(Map m){
        this.map = m;
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setTitle("26 need more tits");
        super.pack();
        super.setSize(map.getSize().getX(), map.getSize().getY());
        super.setVisible(true);
        this.add(graphicsDraw);
        graphicsDraw.setMap(this.map);
    }
    public Frame(){
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setTitle("26 need more tits");
        super.pack();
        super.setVisible(true);
        this.add(graphicsDraw);
    }

    public void setMap(Map map) {
        this.map = map;
        super.setSize(map.getSize().getX(), map.getSize().getY());
        graphicsDraw.setMap(this.map);
    }

    public GraphicsDraw getGraphicsDraw() {
        return graphicsDraw;
    }
}
