package jrazek.pong.AI;

import jrazek.pong.Utils.LearningIndividualListChart;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.abs;

public class RewardClass {
    private Map<LearningIndividual, Float> totalScores = new HashMap<>();
    private Map<LearningIndividual, Integer> timesMeasured = new HashMap<>();
    private Map<LearningIndividual, Float> resultScore = new HashMap<>();
    private jrazek.pong.Map map;
    public RewardClass(jrazek.pong.Map m){
        this.map = m;
        //System.out.println("Learning individuals size = " + m.getLearningIndividuals().size());
        for(LearningIndividual li : m.getLearningIndividuals()){
            totalScores.put(li, 0f);
            timesMeasured.put(li, 0);
            resultScore.put(li, 0f);
        }
        System.out.println("Creating reward class...");
    }
    public void test(LearningIndividual li){
        if(totalScores.get(li) == null)
            System.out.println("KURwa");
        //System.out.println("testing...");
        float score = abs(1/(li.getBall().getPos().getX() - li.getPaddle().getPos().getX()));

        float total = totalScores.get(li);

        int timesMeasuredInt = timesMeasured.get(li);

        float resultScoreFloat = totalScores.get(li)/timesMeasured.get(li);

        totalScores.put(li, total + score);
        timesMeasured.put(li, timesMeasuredInt + 1);
        resultScore.put(li, resultScoreFloat);
        //System.out.println("resultScoreFloat - " + resultScore.get(li));
    }

    public double getResultRewardsSum() {
        double sum = 0;
        for (Map.Entry<LearningIndividual, Float> entry : resultScore.entrySet()) {
            sum += entry.getValue();
           // System.out.println(sum);
        }
        return sum;
    }
    public Map<LearningIndividual, Float> getResultScore() {
        return resultScore;
    }
}
