/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
//package chapter2_challenge_applet;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class BouncingTextApplet extends Applet implements Runnable {
    private String message = "Eyerus";
    private int x = 0, y = 100;
    private Thread thread;
    private boolean running = false;

    public void init() {
        setSize(400, 200);
        setBackground(Color.black);
    }

    public void start() {
        if (thread == null) {
            running = true;
            thread = new Thread(this);
            thread.start();
        }
    }

    public void stop() {
        running = false;
        thread = null;
    }

    public void run() {
        while (running) {
            x += 10;
            if (x > getWidth()) x = 0;
            repaint();
            try { Thread.sleep(100); } catch (InterruptedException e) {}
        }
    }

    public void paint(Graphics g) {
        g.setColor(Color.yellow);
        g.drawString(message, x, y);
    }
}