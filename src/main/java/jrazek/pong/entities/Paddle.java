package jrazek.pong.entities;
import jrazek.pong.Main;
import jrazek.pong.Map;
import jrazek.pong.Utils.*;
import jrazek.pong.abstracts.Entity;
import jrazek.pong.graphics.myShape;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Paddle extends Entity {
    private Vector2F size;
    private Vector2F pos;
    public Paddle(Vector2F size, Vector2F pos){
        super(pos);
        this.size = size;
        this.pos = pos;
        super.setShape(new myShape(new Rectangle2D.Float(pos.getX(), pos.getY(), size.getX(),size.getY()), Color.BLUE));
    }
    public Paddle(Vector2F size, Vector2F pos, Map map){
        super(pos, map);
        this.size = size;
        this.pos = pos;
        super.setShape(new myShape(new Rectangle2D.Float(pos.getX(), pos.getY(), size.getX(),size.getY()), Color.BLUE));
    }

    @Override
    public void onWallHit(boolean horizontal) {

    }
}
