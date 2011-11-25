import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GameView extends JFrame {
	private static final long serialVersionUID = 1L;

	public GameView() {
		this.setTitle("AngryUTBM");
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		ImagePanel bgImage = new ImagePanel(new ImageIcon("res/images/background.png").getImage());      
		
		this.getContentPane().add(bgImage);
		this.pack();		
		
		this.setVisible(true);
	}
	
}
