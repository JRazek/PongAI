package jrazek.pong.graphics;

import jrazek.pong.Map;

import java.awt.event.MouseEvent;

public class MouseListener implements java.awt.event.MouseListener {
    Frame frame;
    Map map;
    MouseListener(Frame f, Map m){
        this.frame = f;
        this.map = m;
    }
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        //delete this later. it was just for test
      /*  if(mouseEvent.getButton() == 1){
            Main.paddle.accelerate(new Utils.Vector2F(-1,0));
        }
        else if(mouseEvent.getButton() == 3){
            Main.paddle.accelerate(new Utils.Vector2F(1,0));
        }*/
        //System.out.println("MOUSE CLICKED - ");
        //frame.getGraphicsDraw().start();
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        System.out.println("MOUSE CLICKED");

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
