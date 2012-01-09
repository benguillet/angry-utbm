package model.entities;

import main.GameFrame;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.ImageIcon;


public class Pig extends Enemy {

	private Dimension frameSize;
	private boolean back;
	private int time;
	
	public Pig(int x, int y, float pigSpeed) {
		super(x,y,26,25);
		imagePath = "res/images/pig.png";
		ImageIcon ii = new ImageIcon(imagePath);
		image = ii.getImage();
		imageHeight = ii.getIconHeight();
	    imageWidth = ii.getIconWidth();
		speed = pigSpeed;
		time = 0;
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
		time++;
	}
	
	public void changeDirection() {
		if(time > 10)
		{
			back = !back;
			time =0;
		}
	}

	public boolean goForward() {
		return !back;
	}

}
