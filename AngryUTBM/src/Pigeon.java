import java.awt.Point;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Pigeon extends Bird {
	private final int PIGEON_SIZE = 58;
	
	public Pigeon() {
	    imagePath = "res/images/pigeon.png";
    	ImageIcon ii = new ImageIcon(imagePath);
	    image = ii.getImage();
	    position = new Point(40, 60);
	    speed = 20;
	    eggs = new ArrayList<Egg>();
	    eggLeft = 3;
	}

    public void move() {}
	
	public void moveRight() {
        position.setLocation(position.getX() + speed, position.getY());
    }
    
    public void moveLeft() {
    	position.setLocation(position.getX() - speed, position.getY());
    }
    
    public void moveUp() {
    	position.setLocation(position.getX() ,position.getY() - speed);
    }
    
    public void moveDown() {
    	position.setLocation(position.getX(), position.getY() + speed);
    }
    
    public void reload() {
    	eggLeft = 3;
    }
    
    public ArrayList<Egg> getEggs() {
    	return eggs;
    }
    
    
}
