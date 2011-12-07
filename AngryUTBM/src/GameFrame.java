import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GameFrame extends JFrame {
	private GameView angryView;
	
	public GameFrame(GameController controller) {
		angryView = new GameView(controller);
		
		this.add(angryView);
		this.setTitle("AngryUTBM");
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
    }

	public GameView getAngryView() {
		return angryView;
	}
}
