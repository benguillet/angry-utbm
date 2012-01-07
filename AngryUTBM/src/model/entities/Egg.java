package model.entities;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.ImageIcon;


public class Egg extends Entity {
	private Dimension frameSize;
	private Rectangle hitBox;

	public Egg() {}

	public Egg(int x, int y) {
		imagePath = "res/images/egg.png";
    	ImageIcon ii = new ImageIcon(imagePath);
	    image = ii.getImage();
	    position = new Point(x, y);
		speed = 3;
		frameSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		hitBox = new Rectangle(new Point((int)position.getX()+25,(int)position.getY()+25), new Dimension(30, 30));
	}

	public void move() {
		position.move((int) position.getX(), (int) position.getY() + speed);
		hitBox.setBounds((int) position.getX()+25,(int) position.getY()+25,30,30);
		if (position.getY() > (int) frameSize.getHeight())
			visible = false;
	}

	public Rectangle getBound() {
		return hitBox;
	}
}

