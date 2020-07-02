package jrazek.pong;

import jrazek.pong.entities.Ball;
import jrazek.pong.entities.Paddle;
import jrazek.pong.graphics.Frame;

public class Main {
    public static Paddle paddle = new Paddle(new Utils.Vector2F(200, 20), new Utils.Vector2F(200, 900));
    public static Ball ball = new Ball(60, new Utils.Vector2F(100, 100));
    public static Frame frame = new Frame();
    public static Map map = new Map(new Utils.Vector2I(1000,1000), frame);

    public static void main(String []str){
        frame.setMap(map);
        paddle.setMap(map);
        ball.setMap(map);
        paddle.addToDrawList();
        ball.addToDrawList();
        ball.setVelocity(new Utils.Vector2F(100,10));
    }
}
