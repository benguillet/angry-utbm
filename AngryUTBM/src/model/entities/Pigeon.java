package model.entities;

import java.awt.Point;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Pigeon extends Bird {
	
	
	public Pigeon() {
	    imagePath = "res/images/pigeon.png";
    	ImageIcon ii = new ImageIcon(imagePath);
	    image = ii.getImage();
	    position = new Point(startLocationX, startLocationY);
	    speed = 100;
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
    	eggLeft = 3;
    }
    
    public ArrayList<Egg> getEggs() {
    	return eggs;
    }  
}
