package jrazek.pong;

import jrazek.pong.AI.LearningIndividual;
import jrazek.pong.Utils.Utils;
import jrazek.pong.graphics.Frame;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static Frame frame = new Frame();
    private static Map map = new Map(Rules.mapSize, frame);
    private static List<LearningIndividual> learningIndividualList = new ArrayList<>();
    public static void main(String []str){
        frame.setMap(map);
        frame.getGraphicsDraw().addText(new JLabel("Text todo"));
        map.initRewardClass();
        map.initGodClass();
        frame.getGraphicsDraw().start();
    }
}
