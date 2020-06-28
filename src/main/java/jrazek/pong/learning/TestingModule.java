package jrazek.pong.learning;

import jrazek.pong.Ball;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestingModule {
    RewardModule rewardModule = new RewardModule();
    List<SelfLearningModule> modules;
    Ball ball;
    TestingModule(List<SelfLearningModule> m, Ball b){
        this.modules = m;
        this.ball = b;
    }
    public void testAll(){

        for(SelfLearningModule sm : modules){
            Map<Float, SelfLearningModule> results = new HashMap<>();
            String[] args = {Integer.toString(sm.getPaddle().getPos().getX()), Integer.toString(ball.getPos().getX())};
            rewardModule.reward(args);
            results.put(rewardModule.reward(args), sm);
            //order ascending and take first elements specified in rules
        }
    }
}
