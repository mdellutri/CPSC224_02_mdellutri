/*********
 HW #4
 Due Date: 3/25/2019
 Name: Sam Schoenberg, Mason Dellutri
 *********/
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.Timer;
public class HW4 extends JFrame{
    private int currentX = 250; // Mouse cursor's X position
    private int currentY = 250; // Mouse cursor's Y position
    private int width = 0;    // The rectangle's width
    private int height = 0;   // The rectangle's height
    private int ballWidth = 0;
    private int ballHeight = 0;
    private int delay = 10;
    private int ballX = 0;
    private int ballY = 0;
    
    HW4()
    {
        init();
        setTitle("HW4");
        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }
    
    public void init()
    {
        // Add a mouse listener and a mouse motion listener.
        addMouseListener(new MyMouseListener());
        addMouseMotionListener(new MyMouseMotionListener());
    }
    
    public void paint(Graphics g){
        g.setColor(Color.cyan);
        g.fillRect(0, 0, 500, 500);
        
        g.setColor(Color.blue);
        g.fillRect(0, 250, 500, 500);
        
        g.setColor(Color.orange);
        g.fillOval(100, 100, 50, 50);
        
        g.setColor(Color.red);
        g.fillOval(currentX, currentY, ballWidth, ballHeight);
        
        g.setColor(Color.yellow);
        int scalingX = (250-currentX)/10;
        int scalingY = (250-currentY)/10;
        g.fillRect(0, 350 + (scalingY), 500, 500);
        
        g.setColor(Color.orange);
        g.fillOval(25 +(scalingX*2), 463+(scalingY*2), 150, 25+(scalingY/2));
        
        int xValues[] = {25 + (scalingX*2), 100 + (scalingX*2), 175 + (scalingX*2)};
        int yValues[] = {400 + (scalingY*2), 350 + (scalingY*2), 400 + (scalingY*2)};
        int points = 3;
        g.setColor(Color.white);
        g.fillPolygon(xValues, yValues, points);
        
        g.fillRect(95 + (scalingX*2), 400 +(scalingY*2), 10, 75);
        
        int xValues2[] = {75 + (scalingX*2), 100 + (scalingX*2), 125 + (scalingX*2)};
        int yValues2[] = {400 + (scalingY*2), 350 + (scalingY*2), 400 + (scalingY*2)};
        int points2 = 3;
        g.setColor(Color.red);
        g.fillPolygon(xValues2, yValues2, points2);
        
        int xValues3[] = {200 + (scalingX/4), 225 + (scalingX/4), 375 + (scalingX/4), 400 + (scalingX/4)};
        int yValues3[] = {225 + (scalingY/4), 275 + (scalingY/4), 275 + (scalingY/4), 225 + (scalingY/4)};
        int points3 = 4;
        g.setColor(Color.black);
        g.fillPolygon(xValues3, yValues3, points3);
        g.fillRect(300 + (scalingX/4), 150 +(scalingY/4), 10, 100);
        
        int xValues4[] = {250 + (scalingX/4), 305 + (scalingX/4), 355 + (scalingX/4)};
        int yValues4[] = {200 + (scalingY/4), 145 + (scalingY/4), 200 + (scalingY/4)};
        int points4 = 3;
        g.fillPolygon(xValues4, yValues4, points4);
        
    }
    
    /**
     Mouse listener class
     */
    
    private class MyMouseListener
    implements MouseListener
    {
        public void mousePressed(MouseEvent e)
        {
            ballX = e.getX();
            ballY = e.getY();
            ballWidth = 50;
            ballHeight = 50;
            repaint();
        }
        
        //
        // The following methods are unused, but still
        // required by the MouseListener interface.
        //
        
        public void mouseClicked(MouseEvent e)
        {
        }
        
        public void mouseReleased(MouseEvent e)
        {/*
            protected Timer timer;
            timer = new Timer(delay, this);
            timer.start();
            repaint();
          */
        }
        
        public void mouseEntered(MouseEvent e)
        {
        }
        
        public void mouseExited(MouseEvent e)
        {
        }
    }
    
    /**
     Mouse Motion listener class
     */
    
    private class MyMouseMotionListener
    implements MouseMotionListener
    {
        public void mouseDragged(MouseEvent e)
        {
            // Calculate the size of the rectangle.
            // width = e.getX() - currentX;
            // height = e.getY() - currentY;
            // Get the mouse cursor coordinates.
            // currentX = e.getX();
            // currentY = e.getY();
            // // Repaint the window.
            // repaint();
        }
        
        /**
         The mouseMoved method is unused, but still
         required by the MouseMotionListener interface.
         */
        
        public void mouseMoved(MouseEvent e)
        {
            currentX = e.getX();
            currentY = e.getY();
            // Repaint the window.
            repaint();
        }
    }
    public static void main(String[] args){
        new HW4();
    }	
}
