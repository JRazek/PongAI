package jrazek.pong.graphics;

import jrazek.pong.Utils;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.lang.reflect.Constructor;

public class myShape {
    private Shape shape;
    private Color color;
    public myShape(Shape s, Color cl){
        this.shape = s;
        this.color = cl;
    }
    public void changePos(Utils.Vector2F pos){
        if(shape.getClass().equals(Rectangle2D.Float.class)){
            shape = new Rectangle2D.Float(pos.getX(), pos.getY(), (float)shape.getBounds2D().getWidth(), (float)shape.getBounds2D().getHeight());
        }
        if(shape.getClass().equals(Ellipse2D.Float.class)){
            shape = new Ellipse2D.Float(pos.getX(), pos.getY(), (float)shape.getBounds2D().getWidth(), (float)shape.getBounds2D().getHeight());
        }
    }
    public Color getColor() {
        return color;
    }

    public Shape getShape() {
        return shape;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }
}
