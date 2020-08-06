package jrazek.pong;

import jrazek.pong.AI.LearningIndividual;
import jrazek.pong.Utils.Utils;
import jrazek.pong.graphics.Frame;
import jrazek.pong.graphics.Text;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static Frame frame = new Frame();
    private static Map map = new Map(Rules.mapSize, frame);
    private static List<LearningIndividual> learningIndividualList = new ArrayList<>();
    public static void main(String []str){
        frame.setMap(map);
        map.initRewardClass();
        map.initGodClass();
        frame.getGraphicsDraw().addText(new Text(map, 0));
        frame.getGraphicsDraw().addText(new Text(map, 1));
        frame.getGraphicsDraw().start();
    }
}
