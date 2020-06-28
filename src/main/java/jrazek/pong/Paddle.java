package jrazek.pong;
import jrazek.pong.Utils.*;
import jrazek.pong.abstracts.Entity;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Paddle extends Entity {
    private Vector2I size;
    private Vector2I pos;
    public jrazek.pong.graphics.Graphics g;
    public Paddle(Vector2I size, Vector2I pos){
        super(size, Color.BLUE);
        this.size = size;
        this.pos = pos;
    }
    public void draw(Graphics gp){
        Graphics2D g2d = (Graphics2D)gp;
        Rectangle2D.Float rect = new Rectangle2D.Float(pos.getX(), pos.getY(), size.getX(), size.getY());

    }
    public jrazek.pong.graphics.Graphics getG(){
        return g;
    }
}
