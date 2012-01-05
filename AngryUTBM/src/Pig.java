import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Pig extends Enemy {

	private Dimension frameSize;
	private Rectangle hitBox;
	private boolean back;

	public Pig(JFrame actualFrame) {
		imagePath = "res/images/pig.png";
		ImageIcon ii = new ImageIcon(imagePath);
		image = ii.getImage();
		position = new Point(100, 500);
		speed = 1;
		back = false;
		frameSize = actualFrame.getContentPane().getSize();
		hitBox = new Rectangle(new Point((int) position.getX(),
				(int) position.getY()), new Dimension(50, 50));
	}
	
	public Pig(int X, int Y, JFrame actualFrame) {
		imagePath = "res/images/pig.png";
		ImageIcon ii = new ImageIcon(imagePath);
		image = ii.getImage();
		position = new Point(X, Y);
		speed = 1;
		back = false;
		frameSize = actualFrame.getContentPane().getSize();
		hitBox = new Rectangle(new Point((int) position.getX(),
				(int) position.getY()), new Dimension(50, 50));
	}

	public void move() {
		if (position.getX() > frameSize.getWidth() - image.getWidth(null))
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
