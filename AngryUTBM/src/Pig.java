import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Pig extends Enemy {

	private Dimension frameSize;
	private Rectangle hitBox;
	private boolean back;

	public Pig() {
		imagePath = "res/images/pig.png";
		ImageIcon ii = new ImageIcon(imagePath);
		image = ii.getImage();
		position = new Point(100, 500);
		speed = 1;
		back = false;
		frameSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		hitBox = new Rectangle(new Point((int) position.getX(),
				(int) position.getY()), new Dimension(50, 50));
	}
	
	public Pig(int X, int Y) {
		imagePath = "res/images/pig.png";
		ImageIcon ii = new ImageIcon(imagePath);
		image = ii.getImage();
		position = new Point(X, Y);
		speed = 1;
		back = false;
		frameSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		hitBox = new Rectangle(new Point((int) position.getX(),
				(int) position.getY()), new Dimension(50, 50));
	}

	public void move() {

		if (position.getX() > 800 - image.getWidth(null))
			back = true;
		if (position.getX() < 1)
			back = false;

		if (!back)
			position.setLocation(position.getX() + speed, position.getY());
		else
			position.setLocation(position.getX() - speed, position.getY());

		hitBox.setBounds((int) position.getX(), (int) position.getY(), 50, 50);

	}

	public Rectangle getBound() {
		return hitBox;
	}

}
