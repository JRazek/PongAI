package jrazek.pong.abstracts;

import jrazek.pong.Main;
import jrazek.pong.Map;
import jrazek.pong.Utils;
import jrazek.pong.graphics.myShape;

public abstract class Entity {
    private Utils.Vector2F pos;
    private myShape shape;
    private Utils.Vector2F velocity = new Utils.Vector2F(0,0);
    private Map map;
    public Entity(Utils.Vector2F pos){
        this.pos = pos;
    }
    public Entity(Utils.Vector2F pos, Map map){
        this.pos = pos;
        this.map = map;
    }
    public void addToDrawList(){
        map.addEntity(this);
        map.getFrame().getGraphicsDraw().addShape(shape);
    }
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
    }
    public Map getMap() {
        return map;
    }
    public void move(){
        pos = new Utils.Vector2F(pos.getX() + velocity.getX(), pos.getY() + velocity.getY());
    }
    public abstract void onWallHit(boolean horizontal);//on true horizontal hit on false vertical hit
    public myShape getShape() {
        return shape;
    }
}
