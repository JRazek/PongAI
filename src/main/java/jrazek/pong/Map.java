package jrazek.pong;

import jrazek.pong.AI.GodClass;
import jrazek.pong.AI.LearningIndividual;
import jrazek.pong.AI.RewardClass;
import jrazek.pong.Utils.Utils;
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
    private List<LearningIndividual> learningIndividuals = new ArrayList<>();
    private List<Entity> entities = new ArrayList<>();
    private List<Entity> paddles = new ArrayList<>();
    private List<Entity> balls = new ArrayList<>();
    private RewardClass rewardClass = new RewardClass(this);
    private GodClass godClass = new GodClass(this);
    public Map(Utils.Vector2I size, Frame frame){
        super(frame, new myShape(new Rectangle2D.Float(0,0,size.getX() - 1, size.getY() - 1), Color.RED, false), new Utils.Vector2F(0,0), false);
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
        e.getLearningIndividual().onFail();
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
        //dont change!
        int totalInactive = 0;
        for (int i = 0;  i < learningIndividuals.size(); i ++) {
            LearningIndividual li = learningIndividuals.get(i);
            if(li.isActive()) {
                li.step();
            }else totalInactive ++;
        }

        for (int i = 0;  i < entities.size(); i ++) {
            Entity entity = entities.get(i);
            entity.move();
            checkCollisions(entity);
            if(entity instanceof Ball)
                checkIfPassingPaddle(entity);
        }
        if(totalInactive >= learningIndividuals.size())
            godClass.startNewGeneration();
    }
    public void checkIfPassingPaddle(Entity e){
        Utils.Vector2F paddlePos = e.getLearningIndividual().getPaddle().getPos();
        Utils.Vector2F paddleSize = e.getLearningIndividual().getPaddle().getShape().getSize();
        Utils.Vector2F ballPos = e.getPos();
        if(ballPos.getY() >= paddlePos.getY() && ballPos.getY() < paddlePos.getY() + paddleSize.getY())
            rewardClass.test(e.getLearningIndividual());
    }
    public void checkCollisions(Entity entity){
        if(entity.isColliding(this)) {
            if (entity.getPos().getX() <= 0 || entity.getPos().getX() + entity.getShape().getShape().getBounds().getWidth() >= size.getX()) {
                if(entity.isSolid())
                    entity.setVelocity(new Utils.Vector2F(0,0));
                else
                    entity.onCollision(true);
            }
            if (entity.getPos().getY() <= 0) {
                if(entity.isSolid())
                    entity.setVelocity(new Utils.Vector2F(0,0));
                else
                    entity.onCollision(false);
            }
            if(entity.getPos().getY() + entity.getShape().getShape().getBounds().getHeight() >= size.getY()){
                killEntity(entity);
            }
        }
            for(Entity collider : entities){
                if(!entity.equals(collider))
                    if(collider.getCollisionGroup().equals(entity.getCollisionGroup()))
                        if(!entity.isSolid())
                            if(entity.isColliding(collider)) {
                                entity.onCollision(false);
                                if(entity instanceof Ball)
                                    rewardClass.test(entity.getLearningIndividual());
                            }
            }
    }
    public void foreachAllEntityData(){
        for(Entity e : entities){
            System.out.println("------------------------");
            System.out.println(e.getClass().toString());
            System.out.println("x = " + e.getPos().getX());
            System.out.println("y = " + e.getPos().getY());
            System.out.println("Vx = " + e.getVelocity().getX());
            System.out.println("Vy = " + e.getVelocity().getY());
            System.out.println("Sx = " + e.getShape().getSize().getX());
            System.out.println("Sy = " + e.getShape().getSize().getY());
        }
    }
    public void removeEntity(Entity e){
        balls.remove(e);
        paddles.remove(e);
        entities.remove(e);
    }
    public void initNewGeneration(){

    }
    public void addLearningIndividual(LearningIndividual li){
        learningIndividuals.add(li);
    }
    public void removeLearningIndividual(LearningIndividual li){
        learningIndividuals.remove(li);
    }
    public RewardClass getRewardClass() {
        return rewardClass;
    }
    public List<LearningIndividual> getLearningIndividuals() {
        return learningIndividuals;
    }
}
