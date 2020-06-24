package jrazek.pong.learning;

import jrazek.pong.Main;
import jrazek.pong.Paddle;
import jrazek.pong.Utils;
import jrazek.pong.templates.Entity;

import java.util.ArrayList;
import java.util.List;

public class SelfLearningModule {
    private Paddle paddle;
    private List<Double> indexes = new ArrayList<>();
    private List<Double> vars;
    private int maxPower;
    public SelfLearningModule(Paddle sub, List<Double> vars, int maxPower){
        this.paddle = sub;
        this.vars = vars;
        this.maxPower = maxPower;
        for(int i = 0; i < vars.size() * maxPower; i ++){
            indexes.add(Utils.randomDouble());
        }
    }
    public SelfLearningModule(SelfLearningModule p1, SelfLearningModule p2){
        //crossing mechanisms
    }
    public void moveEquation(){
        double sum = 0;
        int i = 0;
        for(Double var : vars){
            if(i < indexes.size())
                sum += var * indexes.get(i);
            else
                sum += var * indexes.get(Utils.randomInt(0, indexes.size()-1));
            i++;//

        }
        //random index from list. Must use all of them!!
        paddle.setVelocity(new Utils.Vector2I((int)sum, 0));
    }
    void kill(){
        Main.map.getEntities().remove(paddle);
        paddle = null;
    }
    public Paddle getPaddle() {
        return paddle;
    }
}
