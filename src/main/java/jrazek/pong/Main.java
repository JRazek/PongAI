package jrazek.pong;

import jdk.jshell.execution.Util;
import jrazek.pong.AI.LearningIndividual;
import jrazek.pong.Utils.Utils;
import jrazek.pong.entities.Paddle;
import jrazek.pong.graphics.Frame;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static Frame frame = new Frame();
    private static Map map = new Map(new Utils.Vector2I(1000,1000), frame);
    private static List<LearningIndividual> learningIndividualList = new ArrayList<>();
    public static void main(String []str){
        frame.setMap(map);
        //System.out.println(Utils.randomDouble(-0.1,0.1));

        for(int i = 0; i < Rules.individualsPerRound; i++){
            map.addLearningIndividual(new LearningIndividual(2, map, new Utils.Domain(-2f, 2f)));
        }
    }
}
