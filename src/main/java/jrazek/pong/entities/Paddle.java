package jrazek.pong.entities;
import jrazek.pong.AI.LearningIndividual;
import jrazek.pong.Map;
import jrazek.pong.Utils.Utils.*;
import jrazek.pong.abstracts.Entity;
import jrazek.pong.graphics.Frame;
import jrazek.pong.graphics.myShape;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Paddle extends Entity {
    private Vector2F size;
    private Vector2F pos;
    public Paddle(Vector2F size, Vector2F pos, Map map, Frame f, LearningIndividual li){
        super(pos, new myShape(new Rectangle2D.Float(pos.getX(), pos.getY(), size.getX(),size.getY()), Color.BLUE, true), true, map, f, li);
        this.size = size;
        this.pos = pos;
    }

    @Override
    public void addToMap() {
        super.getMap().addPaddle(this);
    }

    @Override
    public void onCollision(boolean horizontal) {
        Vector2F v = super.getVelocity();
        if(horizontal)
            super.setVelocity(new Vector2F(-v.getX(), v.getY()));
        else
            super.setVelocity(new Vector2F(v.getX(), -v.getY()));
    }

}
