package model.entities;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.ImageIcon;


public class Egg extends Entity {
	private Dimension frameSize;

	public Egg(int x, int y) {
		super(x,y,28,30);
		imagePath = "res/images/egg.png";
    	ImageIcon ii = new ImageIcon(imagePath);
	    image = ii.getImage();
		speed = 3;
		frameSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	}

	public void move() {
		hitBox.y += speed;
		if (hitBox.y > (int) frameSize.getHeight())
			visible = false;
	}
}

