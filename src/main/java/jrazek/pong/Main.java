package jrazek.pong;

import jrazek.pong.entities.Ball;
import jrazek.pong.entities.Paddle;
import jrazek.pong.graphics.Frame;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static Frame frame = new Frame();
    private static Map map = new Map(new Utils.Vector2I(1000,1000), frame);

    public static void main(String []str){
        frame.setMap(map);

        Paddle paddle = new Paddle(new Utils.Vector2F(200, 20), new Utils.Vector2F(200, 900), map, frame);
        Utils.Vector2F rand1 = new Utils.Vector2F(0.5f,0);
        paddle.setVelocity(rand1);

        Ball ball = new Ball(60, new Utils.Vector2F(100, 100), map, frame);
        Utils.Vector2F rand2 = new Utils.Vector2F(0.2f,1);
        ball.setVelocity(rand2);
    }
}
