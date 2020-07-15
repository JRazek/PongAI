package jrazek.pong.Utils;

import jrazek.pong.AI.LearningIndividual;

import java.util.ArrayList;
import java.util.List;

public class LearningIndividualListChart {
    float n;
    private class Cell{
        Cell prevCell;
        Cell nextCell;
        float value;
        LearningIndividual learningIndividual;
        Cell(LearningIndividual li){
            this.learningIndividual = li;
        }
        Cell(LearningIndividual li, Cell prev){
            this.learningIndividual = li;
            this.prevCell = prev;
        }
    }
    List<Cell> cells;
    //todo
    public LearningIndividualListChart(float n, List<LearningIndividual> list){
        this.n = n;
        cells = new ArrayList<>(list.size());
        for(int i = 0; i < list.size(); i ++){
            LearningIndividual li = list.get(i);
            if(cells.size() == 0){
                cells.add(new Cell(li));
            }
            else{
                Cell tmp1 = cells.get(i-1);
                Cell tmp2 = new Cell(li, tmp1);
                cells.add(tmp2);
                tmp1.nextCell = tmp2;
            }
        }
    }
}
