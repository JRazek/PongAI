package jrazek.pong.AI;
import jrazek.pong.Map;
import jrazek.pong.Rules;
import jrazek.pong.Utils.LearningIndividualListChart;
import jrazek.pong.Utils.Utils;

import java.util.ArrayList;
import java.util.List;

import static jrazek.pong.Rules.*;

public class GodClass {
    private RewardClass rewardClass;
    private Map map;
    private List<LearningIndividual> newGeneration;
    private List<Float> generationsScores = new ArrayList<>();//average of scores per generation
    private LearningIndividualListChart learningIndividualListChart;
    public GodClass(Map m){
        this.map = m;
        this.reset();
    }
    public void reset(){
        newGeneration = new ArrayList<>(Rules.individualsPerRound);
        this.rewardClass = map.getRewardClass();
    }
    public void createNewGeneration(){
        learningIndividualListChart = new LearningIndividualListChart(rewardClass);
        generationsScores.add(learningIndividualListChart.getTotalScoreOfAll()/learningIndividualListChart.getClassifiedNumber());
        float prevAVG = 0;
        float currAVG = 0;
        boolean checkTime = (generationsScores.size() % checkFrequency == 0);
        if(checkTime) {
            System.out.println("CHECKING HERE");
            if (generationsScores.get(generationsScores.size() - 1) != null)
                currAVG = generationsScores.get(generationsScores.size() - 1);
            if (generationsScores.get(generationsScores.size() - checkFrequency) != null)
                prevAVG = generationsScores.get(generationsScores.size() - checkFrequency);
        }
        if((minDelta != 0 && checkFrequency != 0 && ((currAVG/(currAVG - prevAVG))*100 < minDelta) && checkTime) ||
                generationsScores.size() == 1){
            initRandomGeneration();
            System.out.println("New random generation size = " + newGeneration.size());
        }
        else{
            while (newGeneration.size() != Rules.individualsPerRound){
                if(learningIndividualListChart.getClassifiedNumber() > 1) {
                    float rand1 = Utils.randomFloat(0, (float) rewardClass.getResultRewardsSum());
                    float rand2 = Utils.randomFloat(0, (float) rewardClass.getResultRewardsSum());
                    LearningIndividual parent1 = learningIndividualListChart.getByScore(rand1);
                    LearningIndividual parent2 = learningIndividualListChart.getByScore(rand2);
                    if (parent1 != null && parent2 != null) {
                        if (!parent1.equals(parent2)) {
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
                    } else {
                        System.out.println("ERROR!");
                    }
                } else {
                    System.out.println("NOT ENOUGH! CREATING A RANDOM");
                    newGeneration.add(new LearningIndividual(polynomialDegree, map, indexesDomain));
                }
                //System.out.println(parent1);
                // System.out.println("Our hero float is + " + rewardClass.getResultRewardsSum() + "!!!");
                //kolo ruletka do losowania
                // Utils.randomDouble(0, rewardClass.getResultRewardsSum());
            }
        }
        //if(learningIndividualListChart.getTotalScoreOfAll()/learningIndividualListChart.getClassifiedNumber())
        //have to store previous value


    }
    public Float getSumOfChartList(){
        return learningIndividualListChart.getTotalScoreOfAll();
    }
    public List<LearningIndividual> getNewGeneration(){
        return newGeneration;
    }
    public void initRandomGeneration(){
        for(int i = 0; i < individualsPerRandomRound; i++){
            newGeneration.add(new LearningIndividual(polynomialDegree, map, indexesDomain));
        }
    }
}
