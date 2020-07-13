package jrazek.pong.AI;

import jrazek.pong.Map;
import jrazek.pong.Rules;
import jrazek.pong.Utils;
import jrazek.pong.entities.Ball;
import jrazek.pong.entities.Paddle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LearningIndividual {
    private Paddle paddle;
    private Ball ball;
    private Map map;
    private List<Float> indexes;
    private List<Float> params;
    private Float equationResult;
    private final int polynomialDegree;

    /*LearningIndividual(LearningIndividual parent1, LearningIndividual parent2){
        this()
    //todo
    }*/
    public LearningIndividual(int pD, Map m){
        this.polynomialDegree = pD;
        this.map = m;
        this.paddle = new Paddle(new Utils.Vector2F(200, 20), new Utils.Vector2F(200, 900), map, map.getFrame());
        this.ball = new Ball(60, new Utils.Vector2F(100, 100), map, map.getFrame());
        this.params = new ArrayList<>();
        this.indexes = new ArrayList<>();
        setParams();
        initRandomIndexes();
        updatePolynomial();
        setVelocities();
    }
    private void initRandomIndexes(){
        for(int i = 0; i < params.size()*polynomialDegree; i++){
            float index = (float)Utils.randomDouble();
            if(Utils.randomBoolean())
                index *=-1;
            indexes.add(index);
        }
    }
    private void updatePolynomial(){
        equationResult = 0f;
        int indexNum = 0;
        System.out.println(params);
        for (Float param : params) {
            for (int j = 0; j < polynomialDegree; j++) {

                /*System.out.println("----------------------------");
                System.out.println("size - " + params.size());
                System.out.println("i - " + i);
                System.out.println("j - " + j);*/
                equationResult += (float) (indexes.get(indexNum) *
                        Math.pow(param, j + 1));
                indexNum++;
            }
        }
    }
    private void setVelocities(){
        if(Rules.maxAllowedSpeed >= equationResult)
            paddle.setVelocity(new Utils.Vector2F(equationResult, 0));
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
    private void mixIndexes(List<Float> i1, List<Float> i2){
        if(i1.size() == i2.size()){
            for(int i = 0; i < i1.size(); i ++){
                indexes.add(Utils.randomBoolean() ? i1.get(i) : i2.get(i));
            }
        }
    }
    public void onFail(){

    }
}
