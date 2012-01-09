package controller;

import main.GameFrame;
import model.Level;
import model.Player;
import view.GameViewMenu;
import view.MenuDifficultyView;
import view.MenuHomeView;
import view.MenuLevelView;
import view.MenuLoadView;
import view.MenuNewView;
import view.MenuOptionsView;

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
	private JButton newButton,loadButton,optionsButton,exitButton;
	private JButton okNewButton,okLoadButton;
	private JButton easyButton,mediumButton,hardButton,extremeButton;
	private ArrayList<JButton> lvlButtons;
	private Player currentPlayer;
	private JComboBox playersList;
	private MenuHomeView angryMenuHomeView;
	private MenuNewView angryMenuNewView;
	private MenuLoadView angryMenuLoadView;
	private MenuOptionsView angryMenuOptionsView;
	private MenuDifficultyView angryMenuDifficultyView;
	private MenuLevelView angryMenuLevelView;
	private GameFrame angryFrame;
	
	public MenuController(GameFrame frame){
		
		angryFrame = frame;
		
		angryMenuHomeView = frame.getAngryMenuHomeView();
		angryMenuNewView = frame.getAngryMenuNewView();
		angryMenuLoadView = frame.getAngryMenuLoadView();
		angryMenuOptionsView = frame.getAngryMenuOptionsView();
		angryMenuDifficultyView = frame.getAngryMenuDifficultyView();
		angryMenuLevelView = frame.getAngryMenuLevelView();
		
		newButton = angryMenuHomeView.getNewButton();
		newButton.addActionListener(this);
		loadButton = angryMenuHomeView.getLoadButton();
		loadButton.addActionListener(this);	
		optionsButton = angryMenuHomeView.getOptionsButton();
		optionsButton.addActionListener(this);
		exitButton = angryMenuHomeView.getExitButton();
		exitButton.addActionListener(this);
		
		playerNameField = angryMenuNewView.getPlayerNameField();
		okNewButton = angryMenuNewView.getOkNewButton();
		okNewButton.addActionListener(this);
				
		playersList = angryMenuLoadView.getPlayersList();
		okLoadButton = angryMenuLoadView.getOkLoadButton();
		okLoadButton.addActionListener(this);
		
		easyButton = angryMenuDifficultyView.getEasyButton();
		easyButton.addActionListener(this);
		mediumButton = angryMenuDifficultyView.getMediumButton();
		mediumButton.addActionListener(this);
		hardButton = angryMenuDifficultyView.getHardButton();
		hardButton.addActionListener(this);
		extremeButton = angryMenuDifficultyView.getExtremeButton();
		extremeButton.addActionListener(this);
		
		lvlButtons = angryMenuLevelView.getLvlButtons();
		for (JButton button : lvlButtons) {
			button.addActionListener(this);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		if (e.getSource().equals(newButton))
		{
			angryFrame.setContentPane(angryMenuNewView);
			angryMenuNewView.requestFocus();
			angryFrame.setVisible(true);
		}
		
		if(e.getSource().equals(loadButton))
		{			
			if(angryFrame.getAngryModel().getPlayers().isEmpty())
			{
				javax.swing.JOptionPane.showMessageDialog(null, "Aucune sauvegarde en m�moire !");
			}
			else
			{
				angryFrame.setContentPane(angryMenuLoadView);
				angryMenuLoadView.requestFocus();
				angryFrame.setVisible(true);
			}
		}
		
		if (e.getSource().equals(optionsButton))
		{
			angryFrame.setContentPane(angryMenuOptionsView);
			angryMenuOptionsView.requestFocus();
			angryFrame.setVisible(true);
		}
		
		if (e.getSource().equals(exitButton))
		{
			System.exit(0);
		}
		
		if(e.getSource().equals(okNewButton))
		{			
			if (playerNameField.getText().equals(""))
			{
				javax.swing.JOptionPane.showMessageDialog(null, "Il faut mettre ton pseudo");
			}		
			else 
			{
				currentPlayer = new Player(playerNameField.getText());
				playerNameField.setVisible(false);
				angryFrame.setCurrentPlayer(currentPlayer);
				angryFrame.setDifficulty("");
				angryFrame.setCurrentLevel(0);
				angryFrame.setCurrentHighScore();
				
				angryFrame.setContentPane(angryMenuDifficultyView);
				angryMenuDifficultyView.requestFocus();
				angryFrame.setVisible(true);
			}
			
		}
		
		if(e.getSource().equals(okLoadButton))
		{
			currentPlayer = (Player) playersList.getSelectedItem();
			playersList.setVisible(false);
			angryFrame.setCurrentPlayer(currentPlayer);
			angryFrame.setDifficulty("");
			angryFrame.setCurrentLevel(0);
			angryFrame.setCurrentHighScore();

			angryFrame.setContentPane(angryMenuDifficultyView);
			angryMenuDifficultyView.requestFocus();
			angryFrame.setVisible(true);
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
		
		// Si difficulty est renseignee on a forcement clique sur un des boutons de difficulte
		if (!difficulty.equals("")) {
			for (int lvlNumber = 0; lvlNumber < lvlButtons.size(); ++lvlNumber) {
				lvlButtons.get(lvlNumber).setEnabled(false);
				
				if (currentPlayer.isFinished(lvlNumber, difficulty)) {
					lvlButtons.get(lvlNumber).setEnabled(true);
					if ((lvlNumber+1) < lvlButtons.size())
						lvlButtons.get(lvlNumber+1).setEnabled(true);
				}
			}
			lvlButtons.get(0).setEnabled(true);
			
			angryFrame.setDifficulty(difficulty);
			
			angryFrame.setContentPane(angryMenuLevelView);
			angryMenuLevelView.requestFocus();
			angryFrame.setVisible(true);
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
					javax.swing.JOptionPane.showMessageDialog(null, "Il n'y a aucun fichier map correspondant a� ce niveau, tu peux insulter les developpeurs");
				}
			}
		}
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {	
		switch (e.getKeyCode()) {
			case KeyEvent.VK_ESCAPE:
				//angryFrame.setPreviousMenu();
				break;
			default:
				System.out.println("je gere pas cette touche ! Blaireau !");
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
