package jrazek.pong.graphics;

import jrazek.pong.Utils.Utils;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class myShape {
    private Shape shape;
    private Color color;
    private boolean filled;
    private Utils.Vector2F size;
    public myShape(Shape s, Color cl, boolean f){
        this.shape = s;
        this.color = cl;
        this .filled = f;
        this.size = new Utils.Vector2F((float)shape.getBounds().getHeight(), (float)shape.getBounds().getWidth());
    }
    public void changePos(Utils.Vector2F pos){
        if(shape.getClass().equals(Rectangle2D.Float.class)){
            shape = new Rectangle2D.Float(pos.getX(), pos.getY(), (float)shape.getBounds2D().getWidth(), (float)shape.getBounds2D().getHeight());
        }
        if(shape.getClass().equals(Ellipse2D.Float.class)){
            shape = new Ellipse2D.Float(pos.getX(), pos.getY(), (float)shape.getBounds2D().getWidth(), (float)shape.getBounds2D().getHeight());
        }
    }
    public Utils.Vector2F getSize(){
        return size;
    }
    public Color getColor() {
        return color;
    }
    public boolean isFilled() {
        return filled;
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
