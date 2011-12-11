import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class MenuController implements ActionListener {

	private JLabel difficultyLabel,playernameLabel;
	private JTextField playernameField;
	private JButton newButton,loadButton,optionsButton,exitButton,okButton;
	private JButton easyButton,mediumButton,hardButton,extremeButton;
	private JButton lvl01Button;
	private JButton lvl02Button;
	
	private GameViewMenu angryMenu;
	private GameFrame angryFrame;
	
	public MenuController(GameFrame frame){
		
		angryFrame = frame;
		angryMenu = frame.getAngryViewMenu();
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
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource().equals(newButton))
		{
			newButton.setVisible(false);
			loadButton.setVisible(false);
			optionsButton.setVisible(false);
			exitButton.setVisible(false);
		}
			
		if (e.getSource().equals(angryMenu.getNewButton())) 
		{
			newButton.setVisible(false);
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
			lvl01Button.setVisible(true);
			lvl02Button.setVisible(true);
			easyButton.setVisible(false);
			mediumButton.setVisible(false);
			hardButton.setVisible(false);
			extremeButton.setVisible(false);
			
		}
			
		if (e.getSource().equals(lvl01Button))
		{
			GameView angryView = angryFrame.getAngryView();
			angryView.setMap(new Level("res/maps/lvl01.txt"));
			angryFrame.setGame();
		}
		
		if (e.getSource().equals(lvl02Button))
		{
			//angryFrame.getAngryView().setMap(new Level("res/maps/lvl02.txt"));
			//angryFrame.setGame();
		}
	}
}
