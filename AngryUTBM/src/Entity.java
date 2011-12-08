import java.awt.Image;

abstract class Entity extends Thread {
	protected short speed;
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
