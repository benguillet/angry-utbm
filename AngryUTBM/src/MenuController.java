import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JList;
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
	private JComboBox playersList;
	
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
		playersList = angryMenu.getPlayersList();
		
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
			playernameField.setVisible(true);
			playernameLabel.setVisible(true);
			okButton.setVisible(true);
		}
		
		if(e.getSource().equals(loadButton))
		{
			newButton.setVisible(false);
			loadButton.setVisible(false);
			optionsButton.setVisible(false);
			exitButton.setVisible(false);
			
			if(angryFrame.getAngryModel().getPlayers()!=null)
			{
				playersList.setVisible(true);
				okButton.setVisible(true);
			}
		}
		
		if(e.getSource().equals(okButton))
		{	
			Player player = new Player(playernameField.getText());
			playernameField.setVisible(false);
			playernameLabel.setVisible(false);
			playersList.setVisible(false);
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
			Level lvl1 = new Level("res/maps/lvl01.txt");
			angryFrame.getAngryView().setMap(lvl1);
			angryFrame.getAngryModel().setMap(lvl1);
			angryFrame.setGame();
		}
		
		if (e.getSource().equals(lvl02Button))
		{
			Level lvl2 = new Level("res/maps/lvl02.txt");
			angryFrame.getAngryView().setMap(lvl2);
			angryFrame.getAngryModel().setMap(lvl2);
			angryFrame.setGame();
		}
	}
}
