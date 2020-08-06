package jrazek.pong.graphics;

import jrazek.pong.Map;

import javax.swing.*;

public class Text {
    private Map map;
    private JLabel label = new JLabel("test");
    private int type;
    public Text(Map m, int t){
        this.map = m;
        this.type = t;
    }
    public void update(){
        switch(type){
            case 0: label.setText("generation num - " + map.getGenerationNumber() + " | ");break;
            case 1: label.setText("ok in the row num - " + map.getGodClass().getOkInTheRow());break;
        }


    }
    public JLabel getLabel(){
        return label;
    }
}
