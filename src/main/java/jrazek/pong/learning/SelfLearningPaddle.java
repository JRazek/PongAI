package jrazek.pong.learning;

import jrazek.pong.Paddle;
import jrazek.pong.Utils;
import jrazek.pong.templates.Entity;

import java.util.ArrayList;
import java.util.List;

public class SelfLearningPaddle {
    private Entity subject;
    private List<Double> indexes = new ArrayList<>();
    private List<Double> vars;
    private int maxPower;
    public SelfLearningPaddle(Paddle sub, List<Double> vars, int maxPower){
        this.subject = sub;
        this.vars = vars;
        for(int i = 0; i < vars.size() * maxPower; i ++){
            indexes.add(Utils.randomDouble());
        }
    }
    public SelfLearningPaddle(SelfLearningPaddle p1, SelfLearningPaddle p2){
        //crossing mechanisms
    }
    public double calculation(){
        double sum = 0;
        int i = 0;
        for(Double var : vars){
            if(i < indexes.size())
                sum += var * indexes.get(i);
            else
                sum += var * indexes.get(Utils.randomInt(0, indexes.size()-1));
            i++;
        }
        //random index from list. Must use all of them!!
        return sum;
    }
}
