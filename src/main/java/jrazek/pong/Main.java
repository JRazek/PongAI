package jrazek.pong;

import jrazek.pong.graphics.Frame;
import jrazek.pong.graphics.Graphics;

public class Main {
    static Graphics graphics = new Graphics();
    static Paddle paddle = new Paddle(new Utils.Vector2I(100, 20), new Utils.Vector2I(100, 100));

    public static void main(String []str){
        Frame f = new Frame();
        Graphics g = new Graphics();
        f.paint(g.getGraphics());
    }
}
