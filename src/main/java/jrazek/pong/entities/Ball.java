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
        super.setShape(new myShape(new Ellipse2D.Float(pos.getX(), pos.getY(), radius, radius), Color.RED));
    }
    public Ball(float radius, Utils.Vector2F pos, Map map){
        super(pos, map);
        this.radius = radius;
        this.pos = pos;
        super.setShape(new myShape(new Ellipse2D.Float(pos.getX(), pos.getY(), radius, radius), Color.RED));
    }

    @Override
    public void onWallHit(boolean horizontal) {

    }
}
