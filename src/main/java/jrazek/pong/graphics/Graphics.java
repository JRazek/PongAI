package jrazek.pong.graphics;

import javax.swing.*;
import java.awt.*;

public class Graphics {
    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    public Graphics(){
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("26 need more tits");
        frame.pack();
        frame.setVisible(true);
    }
}
