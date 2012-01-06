import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class MenuController implements ActionListener {

	private JLabel difficultyLabel,playerNameLabel;
	private JTextField playerNameField;
	private JButton newButton,loadButton,optionsButton,exitButton,okButton;
	private JButton easyButton,mediumButton,hardButton,extremeButton;
	private ArrayList<JButton> lvlButtons;
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
		playerNameLabel = angryMenu.getPlayerNameLabel();
		playerNameField = angryMenu.getPlayerNameField();
		playersList = angryMenu.getPlayersList();
		
		easyButton = angryMenu.getEasyButton();
		easyButton.addActionListener(this);
		mediumButton = angryMenu.getMediumButton();
		mediumButton.addActionListener(this);
		hardButton = angryMenu.getHardButton();
		hardButton.addActionListener(this);
		extremeButton = angryMenu.getExtremeButton();
		extremeButton.addActionListener(this);
		
		lvlButtons = angryMenu.getLvlButtons();
		for (JButton button : lvlButtons) {
			button.addActionListener(this);
		}
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
			playerNameField.setVisible(true);
			playerNameLabel.setVisible(true);
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
			Player player;
			
			if (playerNameField.isVisible()) {
				if (playerNameField.getText().equals(""))
					javax.swing.JOptionPane.showMessageDialog(null, "Il faut mettre ton pseudo");
				else {
					player = new Player(playerNameField.getText());
					playerNameField.setVisible(false);
					angryFrame.setCurrentPlayer(player);
					playerNameLabel.setVisible(false);
					okButton.setVisible(false);
					difficultyLabel.setVisible(true);
					easyButton.setVisible(true);
					mediumButton.setVisible(true);
					hardButton.setVisible(true);
					extremeButton.setVisible(true);
				}
			}
			else {
				player = (Player) playersList.getSelectedItem();
				playersList.setVisible(false);
				angryFrame.setCurrentPlayer(player);
				playerNameLabel.setVisible(false);
				okButton.setVisible(false);
				difficultyLabel.setVisible(true);
				easyButton.setVisible(true);
				mediumButton.setVisible(true);
				hardButton.setVisible(true);
				extremeButton.setVisible(true);
			}
		}
		
		if (e.getSource().equals(easyButton))
		{
			angryFrame.setDifficulty("easy");
			
		}
		
		if (e.getSource().equals(mediumButton))
		{
			angryFrame.setDifficulty("medium");
			
		}
			
		if (e.getSource().equals(hardButton))
		{
			angryFrame.setDifficulty("hard");
			
		}
		
		if (e.getSource().equals(extremeButton))
		{
			angryFrame.setDifficulty("extreme");	
		}
		
		if (e.getSource().equals(easyButton) || e.getSource().equals(mediumButton) || e.getSource().equals(hardButton) || e.getSource().equals(extremeButton) ) {
			difficultyLabel.setVisible(false);
			for (JButton button : lvlButtons) {
				button.setVisible(true);
			}
			easyButton.setVisible(false);
			mediumButton.setVisible(false);
			hardButton.setVisible(false);
			extremeButton.setVisible(false);
		}
		
		for (int i = 0; i < lvlButtons.size(); ++i) {
			if(e.getSource().equals(lvlButtons.get(i))) {
				Level lvl = new Level("res/maps/lvl0" + (i+1) + ".txt", angryFrame);
				angryFrame.getAngryView().setMap(lvl);
				angryFrame.getAngryModel().setMap(lvl);
				angryFrame.setGame();
				angryFrame.setCurrentLevel(i+1);
			}
		}
		
		if (e.getSource().equals(exitButton))
		{
			System.exit(0);
		}
	}
}
