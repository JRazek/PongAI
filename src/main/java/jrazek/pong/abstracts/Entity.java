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
        super(f, s, pos, true);
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
    private void setMap(Map map) {
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

    @Override
    public boolean isColliding(DrawableObject o) {
        Utils.Vector2F p1 = new Utils.Vector2F(getPos().getX(), getPos().getY());
        Utils.Vector2F p2 = new Utils.Vector2F(getPos().getX() + getShape().getSize().getX(), getPos().getY());
        Utils.Vector2F p3 = new Utils.Vector2F(getPos().getX() + getShape().getSize().getX(), getPos().getY() + getShape().getSize().getY());
        Utils.Vector2F p4 = new Utils.Vector2F(getPos().getX(), getPos().getY() + getShape().getSize().getY());
        boolean s1 = o.pointBelongs(p1);
        boolean s2 = o.pointBelongs(p2);
        boolean s3 = o.pointBelongs(p3);
        boolean s4 = o.pointBelongs(p4);
        System.out.println("s1 - " + s1);
        System.out.println("s2 - " + s2);
        System.out.println("s3 - " + s3);
        System.out.println("s4 - " + s4);
        return (s1 || s1 || s3 || s4);
    }
}
