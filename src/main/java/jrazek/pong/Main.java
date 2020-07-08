package jrazek.pong;

import jrazek.pong.entities.Ball;
import jrazek.pong.entities.Paddle;
import jrazek.pong.graphics.Frame;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Paddle> paddles = new ArrayList<>();
    public static Frame frame = new Frame();
    public static Map map = new Map(new Utils.Vector2I(1000,1000), frame);

    public static void main(String []str){
        frame.setMap(map);
        Ball ball = new Ball(60, new Utils.Vector2F(100, 100), map, frame);

        paddles.add(new Paddle(new Utils.Vector2F(200, 20), new Utils.Vector2F(200, 900), map, frame));
        paddles.get(0).setVelocity(new Utils.Vector2F(2,0));

        ball.setVelocity(new Utils.Vector2F(2,1));
        ball.setMap(map);
    }
}
