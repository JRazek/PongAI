package jrazek.pong.graphics;

import jrazek.pong.Map;
import jrazek.pong.abstracts.DrawableObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

public class GraphicsDraw extends JPanel implements ActionListener{

    private Timer timer;
    private int ticks = 0;
    private Map map;//only for incrementing step
    private List<DrawableObject> drawableObjects = new ArrayList<>();
    boolean isLinux;
    GraphicsDraw(){
        if(System.getProperty("os.name").equalsIgnoreCase("linux"))
            isLinux = true;
    }
    @Override
    public void paintComponent(Graphics g){
        super.setBackground(Color.GRAY);
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D)g;
        if(isLinux)
            Toolkit.getDefaultToolkit().sync();
        //dont change!
        for(int i = 0 ; i < drawableObjects.size(); i++){
            DrawableObject o = drawableObjects.get(i);
            myShape s = o.getShape();
            g2D.setColor(s.getColor());
            if(s.isFilled()) {
                g2D.fill(s.getShape());
            }
            else {
                g2D.draw(s.getShape());
            }
        }
    }
    public void addDrawable(DrawableObject o){
        drawableObjects.add(o);
    }
    public void removeDrawable(DrawableObject o){
        drawableObjects.remove(o);
    }

    public void setMap(Map map) {
        this.map = map;
        timer = new Timer(10,this);
        timer.start();
        map.getFrame().addMouseListener(new MouseListener(map.getFrame(), map));
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if((actionEvent.getSource() instanceof Timer)) {
            map.step();
            ticks++;
            repaint();
        }

    }
    public void toggleTimer(){
        if(timer.isRunning()) {
            timer.stop();
            map.foreachAllEntityData();
        }
        else
            timer.start();
    }
    public void stop(){
        timer.stop();
    }
}
