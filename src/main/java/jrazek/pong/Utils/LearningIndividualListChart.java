package jrazek.pong.Utils;

import jrazek.pong.AI.LearningIndividual;
import jrazek.pong.AI.RewardClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LearningIndividualListChart {
    private float totalSum;//total
    private RewardClass rc;
    private class Cell{
        private float startValue;
        private float endValue;
        private LearningIndividual learningIndividual;
        Cell(LearningIndividual li, Float startValue, Float endValue){
            this.learningIndividual = li;
            this.startValue = startValue;
            this.endValue = endValue;
        }
    }
    private List<Cell> cells;
    public LearningIndividualListChart(RewardClass rc){
        this.totalSum = (float)rc.getResultRewardsSum();
        cells = new ArrayList<>(rc.getResultScore().size());
        float sum = 0;

        System.out.println("Map size = " + rc.getResultScore().size());
        for (Map.Entry<LearningIndividual, Float> entry : rc.getResultScore().entrySet()) {
            if(entry.getValue() > 0) {
                cells.add(new Cell(entry.getKey(), sum, sum + entry.getValue()));
                System.out.println("start - " + sum + "  end - " + sum + entry.getValue());
                sum += entry.getValue();
            }
        }
       // System.out.println(cells.size() + " cells created");
    }
    public LearningIndividual getByScore(float score){
        //todo binary search
        System.out.println("Score were looking with is " + score);
        for(Cell c : cells){
          //  System.out.println(c);
            if(c.startValue <= score && c.endValue > score)
                return c.learningIndividual;
        }
        return null;
    }
}
