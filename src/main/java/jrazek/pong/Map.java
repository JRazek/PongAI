package jrazek.pong;

import jrazek.pong.abstracts.DrawableObject;
import jrazek.pong.abstracts.Entity;
import jrazek.pong.entities.Ball;
import jrazek.pong.entities.Paddle;
import jrazek.pong.graphics.Frame;
import jrazek.pong.graphics.myShape;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

public class Map extends DrawableObject {
    private Utils.Vector2I size;
    private Frame frame;
    private List<Entity> entities = new ArrayList<>();
    private List<Entity> paddles = new ArrayList<>();
    private List<Entity> balls = new ArrayList<>();
    public Map(Utils.Vector2I size, Frame frame){
        super(frame, new myShape(new Rectangle2D.Float(0,0,size.getX() - 1, size.getY() - 1), Color.RED, false), new Utils.Vector2F(0,0));
        this.size = size;
        this.frame = frame;
        frame.getGraphicsDraw().addDrawable(this);
    }
    public void addBall(Ball ball) {
        addPrivateEntity(ball);
        this.balls.add(ball);
    }
    public void addPaddle(Paddle paddle) {
        addPrivateEntity(paddle);
        this.paddles.add(paddle);
    }
    public void killEntity(Entity e){
        balls.remove(e);
        paddles.remove(e);
        entities.remove(e);
    }

    private void addPrivateEntity(Entity e) {
        this.entities.add(e);
    }

    @Override
    public boolean isColliding(DrawableObject po) {
        return false;
    }

    public Frame getFrame() {
        return frame;
    }
    public Utils.Vector2I getSize() {
        return size;
    }
    public void step() {

        for (Entity entity : entities) {
            if (entity.getPos().getX() <= 0 || entity.getPos().getX() + entity.getShape().getShape().getBounds().getWidth() >= size.getX()) {
                entity.onCollision(true);
            }
            if (entity.getPos().getY() <= 0 || entity.getPos().getY() + entity.getShape().getShape().getBounds().getHeight() >= size.getY()) {
                entity.onCollision(false);
            }
            entity.move();
        }
    }
    boolean isColliding(myShape s1, myShape s2){
        return false;
    }
}
