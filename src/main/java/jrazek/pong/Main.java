package jrazek.pong;

import jdk.jshell.execution.Util;
import jrazek.pong.AI.LearningIndividual;
import jrazek.pong.Utils.Utils;
import jrazek.pong.entities.Paddle;
import jrazek.pong.graphics.Frame;

import java.util.ArrayList;
import java.util.List;

import static jrazek.pong.Rules.*;

public class Main {
    private static Frame frame = new Frame();
    private static Map map = new Map(new Utils.Vector2I(1000,1000), frame);
    private static List<LearningIndividual> learningIndividualList = new ArrayList<>();
    public static void main(String []str){
        frame.setMap(map);
        for(int i = 0; i < individualsPerRound; i++){
            map.addLearningIndividual(new LearningIndividual(polynomialDegree, map, indexesDomain));
        }
    }
}
