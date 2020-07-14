package jrazek.pong.abstracts;

import jrazek.pong.Utils.CollisionGroup;
import jrazek.pong.Utils.Utils;
import jrazek.pong.graphics.Frame;
import jrazek.pong.graphics.myShape;

//abstract object with no specified position
public abstract class DrawableObject {
    private Utils.Vector2F pos;
    private Frame frame;
    public boolean collidable;
    public CollisionGroup collisionGroup;
    public boolean solid;
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
    public DrawableObject(Frame frame, myShape shape, Utils.Vector2F pos, boolean collidable, boolean solid){
        this(frame, shape, pos, collidable);
        this.solid = solid;
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

    public void setCollisionGroup(CollisionGroup cg) {
        this.collisionGroup = cg;
    }
    public CollisionGroup getCollisionGroup(){
        return collisionGroup;
    }
    public boolean pointBelongs(Utils.Vector2F point){
        return (pos.getX() <= point.getX() && pos.getX() + shape.getSize().getX() >= point.getX()
                     &&  pos.getY() <= point.getY() && pos.getY() + shape.getSize().getY() >= point.getY()
        );
    }
    public myShape getShape() {
        return shape;
    }

    public boolean isSolid() {
        return solid;
    }
}
