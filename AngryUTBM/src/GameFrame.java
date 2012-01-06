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
		
		
		// methode qui marche
		/*angryView.setVisible(false);
		angryViewMenu.setVisible(true);*/
		
		
		// test
		this.add(angryView);
		this.add(angryViewMenu);
		angryViewMenu.setVisible(true);
		angryView.setVisible(false);
		
		
		// methode qui marche
		/*this.add(angryView);
		this.add(angryViewMenu);*/
		
		// test
		//this.add(angryViewMenu);
		
		this.setTitle(winName);
		this.setSize(GameFrame.getFrameSize().width, GameFrame.getFrameSize().height);
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
	
	// methode qui marche !
	/*public void setMenu()
	{
		//this.setContentPane(angryViewMenu);
		angryView.setVisible(false);
		angryViewMenu.setVisible(true);
		//this.add(angryViewMenu);
	}
	
	public void setGame()
	{
		//this.setContentPane(angryView);
		angryView.setVisible(true);
		angryViewMenu.setVisible(false);
		this.add(angryView);
		
	}*/
	
	// test
	public void setMenu()
	{
		angryViewMenu.setVisible(true);
		angryView.setVisible(false);
		//this.requestFocus();
		//this.add(angryViewMenu);
		
		
	}
	
	public void setGame()
	{
		angryView.setVisible(true);
		angryViewMenu.setVisible(false);
		//this.requestFocus();
		//this.repaint();
		this.add(angryView);
		
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
	
	static public Dimension getFrameSize() {
		Dimension frameSize = new Dimension(1200,600);
		return frameSize;
	}
	
}
