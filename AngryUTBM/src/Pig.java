import java.awt.Dimension;

import javax.swing.ImageIcon;

public class Pig extends Enemy {
	private Dimension frameSize;

	
	public Pig() {
	    imagePath = "res/images/pig.png";
    	ImageIcon ii = new ImageIcon(imagePath);
	    image = ii.getImage();
	    position = new Position(100, 500);
	    speed = 1;
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
			
			// On ralentit le cochon...
			 try {
                 Thread.sleep(15);
			 } catch (InterruptedException e) {
                 e.printStackTrace();
			 }
			
			
		}
	}
}
