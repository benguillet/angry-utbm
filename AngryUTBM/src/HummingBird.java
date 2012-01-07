import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class HummingBird extends Bird {
	private final int PIGEON_SIZE = 58;
	
	
	public HummingBird() {
	    imagePath = "res/images/hummingBird.png";
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
    	eggLeft = 1;
    }
    
    public ArrayList<Egg> getEggs() {
    	return eggs;
    }
    
    
}
