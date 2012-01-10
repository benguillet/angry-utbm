package model.entities;

import javax.swing.ImageIcon;


public class Egg extends Entity {

	public Egg(int x, int y) {
		super(x,y,28,30);
		imagePath = "res/images/egg.png";
    	ImageIcon ii = new ImageIcon(imagePath);
	    image = ii.getImage();
	    imageHeight = ii.getIconHeight();
	    imageWidth = ii.getIconWidth();
		speed = 3;
	}

	public void move() {
		hitBox.y += speed;
	}
}

