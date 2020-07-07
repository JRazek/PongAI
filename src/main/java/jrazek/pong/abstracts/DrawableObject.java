package jrazek.pong.abstracts;

import jrazek.pong.Utils;
import jrazek.pong.graphics.myShape;

//abstract object with no specified position
public abstract class DrawableObject<V> {
    private Utils.Vector2F pos;

    //all shapes have rectangular bounding boxes
    private myShape shape;
    public abstract boolean isColliding(DrawableObject po);
    public DrawableObject(myShape shape){
        this.shape = shape;
    }
    public abstract void draw(V v);
}
