package jrazek.pong.AI;

import jrazek.pong.entities.Paddle;

import java.util.List;

public class SelfLearningModule {
    Paddle paddle;
    List<Float> params;
    Float EquationResult;
    int polynomialDegree;
    public SelfLearningModule(int pD){
        this.polynomialDegree = pD;
        init();
    }
    private void init(){
        
    }
}
