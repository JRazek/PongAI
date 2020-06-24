package jrazek.pong;

import jrazek.pong.templates.Entity;

public class Paddle extends Entity {
    Paddle(){
        super();
    }
    @Override
    public void hitWall(boolean vertical) {
        setVelocity(new Utils.Vector2I(0,0));
    }
}
