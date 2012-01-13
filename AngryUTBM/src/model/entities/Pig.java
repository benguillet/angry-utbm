package model.entities;

import main.GameFrame;

import java.awt.Dimension;
import javax.swing.ImageIcon;


public class Pig extends Enemy {

	private Dimension frameSize;
	private int timeSpeed;
	private int pigSpeed;

	
	public Pig(int x, int y, int pigSpeed) {
		super(x,y,26,26);
		imagePath = "res/images/pig.png";
		ImageIcon ii = new ImageIcon(imagePath);
		image = ii.getImage();
		imageHeight = ii.getIconHeight();
	    imageWidth = ii.getIconWidth();
		speed = 3;
		timeDirection = 0;
		timeDown = 0; 
		timeSpeed = pigSpeed;
		this.pigSpeed = pigSpeed;
		back = false;
		frameSize = GameFrame.getFrameSize();
	}

	public void move() {
		if (hitBox.x > frameSize.getWidth() - image.getWidth(null))
			back = true;
		if (hitBox.x < 250)
			back = false;

		if(timeSpeed == 0)
		{
		if (!back)
			hitBox.x += speed;
		else
			hitBox.x -= speed;
		timeSpeed = pigSpeed;
		}
		if(down)
			hitBox.y+=(int) (speed+3);
		timeDirection++;
		timeDown++;
		timeSpeed--;
	}
	public void moveDown(){
		if(timeDown > 10)
		{
			down=true;
			timeDown=0;
		}
		
	}
	
	public void changeDirection() {
		if(timeDirection > 10)
		{
			back = !back;
			timeDirection =0;
		}
	}

	public boolean goForward() {
		return !back;
	}

	public void doNotMoveDown(){
		down=false;
	}

}
