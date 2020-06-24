package jrazek.pong.templates;

import jrazek.pong.Utils;

import java.awt.*;

public abstract class Entity {
    private int velocity; //velocity in x axis only
    private Utils.Vector2I pos; //position
    private Shape shape;
    public Entity(){
        velocity = 0;
        pos = new Utils.Vector2I(0,0);
    }
    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }
    public void move(){
        pos = new Utils.Vector2I(pos.getX() + velocity, pos.getY());
    }
    public abstract void hitWall();
}
