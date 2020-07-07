package jrazek.pong.entities;

import jrazek.pong.Map;
import jrazek.pong.Utils;
import jrazek.pong.abstracts.Entity;
import jrazek.pong.graphics.myShape;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Ball extends Entity {
    private float radius;
    private Utils.Vector2F pos;
    public Ball(float radius, Utils.Vector2F pos){
        super(pos);
        this.radius = radius;
        this.pos = pos;
        super.setShape(new myShape(new Ellipse2D.Float(pos.getX(), pos.getY(), radius, radius), Color.RED, true));
    }
    public Ball(float radius, Utils.Vector2F pos, Map map){
        super(pos, map);
        this.radius = radius;
        this.pos = pos;
        super.setShape(new myShape(new Ellipse2D.Float(pos.getX(), pos.getY(), radius, radius), Color.RED, true));
    }

    @Override
    public void addToMap() {
        super.getMap().addBall(this);
    }

    @Override
    public void onCollision(boolean horizontal) {
        Utils.Vector2F v = super.getVelocity();
        if(horizontal)
            super.setVelocity(new Utils.Vector2F(-v.getX(), v.getY()));
        else
            super.setVelocity(new Utils.Vector2F(v.getX(), -v.getY()));
    }
}
