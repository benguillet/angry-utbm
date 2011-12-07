import javax.swing.JFrame;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class AngryFrame extends JFrame {
	private AngryView angryView;
	
	public AngryFrame(AngryController controller) {
		angryView = new AngryView(controller);
		
		this.add(angryView);
		this.setTitle("AngryUTBM");
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
    }

	public AngryView getAngryView() {
		return angryView;
	}
}
