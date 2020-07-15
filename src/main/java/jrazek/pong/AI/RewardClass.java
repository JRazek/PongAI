package jrazek.pong.AI;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.abs;

public class RewardClass {
    private double resultRewardsSum = 0;
    private Map<LearningIndividual, Float> totalScores = new HashMap<>();
    private Map<LearningIndividual, Integer> timesMeasured = new HashMap<>();
    private Map<LearningIndividual, Float> resultScore = new HashMap<>();
    public RewardClass(jrazek.pong.Map m){
        for(LearningIndividual li : m.getLearningIndividuals()){
            totalScores.put(li, 0f);
            timesMeasured.put(li, 0);
            resultScore.put(li, 0f);
        }
    }
    public void test(LearningIndividual li){
        float score = abs(1/(li.getBall().getPos().getX() - li.getPaddle().getPos().getX()));
        float total = 0;
        if(totalScores.get(li) != null)
            total = totalScores.get(li);

        Integer timesMeasuredInt = 0;
        if(timesMeasured.get(li) != null)
            timesMeasuredInt = timesMeasured.get(li);

        float resultScoreFloat = 0;
        if(resultScore.get(li) != null)
            resultScoreFloat = totalScores.get(li)/timesMeasured.get(li);

        resultRewardsSum += resultScoreFloat;

        totalScores.put(li, total + score);
        timesMeasured.put(li, timesMeasuredInt + 1);
        resultScore.put(li, resultScoreFloat);
        System.out.println("Now");
    }

    public double getResultRewardsSum() {
        return resultRewardsSum;
    }
    public Map<LearningIndividual, Float> getResultScore() {
        return resultScore;
    }
}
