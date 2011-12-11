import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import sun.net.ProgressEvent;
import sun.net.ProgressListener;


public class GameViewMenu extends JLayeredPane {

	private String titleImagePath = "res/images/title.png";
	private Image image,title;
	private JLabel difficultyLabel,playernameLabel;
	private JTextField playernameField;
	private JButton newButton,loadButton,optionsButton,exitButton,okButton;
	private JButton easyButton, mediumButton, hardButton, extremeButton;
	private String backgroundImagePath = "res/images/backgroundMenu.png";
	private String backgroundImagePathCredit = "res/images/backgroundCredit.png";
	private String imgBird1 = "res/images/pigeon.png";
	private JButton lvl01Button;
	private JButton lvl02Button;
	
	public GameViewMenu(GameController controller)
	{
		ImageIcon ii = new ImageIcon(backgroundImagePath);
	    image = ii.getImage();

	    ImageIcon ti = new ImageIcon(titleImagePath);
	    title = ti.getImage();
	      
	    JPanel backPanel= new JPanel() {
	    
			public void paint(Graphics g) {
				g.drawImage(image, 0, 0, null);
				g.drawImage(title,800/2-295, 20, null);
			
			}
		};
		
		backPanel.setSize(new Dimension(800, 600));
	    
	    addKeyListener(controller);
	    setFocusable(true);
        setDoubleBuffered(true);
        
        difficultyLabel = new JLabel("Choose difficulty :");
        difficultyLabel.setSize(200, 30);
        difficultyLabel.setLocation(400-100,150);
        
        playernameLabel = new JLabel("Enter your name :");
        playernameLabel.setSize(200, 30);
        playernameLabel.setLocation(400-100,150);
        
        playernameField = new JTextField();
        playernameField.setSize(200,30);
        playernameField.setLocation(400-100,250);
        
        okButton = new JButton("OK");
        okButton.setSize(200, 30);
        okButton.setLocation(400-100,350);
        
        newButton = new JButton("NEW GAME");
        newButton.setSize(200,30);
        newButton.setLocation(400-100, 150);
        
        loadButton = new JButton("LOAD GAME");
        loadButton.setSize(200,30);
        loadButton.setLocation(400-100, 225);
        
        optionsButton = new JButton("OPTIONS");
        optionsButton.setSize(200,30);
        optionsButton.setLocation(400-100, 300);
        
        exitButton = new JButton("EXIT GAME");
        exitButton.setSize(200,30);
        exitButton.setLocation(400-100, 375);
        
        easyButton = new JButton("EASY");
        easyButton.setSize(200,30);
        easyButton.setLocation(400-100, 250);
        
        mediumButton = new JButton("MEDIUM");
        mediumButton.setSize(200,30);
        mediumButton.setLocation(400-100, 325);
        
        hardButton = new JButton("HARD");
        hardButton.setSize(200,30);
        hardButton.setLocation(400-100, 400);
        
        extremeButton = new JButton("EXTREME");
        extremeButton.setSize(200,30);
        extremeButton.setLocation(400-100, 475);
                
        lvl01Button = new JButton("LEVEL 1");
        lvl01Button.setSize(200,30);
        lvl01Button.setLocation(400-100, 400-15);
        
        lvl02Button = new JButton("LEVEL 2");
        lvl02Button.setSize(200,30);
        lvl02Button.setLocation(400-100, 500-15);
        
        this.add(backPanel,new Integer(0));
   	 	this.add(newButton,new Integer(1));
   	 	this.add(loadButton,new Integer(1));
   	 	this.add(optionsButton,new Integer(1));
   	 	this.add(exitButton,new Integer(1));
   	 	
   	 	this.add(playernameLabel,new Integer(1));
   	 	this.add(playernameField,new Integer(1));
   	 	this.add(okButton,new Integer(1));
   	 	
   	 	this.add(difficultyLabel,new Integer(1));
   	 	this.add(easyButton,new Integer(1));
   	 	this.add(mediumButton,new Integer(1));
   	 	this.add(hardButton,new Integer(1));
   	 	this.add(extremeButton,new Integer(1));
   	 	
   	 	this.add(lvl01Button,new Integer(1));
   	 	this.add(lvl02Button,new Integer(1));
   	 	
   	 	lvl01Button.setVisible(false);
   	 	lvl02Button.setVisible(false);
   	 	difficultyLabel.setVisible(false);
   	 	easyButton.setVisible(false);
   	 	mediumButton.setVisible(false);
   	 	hardButton.setVisible(false);
   	 	extremeButton.setVisible(false);
   	 	okButton.setVisible(false);
   	 	playernameField.setVisible(false);
   	 	playernameLabel.setVisible(false);
        
        this.setVisible(true);
	}
	
	/*public void paint(Graphics g) {
        super.paint(g);
        
        Graphics2D g2d = (Graphics2D)g;
        //g2d.drawImage(image, 0, 0, this);
        
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
      
	}*/

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


	public JButton getLvl01Button()
	{
		return lvl01Button;
	}
	
	public JButton getLvl02Button()
	{
		return lvl02Button;
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
	
}
