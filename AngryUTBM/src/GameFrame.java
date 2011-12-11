import java.util.ArrayList;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GameFrame extends JFrame {
	private GameView angryView;
	private GameViewMenu angryViewMenu;
	private GameController angryController;
	private GameModel angryModel;
	private String winName;
	ArrayList<Entity> angryEntities;
	
	public GameFrame(String name) {
		winName = name;
		angryModel = new GameModel();
		angryViewMenu = new GameViewMenu(angryController);
		angryController = new GameController(this);
		angryView = new GameView(angryController, angryEntities);
		angryView.setVisible(false);
		
		angryView.setVisible(true);
		
		
		
		angryEntities = angryModel.getEntityList();
		angryModel.setDisplay(angryView);
		angryModel.addListListener(angryView);
		
		this.add(angryViewMenu);
		this.add(angryView);
		
		this.setTitle(winName);
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		this.addKeyListener(angryController);
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
	
	public void setMenu()
	{
		this.setContentPane(angryViewMenu);
		this.setVisible(true);
	}
	
	public void setGame()
	{
		this.setContentPane(angryView);
		this.setVisible(true);
	}
}
