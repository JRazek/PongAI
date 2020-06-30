package jrazek.pong;
import jrazek.pong.Utils.*;
import jrazek.pong.abstracts.Entity;
import jrazek.pong.graphics.GraphicsDraw;

import java.awt.*;

public class Paddle extends Entity {
    private Vector2I size;
    private Vector2I pos;
    public Paddle(Vector2I size, Vector2I pos){
        super(size, Color.BLUE);
        this.size = size;
        this.pos = pos;
    }
    public void draw(Graphics gp){
        Graphics2D g2d = (Graphics2D)gp;
        Rectangle rect = new Rectangle(pos.getX(), pos.getY(), size.getX(), size.getY());
        Main.frame.getGraphicsDraw().addShape(rect);
    }
}
