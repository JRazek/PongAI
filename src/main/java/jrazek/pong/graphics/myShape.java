package jrazek.pong.graphics;

import java.awt.*;

public class myShape {
    private Shape shape;
    private Color color;
    public myShape(Shape s, Color cl){
        this.shape = s;
        this.color = cl;
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
