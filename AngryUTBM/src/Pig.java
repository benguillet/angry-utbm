import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Pig extends Enemy {

	private Dimension frameSize;
	private Rectangle hitBox;
	
	
	public Pig() {
	    imagePath = "res/images/pig.png";
    	ImageIcon ii = new ImageIcon(imagePath);
	    image = ii.getImage();
	    position = new Position(100, 500);
	    speed = 1;
	    frameSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	    hitBox = new Rectangle(new Point(position.getX(),position.getY()), new Dimension(50, 50));
	}
	
	public void run() {
		move();
	}

	public void move() {
		boolean back = false;
		
		while(true) {
			if (position.getX() > 800 - image.getWidth(null)) back = true;
			if (position.getX() < 1) back = false;

			
			if (!back)
				position.setX(position.getX() + speed);
			else
		    	position.setX(position.getX() - speed);
			
			 try {
                 Thread.sleep(15);
			 } catch (InterruptedException e) {
                 e.printStackTrace();
			 }
			 
			 hitBox.setBounds(position.getX(),position.getY(),50,50);
		}
		
	}
	
	public Rectangle getBound() {
		// TODO Auto-generated method stub
		
		return hitBox;
	}
	
}
