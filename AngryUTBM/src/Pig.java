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
	    speed = 30;
	    frameSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	    hitBox = new Rectangle(new Point(position.getX(),position.getY()), new Dimension(50, 50));
	}
	public Rectangle getBound() {
		// TODO Auto-generated method stub
		
		return hitBox;
	}
	
}
