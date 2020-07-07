package jrazek.pong.abstracts;

import jrazek.pong.Main;
import jrazek.pong.Map;
import jrazek.pong.Utils;
import jrazek.pong.entities.Ball;
import jrazek.pong.graphics.myShape;

public abstract class Entity extends DrawableObject<Ball> {
    private Utils.Vector2F pos;
    private myShape shape;
    private Utils.Vector2F velocity = new Utils.Vector2F(0,0);
    private Map map;
    public Entity(Utils.Vector2F pos, myShape s){
        super(s);

        this.pos = pos;
    }
    public Entity(Utils.Vector2F pos, myShape s, Map map){
        super(s);
        this.pos = pos;
        setMap(map);
    }
    public abstract void addToMap();
    public void removeFromDrawList(){
        Main.frame.getGraphicsDraw().removeShape(shape);
    }
    public Utils.Vector2F getPos() {
        return pos;
    }
    public void setVelocity(Utils.Vector2F velocity) {
        this.velocity = velocity;
    }
    public Utils.Vector2F getVelocity() {
        return velocity;
    }
    public void accelerate(Utils.Vector2F delta){
        this.velocity = new Utils.Vector2F(this.velocity.getX() + delta.getX(), this.velocity.getY() + delta.getY());
    }
    public void setShape(myShape shape) {
        this.shape = shape;
    }
    public void setMap(Map map) {
        this.map = map;
        addToMap();
    }
    public Map getMap() {
        return map;
    }
    public void move(){
        pos = new Utils.Vector2F(pos.getX() + velocity.getX(), pos.getY() + velocity.getY());
        this.shape.changePos(this.pos);
    }
    public abstract void onCollision(boolean horizontal);//on true horizontal hit on false vertical hit
    public myShape getShape() {
        return shape;
    }
    public void kill(){

    }
}
