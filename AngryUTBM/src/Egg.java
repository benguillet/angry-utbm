import java.awt.Dimension;
import javax.swing.ImageIcon;


public class Egg extends Entity {
	private boolean visible;
	private Dimension frameSize;
	
	public Egg(int x, int y) {
		imagePath = "res/images/egg.png";
    	ImageIcon ii = new ImageIcon(imagePath);
	    image = ii.getImage();
	    visible = true;
	    position = new Position(x, y);
		speed = 1;
		frameSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	}
	
	public boolean isVisible() {
		return visible;
	}
	
	public void move() {
		position.setY(position.getY() + speed);
		if (position.getY() > (int) frameSize.getHeight())
			visible = false;
	}
}
