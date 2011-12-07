import java.awt.Image;

abstract class Entity {
	protected int speed;
	protected Position position;
	protected String imagePath;
	protected Image image;

	public Image getImage() {
        return image;
    }
	
	public Position getPosition() {
		return position;
	}
}
