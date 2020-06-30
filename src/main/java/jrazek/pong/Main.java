package jrazek.pong;

import jrazek.pong.graphics.Frame;
import jrazek.pong.graphics.myShape;

import java.awt.*;

public class Main {
    public static Paddle paddle = new Paddle(new Utils.Vector2I(100, 100), new Utils.Vector2I(100, 100));
    public static Frame frame = new Frame();

    public static void main(String []str){
        paddle.draw();
    }
}
