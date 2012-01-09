package model.entities;

import java.awt.Point;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class HummingBird extends Bird {	
	public HummingBird() {
		super(45, 44);
	    imagePath = "res/images/hummingBird.png";
    	ImageIcon ii = new ImageIcon(imagePath);
	    image = ii.getImage();
	    speed = 100;
	    imageHeight = ii.getIconHeight();
	    imageWidth = ii.getIconWidth();
	    eggs = new ArrayList<Egg>();
	    reload();
	    frameSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	}
    
    public void moveUp() {
    	//position.setLocation(position.getX() ,position.getY() - speed);
    }
    
    public void moveDown() {
    	//position.setLocation(position.getX(), position.getY() + speed);
    }
    
    public void volStationaire() {
    	isMoving = !isMoving;
    }
    
    public void reload() {
    	eggLeft = 1;
    }
    
    public ArrayList<Egg> getEggs() {
    	return eggs;
    }
    
    
}
