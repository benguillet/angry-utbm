import javax.swing.ImageIcon;
import java.awt.Image;

public class Pigeon extends Bird {
	public Pigeon() {
	    imagePath = "res/images/pigeon.png";
    	ImageIcon ii = new ImageIcon(imagePath);
	    image = ii.getImage();
	    position = new Position(40, 60);
	    speed = 30;
    }

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
	
	public Image getImage() {
        return image;
    }
	
	public Position getPosition() {
		return position;
	}
    
}
