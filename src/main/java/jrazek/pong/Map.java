package jrazek.pong;

import jrazek.pong.abstracts.Entity;
import jrazek.pong.entities.Ball;
import jrazek.pong.entities.Paddle;
import jrazek.pong.graphics.Frame;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private Utils.Vector2I size;
    private Frame frame;
    private List<Entity> entities = new ArrayList<>();
    private List<Entity> paddles = new ArrayList<>();
    private List<Entity> balls = new ArrayList<>();
    public Map(Utils.Vector2I size, Frame frame){
        this.size = size;
        this.frame = frame;
    }
    public void addBall(Ball ball) {
        this.balls.add(ball);
    }
    public void addPaddles(Paddle paddle) {
        this.paddles.add(paddle);
    }

    public void addEntity(Entity e){
        this.entities.add(e);
    }
    public Frame getFrame() {
        return frame;
    }
    public Utils.Vector2I getSize() {
        return size;
    }
    public void step(){
        for(Entity entity : entities){
            if(entity.getPos().getX() <= 0 || entity.getPos().getX() + entity.getShape().getShape().getBounds().getWidth() >= size.getX()) {
                entity.onWallHit(true);
            }
            if(entity.getPos().getY() <= 0 || entity.getPos().getY() + entity.getShape().getShape().getBounds().getHeight() >= size.getY()) {
                entity.onWallHit(false);
            }
            entity.move();
        }
    }
}
