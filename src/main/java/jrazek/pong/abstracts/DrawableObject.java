package jrazek.pong.abstracts;

import jrazek.pong.Utils;
import jrazek.pong.graphics.Frame;
import jrazek.pong.graphics.myShape;

//abstract object with no specified position
public abstract class DrawableObject {
    private Utils.Vector2F pos;
    private Frame frame;
    public boolean collidable;
    //all shapes have rectangular bounding boxes
    private myShape shape;
    public abstract boolean isColliding(DrawableObject po);
    public DrawableObject(Frame frame, myShape shape, Utils.Vector2F pos, boolean collidable){
        this.shape = shape;
        this.frame = frame;
        this.pos = pos;
        this.collidable = collidable;
        addToDrawList();
    }
    public void addToDrawList(){
        frame.getGraphicsDraw().addDrawable(this);
    }
    public void setPos(Utils.Vector2F p){
        this.pos = p;
    }

    public Utils.Vector2F getPos() {
        return pos;
    }


    public boolean pointBelongs(Utils.Vector2F point){
        boolean state = (pos.getX() <= point.getX() && pos.getX() + shape.getSize().getX() >= point.getX()
            && pos.getY() <= point.getY() && pos.getY() + shape.getSize().getY() >= point.getY());
        return state;
    }
    public myShape getShape() {
        return shape;
    }
}
