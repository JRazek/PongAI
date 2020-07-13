package jrazek.pong;

import jrazek.pong.AI.LearningIndividual;
import jrazek.pong.entities.Ball;
import jrazek.pong.entities.Paddle;
import jrazek.pong.graphics.Frame;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static Frame frame = new Frame();
    private static Map map = new Map(new Utils.Vector2I(1000,1000), frame);
    public static Paddle paddle;
    public static void main(String []str){
        frame.setMap(map);
       // paddle = new Paddle(new Utils.Vector2F(200, 20), new Utils.Vector2F(200, 900), map, frame);
        Utils.Vector2F rand1 = new Utils.Vector2F(4,0);
        //paddle.setVelocity(rand1);
        LearningIndividual learningIndividual = new LearningIndividual(2, map);
        //Ball ball = new Ball(60, new Utils.Vector2F(100, 100), map, frame);
        Utils.Vector2F rand2 = new Utils.Vector2F((float)Utils.randomDouble(4,10),(float)Utils.randomDouble(4,10));
        //ball.setVelocity(rand2);
    }
}
