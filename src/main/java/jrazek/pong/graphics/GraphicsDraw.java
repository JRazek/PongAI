package jrazek.pong.graphics;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GraphicsDraw extends JPanel{

    List<myShape> shapes = new ArrayList<>();

    public void paintComponent(Graphics g){
        super.setBackground(Color.GRAY);
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D)g;
        for(myShape s : shapes){
            System.out.println(shapes.size());
            g2D.setColor(s.getColor());
            g2D.draw(s.getShape());
        }
    }
    public void addShape(myShape s){
        shapes.add(s);
    }
    public void removeShape(myShape s){
        shapes.remove(s);
    }
}
