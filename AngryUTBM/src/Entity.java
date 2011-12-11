import java.awt.Image;
import java.util.ArrayList;

abstract class Entity {
	protected short speed;
	protected Position position;
	protected String imagePath;
	protected Image image;
	protected ArrayList<Egg> eggs;
	protected boolean visible = true;

	public Image getImage() {
        return this.image;
    }
	
	public Position getPosition() {
		return this.position;
	}
	
	public ArrayList<Egg> getEggs() {
		return this.eggs;
	}
	
	abstract public void move();
	
	public boolean isVisible() {
		return this.visible;
	}
}
