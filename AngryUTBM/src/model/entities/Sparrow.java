package model.entities;

import java.awt.Point;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Sparrow extends Bird {
	
	
	public Sparrow() {
		super(30, 29);
	    imagePath = "res/images/sparrow.png";
    	ImageIcon ii = new ImageIcon(imagePath);
	    image = ii.getImage();
	    imageHeight = ii.getIconHeight();
	    imageWidth = ii.getIconWidth();
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
    	
    }
    
    public void reload() {
    	eggLeft = 1;
    }
    
    public ArrayList<Egg> getEggs() {
    	return eggs;
    }
    
    
}
