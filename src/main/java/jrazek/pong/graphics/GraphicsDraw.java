package jrazek.pong.graphics;

import jrazek.pong.Map;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GraphicsDraw extends JPanel implements ActionListener {

    Timer timer;
    int ticks = 0;
    Map map;
    List<myShape> shapes = new ArrayList<>();

    public void paintComponent(Graphics g){
        super.setBackground(Color.GRAY);
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D)g;
        for(myShape s : shapes){
            System.out.println(shapes.size());
            g2D.setColor(s.getColor());
            g2D.fill(s.getShape());
        }
    }
    public void addShape(myShape s){
        shapes.add(s);
    }
    public void removeShape(myShape s){
        shapes.remove(s);
    }

    public void setMap(Map map) {
        this.map = map;
        timer = new Timer(1000/20,this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        System.out.println(ticks);
        ticks++;
        map.step();
        repaint();
    }
}
