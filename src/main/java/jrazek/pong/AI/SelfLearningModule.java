package jrazek.pong.AI;

import jrazek.pong.Map;
import jrazek.pong.Utils;
import jrazek.pong.entities.Ball;
import jrazek.pong.entities.Paddle;

import java.util.ArrayList;
import java.util.List;

public class SelfLearningModule {
    private Paddle paddle;
    private Ball ball;
    private Map map;
    private List<Float> indexes;
    private List<Float> params;
    private Float EquationResult;
    private int polynomialDegree;
    public SelfLearningModule(int pD){
        this.polynomialDegree = pD;
        paddle = new Paddle(new Utils.Vector2F(200, 20), new Utils.Vector2F(200, 900), map, map.getFrame());
        params = new ArrayList<>(14);
        init();
    }
    private void init(){

    }
    private void setParams(){
        params.add(paddle.getPos().getX());
        params.add(paddle.getPos().getY());
        params.add(paddle.getShape().getSize().getX());
        params.add(paddle.getShape().getSize().getY());

        params.add(ball.getPos().getX());
        params.add(ball.getPos().getY());
        params.add(ball.getShape().getSize().getX());
        params.add(ball.getShape().getSize().getY());
        params.add(ball.getVelocity().getX());
        params.add(ball.getVelocity().getY());

        params.add((float)map.getSize().getX());
        params.add((float)map.getSize().getY());
        params.add(map.getPos().getX());
        params.add(map.getPos().getY());
    }
}
