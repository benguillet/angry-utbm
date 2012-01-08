package view;

import main.GameFrame;
import model.Player;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class GameViewMenu extends JLayeredPane {

	private String titleImagePath = "res/images/title.png";
	private Image image,title;
	private ArrayList<Player> players;
	private JLabel difficultyLabel,playernameLabel;
	private JTextField playernameField;
	private JButton newButton,loadButton,optionsButton,exitButton,okButton;
	private JButton easyButton, mediumButton, hardButton, extremeButton;
	private String backgroundImagePath = "res/images/background.png";
	private String backgroundImagePathCredit = "res/images/backgroundCredit.png";
	private String imgBird1 = "res/images/pigeon.png";
	private ArrayList<JButton> lvlButtons;
	private JComboBox playersList;
	private int frameHeight = 600;
	private int frameWidth = 1200;
	
	public GameViewMenu(ArrayList<Player> players)
	{
		final int frameHeight = GameFrame.getFrameSize().height;
		final int frameWidth = GameFrame.getFrameSize().width;
		
		this.players = players;
		
		ImageIcon ii = new ImageIcon(backgroundImagePath);
	    image = ii.getImage();

	    ImageIcon ti = new ImageIcon(titleImagePath);
	    title = ti.getImage();
	      
	    JPanel backPanel= new JPanel() {
	    
			public void paint(Graphics g) {
				g.drawImage(image, 0, 0,frameWidth, frameHeight, null);
				g.drawImage(title,frameWidth/2-295, 20, null);
			
			}
		};
		
		backPanel.setSize(new Dimension(frameWidth, frameHeight));
	    setFocusable(true);
        setDoubleBuffered(true);

        playersList = new JComboBox();
        playersList.setSize(200,30);
        playersList.setLocation(frameWidth/2-100,150);

        for(Player p : players)
        {
        	playersList.addItem(p);
        }
        
        difficultyLabel = new JLabel("Choose difficulty :");
        difficultyLabel.setSize(200, 30);
        difficultyLabel.setLocation(frameWidth/2-100,150);
        
        playernameLabel = new JLabel("Enter your name :");
        playernameLabel.setSize(200, 30);
        playernameLabel.setLocation(frameWidth/2-100,150);
        
        playernameField = new JTextField();
        playernameField.setSize(200,30);
        playernameField.setLocation(frameWidth/2-100,250);
        
        okButton = new JButton("OK");
        okButton.setSize(200, 30);
        okButton.setLocation(frameWidth/2-100,350);
        
        newButton = new JButton("NEW GAME");
        newButton.setSize(200,30);
        newButton.setLocation(frameWidth/2-100, 150);
        
        loadButton = new JButton("LOAD GAME");
        loadButton.setSize(200,30);
        loadButton.setLocation(frameWidth/2-100, 225);
        
        optionsButton = new JButton("OPTIONS");
        optionsButton.setSize(200,30);
        optionsButton.setLocation(frameWidth/2-100, 300);
        
        exitButton = new JButton("EXIT GAME");
        exitButton.setSize(200,30);
        exitButton.setLocation(frameWidth/2-100, 375);
        
        easyButton = new JButton("EASY");
        easyButton.setSize(200,30);
        easyButton.setLocation(frameWidth/2-100, 250);
        
        mediumButton = new JButton("MEDIUM");
        mediumButton.setSize(200,30);
        mediumButton.setLocation(frameWidth/2-100, 325);
        
        hardButton = new JButton("HARD");
        hardButton.setSize(200,30);
        hardButton.setLocation(frameWidth/2-100, 400);
        
        extremeButton = new JButton("EXTREME");
        extremeButton.setSize(200,30);
        extremeButton.setLocation(frameWidth/2-100, 475);
        
        lvlButtons = new ArrayList<JButton>();
        
        for (int lvlNumber = 0; lvlNumber < 5; ++lvlNumber) {
        	lvlButtons.add(new JButton("" + (lvlNumber+1)));
        	lvlButtons.get(lvlNumber).setSize(60,60);
        	int lineNumber = lvlNumber / 5;
        	lvlButtons.get(lvlNumber).setLocation(frameWidth/2-190+(lvlNumber%5)*80, 
        											frameHeight/2-80 + lineNumber*80);
        }
        
        
        this.add(backPanel,new Integer(0));
   	 	this.add(newButton,new Integer(1));
   	 	this.add(loadButton,new Integer(1));
   	 	this.add(optionsButton,new Integer(1));
   	 	this.add(exitButton,new Integer(1));
   	 	
   	 	this.add(playernameLabel,new Integer(1));
   	 	this.add(playernameField,new Integer(1));
   	 	this.add(okButton,new Integer(1));
   	 	
   	 	this.add(playersList,new Integer(1));
   	 	
   	 	this.add(difficultyLabel,new Integer(1));
   	 	this.add(easyButton,new Integer(1));
   	 	this.add(mediumButton,new Integer(1));
   	 	this.add(hardButton,new Integer(1));
   	 	this.add(extremeButton,new Integer(1));

   	 	
   	 	for (JButton button : lvlButtons) {
   	 		this.add(button, new Integer(1));
   	 		button.setVisible(false);
   	 	}
   	 	
   	 	difficultyLabel.setVisible(false);
   	 	easyButton.setVisible(false);
   	 	mediumButton.setVisible(false);
   	 	hardButton.setVisible(false);
   	 	extremeButton.setVisible(false);
   	 	okButton.setVisible(false);
   	 	playernameField.setVisible(false);
   	 	playernameLabel.setVisible(false);
   	 	playersList.setVisible(false);
        
        this.setVisible(true);
	}

	public JButton getNewButton()
	{
		return newButton;
	}
	
	public JButton getLoadButton()
	{
		return loadButton;
	}
	
	public JButton getOptionsButton()
	{
		return optionsButton;
	}
	
	public JButton getExitButton()
	{
		return exitButton;
	}
	
	public JButton getEasyButton()
	{
		return easyButton;
	}
	
	public JButton getMediumButton()
	{
		return mediumButton;
	}
	
	public JButton getHardButton()
	{
		return hardButton;
	}
	
	public JButton getExtremeButton()
	{
		return extremeButton;
	}
	
	public ArrayList<JButton> getLvlButtons()
	{
		return lvlButtons;
	}
	
	public JLabel getDifficultyLabel()
	{
		return difficultyLabel;
	}
	
	public JLabel getPlayerNameLabel()
	{
		return playernameLabel;
	}
	
	public JTextField getPlayerNameField()
	{
		return playernameField;
	}
	
	public JButton getOkButton()
	{
		return okButton;
	}
	
	public JComboBox getPlayersList()
	{
		return playersList;
	}
	
}
