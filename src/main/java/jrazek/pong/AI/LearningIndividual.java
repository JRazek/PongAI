package jrazek.pong.AI;

import jrazek.pong.Map;
import jrazek.pong.Rules;
import jrazek.pong.Utils.CollisionGroup;
import jrazek.pong.Utils.Utils;
import jrazek.pong.entities.Ball;
import jrazek.pong.entities.Paddle;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class LearningIndividual {
    private Paddle paddle;
    private Ball ball;
    private Map map;
    private Color color;
    private List<Float> indexes;
    private List<Float> params;
    private CollisionGroup collisionGroup;
    private Utils.Domain indexesDomain;
    private Float equationResult;
    private boolean active;
    private final int polynomialDegree;

    public LearningIndividual(int pD, Map m, Utils.Domain dm){
        this.polynomialDegree = pD;
        this.map = m;
        this.indexesDomain = dm;
        this.active = true;
        this.color = new Color((int)(Math.random() * 0x1000000));
        this.paddle = new Paddle(new Utils.Vector2F(200, 10), new Utils.Vector2F(Utils.randomFloat(0,800), 900), map, map.getFrame(), this);
        this.collisionGroup = new CollisionGroup();
        this.paddle.setCollisionGroup(collisionGroup);
        this.paddle.getShape().setColor(color);
        this.ball = new Ball(60, new Utils.Vector2F(Utils.randomFloat(0,800), Utils.randomFloat(0,800)), map, map.getFrame(), this);
        this.ball.setCollisionGroup(collisionGroup);
        this.ball.getShape().setColor(color);
        ball.setVelocity(new Utils.Vector2F(Utils.randomFloat(2,4), -Utils.randomFloat(4,10)));
        this.params = new ArrayList<>();
        this.indexes = new ArrayList<>();
        updateParams();
        initRandomIndexes();
        updatePolynomial();
        setVelocities();
    }
    public LearningIndividual(LearningIndividual p1, LearningIndividual p2){
        this(p1.getPolynomialDegree(), p1.getMap(), p1.getIndexesDomain());
        this.mixIndexes(p1.getIndexes(), p2.getIndexes());
    }

    public void step(){
        updateParams();
        updatePolynomial();
        setVelocities();
    }
    private void initRandomIndexes(){
        for(int i = 0; i < params.size()*polynomialDegree; i++){
            float index = Utils.randomFloat(indexesDomain.getMin(), indexesDomain.getMax());
            indexes.add(index);
        }
    }
    private void updatePolynomial(){
        equationResult = 0f;
       // System.out.println(params);
        int indexNum = 0;
       // System.out.println("============================");
    //    System.out.print("W(x) = ");
        for (int i = 0; i < params.size(); i ++) {
            Float param = params.get(i);
            for (int j = 0; j < polynomialDegree; j++) {
                float add = indexes.get(indexNum) * (float)Math.pow(param, j+1);
                equationResult += (add);
             //   System.out.print(add + " + ");
                indexNum++;
            }
        }
       // System.out.println("============================");
        //System.out.println("equation result = " + equationResult);
    }
    private void setVelocities(){
        if(Rules.maxAllowedSpeed >= equationResult || Rules.maxAllowedSpeed == 0)
            paddle.setVelocity(new Utils.Vector2F(equationResult, 0));
        else
            this.onFail();
    }
    private void setAccelerations(){//dont use!
        if(Rules.maxAllowedSpeed >= paddle.getVelocity().getX() || Rules.maxAllowedSpeed == 0)
            paddle.accelerate(new Utils.Vector2F(equationResult, 0));
        else
            this.onFail();
    }
    private void updateParams(){
        params.clear();
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
    private void mixIndexes(List<Float> i1, List<Float> i2){
        if(i1.size() == i2.size()){
            for(int i = 0; i < i1.size(); i ++){
                indexes.add(Utils.randomBoolean() ? i1.get(i) : i2.get(i));
            }
        }
    }
    public void onFail(){
        paddle.hide();
        ball.hide();
        active = false;
    }
    public Ball getBall(){
        return ball;
    }
    private List<Float> getIndexes(){
        return indexes;
    }
    public int getPolynomialDegree() {
        return polynomialDegree;
    }
    public Utils.Domain getIndexesDomain() {
        return indexesDomain;
    }
    public Paddle getPaddle() {
        return paddle;
    }
    public Map getMap() {
        return map;
    }
    public boolean isActive() {
        return active;
    }
    public void mutate(){
        int index = Utils.randomInt(0, indexes.size());
        indexes.set(index, Utils.randomFloat(Rules.indexesDomain.getMin(), Rules.indexesDomain.getMax()));
    }
}
