import javax.swing.JPanel;
import java.awt.Graphics;

public class Pigeon extends JPanel implements Bird {
	
	private static final long serialVersionUID = 1586470091931386882L;

		
	public void paintComponent(Graphics g) {
     	g.fillOval(20, 20, 75, 75);
	}
	
	
	public void move() {
		
	}
}
