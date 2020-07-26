package jrazek.pong.Utils;

import jrazek.pong.AI.LearningIndividual;
import jrazek.pong.AI.RewardClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LearningIndividualListChart {
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
    float sum = 0;
    public LearningIndividualListChart(RewardClass rc){
        cells = new ArrayList<>(rc.getResultScore().size());

//        System.out.println("Map size = " + rc.getResultScore().size());
        for (Map.Entry<LearningIndividual, Float> entry : rc.getResultScore().entrySet()) {
            if(entry.getValue() > 0) {
                cells.add(new Cell(entry.getKey(), sum, sum + entry.getValue()));
                System.out.println("start - " + sum + "  end - " + sum + entry.getValue());
                sum += entry.getValue();
                //todo im searching for the value that doesnt exist. Parent may be null
            }
        }
       // System.out.println(cells.size() + " cells created");
    }
    public LearningIndividual getByScore(float score){
        //todo binary search
        //System.out.println("Score were looking with is " + score);
        for(Cell c : cells){
          //  System.out.println(c);
            if(c.startValue <= score && c.endValue > score)
                return c.learningIndividual;
        }
        return null;
    }

    public float getSum() {
        return sum;
    }
}
