import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GameFrame extends JFrame {
	private GameView angryView;
	private GameViewMenu angryViewMenu;
	private boolean menuOn;
	
	public GameFrame(GameController controller, ArrayList<Pigeon> pigeons, ArrayList<Pig> pigs) {
		angryViewMenu = new GameViewMenu(controller);
		angryView = new GameView(controller, pigeons, pigs);
		
		// Pour activer ou non le menu, il faut mettre menuOn a true ou false, et interchanger les 2 this.add(...)
		this.add(angryViewMenu);
		this.add(angryView);
		
		menuOn = false;
		
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
	
	public GameViewMenu getAngryViewMenu()
	{
		return angryViewMenu;
	}
	
	public void setMenu()
	{
		setContentPane(angryViewMenu);
		menuOn = true;
		this.setSize(new Dimension(800, 600));
		this.setVisible(true);
	}
	
	public void setGame()
	{
		setContentPane(angryView);
		menuOn = false;
		this.setSize(new Dimension(800, 600));
		this.setVisible(true);
	}
}
