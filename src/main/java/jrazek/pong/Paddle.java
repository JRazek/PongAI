package jrazek.pong;

import jrazek.pong.templates.Entity;

public class Paddle extends Entity {
    Paddle(){
        super();

    }
    @Override
    public void hitWall() {
        setVelocity(0);
    }
}
