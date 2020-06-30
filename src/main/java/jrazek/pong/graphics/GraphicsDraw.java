package jrazek.pong.graphics;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GraphicsDraw extends JPanel{

    List<Shape> shapes = new ArrayList<>();

    public void paintComponent(Graphics g){
        super.setBackground(Color.GRAY);
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D)g;
        for(Shape s : shapes){
            System.out.println(shapes.size());
            g2D.setColor(Color.BLACK);
            g2D.draw(s);
        }
    }
    public void addShape(Shape s){
        shapes.add(s);
    }
    public void removeShape(Shape s){
        shapes.remove(s);
    }
}
