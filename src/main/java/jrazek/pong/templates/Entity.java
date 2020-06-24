package jrazek.pong.templates;

import jrazek.pong.Utils;

import java.awt.*;

public abstract class Entity {
    private Utils.Vector2I velocity;
    private Utils.Vector2I pos; //position
    private Shape shape;
    public Entity(){
        velocity = new Utils.Vector2I(0,0);
        pos = new Utils.Vector2I(0,0);
    }
    public void setVelocity(Utils.Vector2I velocity) {
        this.velocity = velocity;
    }
    public void move(){
        pos = new Utils.Vector2I(pos.getX() + velocity.getX(), pos.getY() + velocity.getY());
    }
    public Utils.Vector2I getPos() {
        return pos;
    }
    public abstract void hitWall(boolean vertical);//boolean if true - hit in vertical wall else horizontal
}
