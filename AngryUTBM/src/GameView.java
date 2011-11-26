import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class GameView extends JFrame {
	private static final long serialVersionUID = 1L;
	private JLayeredPane pan;
	
	public GameView() {
		this.setTitle("AngryUTBM");
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		pan = new JLayeredPane();
		
		
		ImagePanel bgImage = new ImagePanel(new ImageIcon("res/images/background.png").getImage());      
		ImagePanel pige = new ImagePanel(new ImageIcon("res/images/pigeon.png").getImage());
		//bgImage.setLayout(null);
		//Pigeon pige = new Pigeon();
		//pige.setLayout(1);
		
		pan.add(bgImage, new Integer(0));
		pan.add(pige, new Integer(1));
		
		//this.getContentPane().add(bgImage);
		this.setContentPane(pan);

		//this.pack();		
		
		this.setVisible(true);
	}
	
}
