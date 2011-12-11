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
	
	public GameFrame(String name) {
		winName = name;
		angryModel = new GameModel();
		angryEntities = angryModel.getEntityList();
		
		//Views
		angryViewMenu = new GameViewMenu();
		angryView = new GameView(angryEntities);
		
		
		angryModel.setDisplay(angryView);
		
		//controller 
		angryController = new GameController(this);
		angryMenuController = new MenuController(this);
		
		
		//Listener
		angryView.addKeyListener(angryController);
		angryModel.addListListener(angryView);
		
		
		angryView.setVisible(false);
		angryViewMenu.setVisible(true);
		
		
		this.add(angryView);
		this.add(angryViewMenu);
		
		this.setTitle(winName);
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
		
	}
}
