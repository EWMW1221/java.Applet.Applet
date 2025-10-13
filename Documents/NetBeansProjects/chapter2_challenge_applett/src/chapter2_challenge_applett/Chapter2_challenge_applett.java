import java.applet.Applett;
import java.awt.Color;
import java.awt.Graphics;

/**
 * Chapter2_Challenge_Applett: Implements the deprecated Java Applet technology 
 * to create a simple bouncing text animation.
 */
public class BouncingTextApplet extends Applet implements Runnable {
    
    private Thread animationThread; // The thread for animation
    private int xCoordinate = 0;   // Current horizontal position
    private int xSpeed = 5;        // Movement speed
    private String displayText = "Chapter 2 Archaeology - [Your Name Here]"; // *** UPDATE THIS ***
    private int textY = 50;        // Vertical position
    
    // Lifecycle Method 1: Initialization
    public void init() {
        setSize(400, 100);
        setBackground(Color.BLUE);
        setForeground(Color.YELLOW);
    }

    // Lifecycle Method 2: Start Thread
    public void start() {
        if (animationThread == null) {
            animationThread = new Thread(this);
            animationThread.start();
        }
    }

    // Runnable Method: Animation Loop
    public void run() {
        while (Thread.currentThread() == animationThread) {
            xCoordinate += xSpeed;
            
            // Bouncing logic: reverse direction if hitting the edge
            if (xCoordinate > (getWidth() - 20) || xCoordinate < 0) {
                xSpeed = -xSpeed; 
            }
            
            repaint(); // Request redraw
            
            try {
                Thread.sleep(100); // Pause for 100ms for smooth animation
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    // Graphics Method: Drawing
    public void paint(Graphics g) {
        g.drawString(displayText, xCoordinate, textY);
    }
    
    // Lifecycle Method 3: Stop Thread
    public void stop() {
        animationThread = null;
    }
}