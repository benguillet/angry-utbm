import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GameController implements KeyListener, ActionListener {
	private GameView angryView;
	private GameViewMenu angryMenu;
	private GameModel angryModel;
	private GameFrame angryFrame;
	private JLabel difficultyLabel,playernameLabel;
	private JTextField playernameField;
	private JButton newButton,loadButton,optionsButton,exitButton,okButton;
	private JButton easyButton,mediumButton,hardButton,extremeButton;
	private JButton lvl01Button;
	private JButton lvl02Button;
	private Pigeon p;
	
	private ArrayList<Entity> entities;
	
	public GameController() {
		angryModel = new GameModel();
		entities = angryModel.getEntityList();
		
		for (int i = 0; i < entities.size(); ++i) {
			if (entities.get(i) instanceof Pigeon)
				p = (Pigeon) entities.get(i);
		}
		
		angryFrame = new GameFrame(this, entities);
		angryMenu = angryFrame.getAngryViewMenu();
		angryView = angryFrame.getAngryView();
		
		newButton = angryMenu.getNewButton();
		newButton.addActionListener(this);	
		loadButton = angryMenu.getLoadButton();
		loadButton.addActionListener(this);	
		optionsButton = angryMenu.getOptionsButton();
		optionsButton.addActionListener(this);
		exitButton = angryMenu.getExitButton();
		exitButton.addActionListener(this);
		okButton = angryMenu.getOkButton();
		okButton.addActionListener(this);
		
		difficultyLabel = angryMenu.getDifficultyLabel();
		playernameLabel = angryMenu.getPlayerNameLabel();
		playernameField = angryMenu.getPlayerNameField();
		
		easyButton = angryMenu.getEasyButton();
		easyButton.addActionListener(this);
		mediumButton = angryMenu.getMediumButton();
		mediumButton.addActionListener(this);
		hardButton = angryMenu.getHardButton();
		hardButton.addActionListener(this);
		extremeButton = angryMenu.getExtremeButton();
		extremeButton.addActionListener(this);
		
		lvl01Button = angryMenu.getLvl01Button();
		lvl01Button.addActionListener(this);
		lvl02Button = angryMenu.getLvl02Button();
		lvl02Button.addActionListener(this);
	
		angryModel.setDisplay(angryView);
		angryModel.addListListener(angryView);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {		
		switch (e.getKeyCode()) {
		case KeyEvent.VK_RIGHT:
			p.moveRight();
			break;
		case KeyEvent.VK_LEFT:
			p.moveLeft();
			break;
		case KeyEvent.VK_UP:
			p.moveUp();
			break;
		case KeyEvent.VK_DOWN:
			p.moveDown();
			break;
		case KeyEvent.VK_SPACE:
			//p.fire();	
			angryModel.addEgg();
			break;
		case KeyEvent.VK_ESCAPE:
			angryFrame.setMenu();
			break;
		case KeyEvent.VK_R:
			p.reload();
			break;
		default:
			System.out.println("je gère pas cette touche ! Blaireau !");		
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(newButton))
		{
			newButton.setVisible(false);
			loadButton.setVisible(false);
			optionsButton.setVisible(false);
			exitButton.setVisible(false);
			
			playernameField.setVisible(true);
			playernameLabel.setVisible(true);
			okButton.setVisible(true);
			
			
		}
		
		if(e.getSource().equals(okButton))
		{
			playernameField.setVisible(false);
			playernameLabel.setVisible(false);
			okButton.setVisible(false);
			
			difficultyLabel.setVisible(true);
			easyButton.setVisible(true);
			mediumButton.setVisible(true);
			hardButton.setVisible(true);
			extremeButton.setVisible(true);
		}
		
		if (e.getSource().equals(easyButton))
		{
			difficultyLabel.setVisible(false);
			easyButton.setVisible(false);
			mediumButton.setVisible(false);
			hardButton.setVisible(false);
			extremeButton.setVisible(false);
			
			lvl01Button.setVisible(true);
			lvl02Button.setVisible(true);
		}
		
		if (e.getSource().equals(lvl01Button))
		{
			angryView.setMap(new Level("res/maps/lvl01.txt"));
			angryFrame.setGame();
		}
		
		if (e.getSource().equals(lvl02Button))
		{
			angryView.setMap(new Level("res/maps/lvl02.txt"));
			angryFrame.setGame();
		}
		
	}


}


