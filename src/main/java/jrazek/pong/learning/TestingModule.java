package jrazek.pong.learning;

import jrazek.pong.Paddle;

import java.util.List;

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
            String[] args = {Integer.toString(sm.getPaddle().getPos().getX()), Integer.toString(ball.getPos().getX())};
            rewardModule.reward(args);
        }
    }
}
