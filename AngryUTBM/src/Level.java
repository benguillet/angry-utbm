import java.awt.Image;
import javax.swing.ImageIcon;

public class Level {
	private String backgroundImagePath = "res/images/background.png";
	private Image image;
	
	public Level() {
	    ImageIcon ii = new ImageIcon(backgroundImagePath);
	    image = ii.getImage();
    }
	
	public Image getImage() {
        return image;
    }
}
