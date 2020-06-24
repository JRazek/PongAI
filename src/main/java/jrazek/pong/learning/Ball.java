package jrazek.pong.learning;

import jrazek.pong.Utils;
import jrazek.pong.templates.Entity;

public class Ball extends Entity {
    @Override
    public void hitWall(boolean vertical) {
        if(vertical){
            super.setVelocity(new Utils.Vector2I(-super.getPos().getX(), super.getPos().getY()));
        }
        else{
            super.setVelocity(new Utils.Vector2I(super.getPos().getX(), -super.getPos().getY()));
        }
    }
}
