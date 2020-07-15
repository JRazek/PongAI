package jrazek.pong.AI;
import jrazek.pong.Map;
import jrazek.pong.Rules;
import jrazek.pong.Utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class GodClass {
    private RewardClass rewardClass;
    private List<LearningIndividual> newGeneration = new ArrayList<>(Rules.individualsPerRound);
    public GodClass(Map m){
        this.rewardClass = m.getRewardClass();
    }
    public void startNewGeneration(){
        while (newGeneration.size() != Rules.individualsPerRound){
            //kolo ruletka do losowania
           // Utils.randomDouble(0, rewardClass.getResultRewardsSum());
        }
        System.out.println("New generation size = " + newGeneration.size());
    }
}
