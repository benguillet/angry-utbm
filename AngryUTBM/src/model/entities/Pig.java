package model.entities;

import main.GameFrame;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.ImageIcon;


public class Pig extends Enemy {

	private Dimension frameSize;
	private boolean back;
	
	public Pig(int x, int y) {
		super(x,y,26,25);
		imagePath = "res/images/pig.png";
		ImageIcon ii = new ImageIcon(imagePath);
		image = ii.getImage();
		imageHeight = ii.getIconHeight();
	    imageWidth = ii.getIconWidth();
		speed = 1;
		back = false;
		frameSize = GameFrame.getFrameSize();
	}

	public void move() {
		if (hitBox.x > frameSize.getWidth() - image.getWidth(null))
			back = true;
		if (hitBox.x < 1)
			back = false;

		if (!back)
			hitBox.x += speed;
		else
			hitBox.x -= speed;
	}
	
	public void changeDirection() {
		back = !back;
	}

	public boolean goForward() {
		return !back;
	}

}
