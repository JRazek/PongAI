package jrazek.pong.AI;
import jrazek.pong.Map;
import jrazek.pong.Rules;
import jrazek.pong.Utils.LearningIndividualListChart;
import jrazek.pong.Utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class GodClass {
    private RewardClass rewardClass;
    private Map map;
    private List<LearningIndividual> newGeneration = new ArrayList<>(Rules.individualsPerRound);
    private LearningIndividualListChart learningIndividualListChart;
    public GodClass(Map m){
        this.rewardClass = m.getRewardClass();
        this.map = m;
    }
    public void createNewGeneration(){
        learningIndividualListChart = new LearningIndividualListChart(rewardClass);
        while (newGeneration.size() != Rules.individualsPerRound){
           // System.out.println("Guessed max is... " + rewardClass.getResultRewardsSum());
            float rand1 = Utils.randomFloat(0, (float)rewardClass.getResultRewardsSum());
            float rand2 = Utils.randomFloat(0, (float)rewardClass.getResultRewardsSum());
            LearningIndividual parent1 = learningIndividualListChart.getByScore(rand1);
            LearningIndividual parent2 = learningIndividualListChart.getByScore(rand2);
            if(parent1 != null && parent2 != null && !parent1.equals(parent2)) {
                LearningIndividual child = new LearningIndividual(parent1, parent2);
                System.out.println("And the parents are ..." + parent1 + " and " + parent2);
                System.out.println("We are trying to access them with ..." + rand1 + " and " + rand2);
                System.out.println("And the parents scores are ..." + rewardClass.getResultScore().get(parent1) + " and " + rewardClass.getResultScore().get(parent2));
                if (Utils.randomFloat(0, 9999) < Rules.mutationRate * 1000) {
                    child.mutate();
                    System.out.println("Mutation");
                }
                newGeneration.add(child);
            }
            else{
                System.out.println("ERROR!");
            }
            //System.out.println(parent1);
           // System.out.println("Our hero float is + " + rewardClass.getResultRewardsSum() + "!!!");
            //kolo ruletka do losowania
           // Utils.randomDouble(0, rewardClass.getResultRewardsSum());
        }
        System.out.println("New generation size = " + newGeneration.size());

    }
    public Float getSumOfChartList(){
        return learningIndividualListChart.getSum();
    }
    public List<LearningIndividual> getNewGeneration(){
        return newGeneration;
    }
}
