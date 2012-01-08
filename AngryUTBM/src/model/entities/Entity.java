package model.entities;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

public abstract class Entity {
	protected short speed;
	protected String imagePath;
	protected Image image;
	protected ArrayList<Egg> eggs;
	protected boolean visible = true;
	protected Rectangle hitBox;

	public Entity(int x, int y, int width, int height) {
		hitBox = new Rectangle(x, y, width, height);
		
	}
	
	public Point getPosition() {
		return new Point(hitBox.x, hitBox.y);
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
	
	public Rectangle getHitBox() {
		return hitBox;
	}
}
