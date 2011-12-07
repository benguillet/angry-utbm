import java.awt.Image;

abstract class Entity {
	protected short speed;
	protected Position position;
	protected String imagePath;
	protected Image image;
	
	public abstract void moveRight();
	public abstract void moveLeft();
	public abstract Image getImage();
	public abstract Position getPosition();
}
