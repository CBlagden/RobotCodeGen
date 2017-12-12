package org.gui;

import java.applet.Applet;
import java.awt.*;

public class SocketTest extends Applet {

    public SocketTest() {
        this.repaint();
    }

    @Override
    public void paint(Graphics g) {
        g.drawRect(0, 0, 100, 100);
    }
}