package model.entities;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;

public abstract class Entity {
	protected short speed;
	protected Point position;
	protected String imagePath;
	protected Image image;
	protected ArrayList<Egg> eggs;
	protected boolean visible = true;

	
	public Point getPosition() {
		return position;
	}
	
	public Image getImage() {
        return this.image;
    }
	
	public ArrayList<Egg> getEggs() {
		return this.eggs;
	}
	
	abstract public void move();
	
	public boolean isVisible() {
		return this.visible;
	}
}
