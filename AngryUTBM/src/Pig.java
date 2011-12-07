import java.util.ArrayList;

import javax.swing.ImageIcon;


public class Pig extends Enemy {

	public Pig() {
	    imagePath = "res/images/pig.png";
    	ImageIcon ii = new ImageIcon(imagePath);
	    image = ii.getImage();
	    position = new Position(100, 500);
	    speed = 30;
	}
	
	
}
