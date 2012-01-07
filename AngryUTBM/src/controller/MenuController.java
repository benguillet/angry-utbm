package controller;

import main.GameFrame;
import model.Level;
import model.Player;
import view.GameViewMenu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MenuController implements KeyListener, ActionListener {

	private JLabel difficultyLabel,playerNameLabel;
	private JTextField playerNameField;
	private JButton newButton,loadButton,optionsButton,exitButton,okButton;
	private JButton easyButton,mediumButton,hardButton,extremeButton;
	private ArrayList<JButton> lvlButtons;
	private Player currentPlayer;
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
			
			if (playerNameField.isVisible()) {
				if (playerNameField.getText().equals(""))
					javax.swing.JOptionPane.showMessageDialog(null, "Il faut mettre ton pseudo");
				else {
					currentPlayer = new Player(playerNameField.getText());
					playerNameField.setVisible(false);
					angryFrame.setCurrentPlayer(currentPlayer);
					angryFrame.setDifficulty("");
					angryFrame.setCurrentLevel(0);
					angryFrame.setCurrentHighScore();
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
				currentPlayer = (Player) playersList.getSelectedItem();
				playersList.setVisible(false);
				angryFrame.setCurrentPlayer(currentPlayer);
				angryFrame.setDifficulty("");
				angryFrame.setCurrentLevel(0);
				angryFrame.setCurrentHighScore();
				playerNameLabel.setVisible(false);
				okButton.setVisible(false);
				difficultyLabel.setVisible(true);
				easyButton.setVisible(true);
				mediumButton.setVisible(true);
				hardButton.setVisible(true);
				extremeButton.setVisible(true);
				
			}
		}
		
		String difficulty = "";
		
		if (e.getSource().equals(easyButton))
		{
			difficulty = "easy";
			
		}
		
		if (e.getSource().equals(mediumButton))
		{
			difficulty = "medium";
			
		}
			
		if (e.getSource().equals(hardButton))
		{
			difficulty = "hard";
			
		}
		
		if (e.getSource().equals(extremeButton))
		{
			difficulty = "extreme";	
		}
		
		// Si difficulty est renseigné on a forcément cliqué sur un des boutons de difficulté
		if (!difficulty.equals("")) {
			difficultyLabel.setVisible(false);
			for (int lvlNumber = 0; lvlNumber < lvlButtons.size(); ++lvlNumber) {
				lvlButtons.get(lvlNumber).setVisible(true);
				lvlButtons.get(lvlNumber).setEnabled(false);
				
				if (currentPlayer.isFinished(lvlNumber, difficulty)) {
					lvlButtons.get(lvlNumber).setEnabled(true);
					if ((lvlNumber+1) < lvlButtons.size())
						lvlButtons.get(lvlNumber+1).setEnabled(true);
				}
			}
			lvlButtons.get(0).setEnabled(true);
			easyButton.setVisible(false);
			mediumButton.setVisible(false);
			hardButton.setVisible(false);
			extremeButton.setVisible(false);
			angryFrame.setDifficulty(difficulty);
		}
		
		for (int i = 0; i < lvlButtons.size(); ++i) {
			if(e.getSource().equals(lvlButtons.get(i))) {
				Level lvl = new Level("res/maps/lvl0" + (i+1) + ".txt");
				if (lvl.isLoaded()) {
					angryFrame.getAngryView().setMap(lvl);
					angryFrame.getAngryModel().setMap(lvl);
					angryFrame.setCurrentHighScore();
					angryFrame.setGame();
					angryFrame.setCurrentLevel(i+1);
				}
				else {
					javax.swing.JOptionPane.showMessageDialog(null, "Il n'y a aucun fichier map correspondant à ce niveau, tu peux insulter les développeurs");
				}
			}
		}
		
		if (e.getSource().equals(exitButton))
		{
			System.exit(0);
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {	
		switch (e.getKeyCode()) {
			case KeyEvent.VK_ESCAPE:
				//angryFrame.setPreviousMenu();
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
}
