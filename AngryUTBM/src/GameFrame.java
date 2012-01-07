import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GameFrame extends JFrame {
	private GameView angryView;
	private GameViewMenu angryViewMenu;
	private GameController angryController;
	private MenuController angryMenuController;
	private GameModel angryModel;
	private String winName;
	ArrayList<Entity> angryEntities;
	ArrayList<Player> angryPlayers;
	
	public GameFrame(String name) {
		winName = name;
		
		angryModel = new GameModel();
		angryEntities = angryModel.getEntityList();
		angryPlayers = angryModel.getPlayers();
		
		//Views
		angryViewMenu = new GameViewMenu(angryPlayers);
		angryView = new GameView(angryEntities);
		
		angryModel.setAngryView(angryView);
		
		//controller 
		angryController = new GameController(this);
		angryMenuController = new MenuController(this);
		
	
		//Listener
		angryView.addKeyListener(angryController);
		angryModel.addListListener(angryView);
		angryModel.addListListener(angryController);		

		this.setContentPane(angryViewMenu);
		
		this.setTitle(winName);
		this.setSize((int)GameFrame.getFrameSize().getWidth(), (int)GameFrame.getFrameSize().getHeight());
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
	
	public GameModel getAngryModel()
	{
		return angryModel;
	}
	public GameController getController()
	{
		return angryController;
	}

	public void setMenu()
	{

		this.setContentPane(angryViewMenu);
		angryViewMenu.requestFocus();
		this.setVisible(true);
		
	}
	
	public void setGame()
	{
		this.setContentPane(angryView);
		angryView.requestFocus();
		this.setVisible(true);
		
	}
	
	
	
	public void setCurrentPlayer(Player p) {
		angryModel.setCurrentPlayer(p);
	}
	
	public void setDifficulty(String dif) {
		angryModel.setDifficulty(dif);
	}
	
	public void setCurrentLevel(int l) {
		angryModel.setCurrentLevel(l);
	}
	
	public void setCurrentHighScore() {
		angryModel.setCurrentHighScore();
	}
	
	static public Dimension getFrameSize() {
		Dimension frameSize = new Dimension(1200,600);
		return frameSize;
	}
	
}
