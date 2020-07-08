package jrazek.pong.abstracts;

import jrazek.pong.Main;
import jrazek.pong.Map;
import jrazek.pong.Utils;
import jrazek.pong.entities.Ball;
import jrazek.pong.graphics.Frame;
import jrazek.pong.graphics.myShape;

public abstract class Entity extends DrawableObject {
    private Utils.Vector2F velocity = new Utils.Vector2F(0,0);
    private Map map;
    public Entity(Utils.Vector2F pos, myShape s, Map map, Frame f){
        super(f, s, pos);
        setMap(map);
    }
    public abstract void addToMap();
    public void setVelocity(Utils.Vector2F velocity) {
        this.velocity = velocity;
    }
    public Utils.Vector2F getVelocity() {
        return velocity;
    }
    public void accelerate(Utils.Vector2F delta){
        this.velocity = new Utils.Vector2F(this.velocity.getX() + delta.getX(), this.velocity.getY() + delta.getY());
    }
    public void setMap(Map map) {
        this.map = map;
        addToMap();
    }
    public Map getMap() {
        return map;
    }
    public void move(){
        Utils.Vector2F pos = super.getPos();
        super.setPos(new Utils.Vector2F(pos.getX() + velocity.getX(), pos.getY() + velocity.getY()));
        super.getShape().changePos(super.getPos());
    }
    public abstract void onCollision(boolean horizontal);//on true horizontal hit on false vertical hit
    public void kill(){

    }
}
