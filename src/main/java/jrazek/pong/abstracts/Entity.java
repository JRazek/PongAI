package jrazek.pong.abstracts;

import jrazek.pong.Utils;

import java.awt.*;

public abstract class Entity {
    Utils.Vector2I pos;
    Color color;
    public Entity(Utils.Vector2I pos, Color cl){
        this.pos = pos;
        this.color = cl;
    }
    public abstract void draw(Graphics gp);
    public Utils.Vector2I getPos() {
        return pos;
    }

    public Color getColor() {
        return color;
    }
}
