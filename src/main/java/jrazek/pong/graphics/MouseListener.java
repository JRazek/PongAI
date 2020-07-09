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
        System.out.println("MOUSE CLICKED");
        frame.getGraphicsDraw().toggleTimer();
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

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
