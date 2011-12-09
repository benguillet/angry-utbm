import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Pigeon extends Bird {
	private final int PIGEON_SIZE = 58;
	
	public Pigeon() {
	    imagePath = "res/images/pigeon.png";
    	ImageIcon ii = new ImageIcon(imagePath);
	    image = ii.getImage();
	    position = new Position(40, 60);
	    speed = 20;
	    eggs = new ArrayList<Egg>();
	    eggLeft = 3;
	}

    public void move() {}
	
	public void moveRight() {
        position.setX(position.getX() + speed);
    }
    
    public void moveLeft() {
    	position.setX(position.getX() - speed);
    }
    
    public void moveUp() {
    	position.setY(position.getY() - speed);
    }
    
    public void moveDown() {
    	position.setY(position.getY() + speed);
    }
    
    
    public void fire() {
    	if (eggLeft > 0) {
    		eggs.add(new Egg(position.getX()-PIGEON_SIZE/4, position.getY()+PIGEON_SIZE/3));
    		--eggLeft;
    	}
    	else
    		System.out.println("Plus d'oeufs ! Fail ! Appuie sur R pour recharger !");
    }
    
    public void reload() {
    	eggLeft = 3;
    }
    
    public ArrayList<Egg> getEggs() {
    	return eggs;
    }
}
