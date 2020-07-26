package jrazek.pong.AI;
import jrazek.pong.Map;
import jrazek.pong.Rules;
import jrazek.pong.Utils.LearningIndividualListChart;
import jrazek.pong.Utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class GodClass {
    private RewardClass rewardClass;
    private List<LearningIndividual> newGeneration = new ArrayList<>(Rules.individualsPerRound);
    private LearningIndividualListChart learningIndividualListChart;
    public GodClass(Map m){
        this.rewardClass = m.getRewardClass();
        learningIndividualListChart = new LearningIndividualListChart(rewardClass);
    }
    public void startNewGeneration(){

        while (newGeneration.size() != Rules.individualsPerRound){
            Float rand1 = Utils.randomFloat(0, (float)rewardClass.getResultRewardsSum());
            Float rand2 = Utils.randomFloat(0, (float)rewardClass.getResultRewardsSum());
            LearningIndividual parent1 = learningIndividualListChart.getByScore(rand1);
            LearningIndividual parent2 = learningIndividualListChart.getByScore(rand2);
            LearningIndividual child = new LearningIndividual(parent1, parent2);
            //kolo ruletka do losowania
           // Utils.randomDouble(0, rewardClass.getResultRewardsSum());
        }
        System.out.println("New generation size = " + newGeneration.size());
    }
}
