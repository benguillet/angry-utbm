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
		angryController = new GameController(this);
		angryView = new GameView(angryController, angryEntities);
		angryView.setVisible(false);
		angryViewMenu = new GameViewMenu(angryController);
		angryView.setVisible(true);
		
		angryEntities = angryModel.getEntityList();
		angryModel.setDisplay(angryView);
		angryModel.addListListener(angryView);
			
		//angryView = new GameView(angryController, angryEntities);//taille : 794 par 572
		
		// Pour activer ou non le menu, il faut mettre menuOn a true ou false, et interchanger les 2 this.add(...)
		
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
		setContentPane(angryViewMenu);
		this.setVisible(true);
	}
	
	public void setGame()
	{
		setContentPane(angryView);
		this.setVisible(true);
	}
}
