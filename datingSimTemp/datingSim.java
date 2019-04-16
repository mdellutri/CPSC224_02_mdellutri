/*********
 final project
 Name: Sam Schoenberg, Mason Dellutri
 *********/
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.Timer;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
//import java.util.concurrent
public class datingSim extends JFrame{

    BufferedImage Background;
    BufferedImage Sprite;
    BufferedImage Textbox;
    BufferedImage laptopHappy;
    BufferedImage laptopGasp;
    BufferedImage laptopSad;
    BufferedImage smartphoneHappy;
    BufferedImage smartphoneGasp;
    BufferedImage smartphoneSad;
    BufferedImage desktopHappy;
    BufferedImage desktopGasp;
    BufferedImage desktopSad;
    String textLine1;
    String textLine2;
    String textLine3;

    datingSim() throws java.io.IOException
    {
        init();
        loadSprites();
        setTitle("datingSim");
        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

    }

    public void loadSprites() throws IOException{
        Background = ImageIO.read(new File("tempBackground.png"));
        Sprite = ImageIO.read(new File("smartphoneHappy.png"));
        Textbox = ImageIO.read(new File("textboxSprite.png"));
        laptopHappy = ImageIO.read(new File("laptopHappy.png"));;
        laptopGasp = ImageIO.read(new File("laptopGasp.png"));;
        laptopSad = ImageIO.read(new File("laptopSad.png"));;
        smartphoneHappy = ImageIO.read(new File("smartphoneHappy.png"));;
        smartphoneGasp = ImageIO.read(new File("smartphoneGasp.png"));;
        smartphoneSad = ImageIO.read(new File("smartphoneSad.png"));;
        desktopHappy = ImageIO.read(new File("desktopHappy.png"));;
        desktopGasp = ImageIO.read(new File("desktopGasp.png"));;
        desktopSad = ImageIO.read(new File("desktopSad.png"));;
        textLine1 = "Here are two options";
        textLine2 = "Click this text for the sprite to become surprised";
        textLine3 = "Click this one instead for it to become sad";
    }
    
    public void init() throws java.io.IOException
    {
        // tempBackground = ImageIO.read(new File("tempBackground.png"));
        // tempSprite = ImageIO.read(new File("tempSprite.png"));
        //  textboxSprite = ImageIO.read(new File("textboxSprite.png"));
        addMouseListener(new MyMouseListener());
        addMouseMotionListener(new MyMouseMotionListener());
    }
    
    public void paint(Graphics g)
    {
        g.drawImage(Background, 0, 0, null);
        g.drawImage(Sprite, 0, 0, null);
        g.drawImage(Textbox, 0, 350, null);
        g.drawString(textLine1, 40, 380);
        g.drawString(textLine2, 40, 400);
        g.drawString(textLine3, 40, 420);
    }
    
    /**
     Mouse listener class
     */
    
    private class MyMouseListener
    implements MouseListener
    {
        public void mousePressed(MouseEvent e)
        {
            if ((e.getY()>390)&&(e.getY()<410)){
                Sprite = smartphoneGasp;
                repaint();
            }
            else if((e.getY()>410)&&(e.getY()<440)){
                Sprite = smartphoneSad;
                repaint();
            }
        }
        
        //
        // The following methods are unused, but still
        // required by the MouseListener interface.
        //
        
        public void mouseClicked(MouseEvent e)
        {

        }
        
        public void mouseReleased(MouseEvent e)
        {

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
        }
    }
    
//    private class TimerListener
//     implements ActionListener
//     {
//     }
    
    public static void main(String[] args) throws java.io.IOException
    {
        try {
        new datingSim();
    }
    catch(IOException e) {
       // Code to handle an IOException here
    }
    }
}	
