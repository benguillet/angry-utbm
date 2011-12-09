import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.ImageIcon;


public class Egg extends Entity {
	private boolean visible;
	private Dimension frameSize;
	private Rectangle hitBox;
	
	public Egg(int x, int y) {
		imagePath = "res/images/egg.png";
    	ImageIcon ii = new ImageIcon(imagePath);
	    image = ii.getImage();
	    visible = true;
	    position = new Position(x, y);
		speed = 1;
		frameSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		hitBox = new Rectangle(new Point(position.getX(),position.getY()), new Dimension(50, 50));
	}
	
	public boolean isVisible() {
		return visible;
	}
	
	public void move() {
		position.setY(position.getY() + speed);
		hitBox.setBounds(position.getX(),position.getY(),50,50);
		if (position.getY() > (int) frameSize.getHeight())
			visible = false;
	}

	public Rectangle getBound() {
		return hitBox;
	}
	
	
}
