package view;

import javax.swing.JButton;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class MenuDifficultyView extends GameViewMenu
{

	private JLabel difficultyLabel;
	private JButton easyButton, mediumButton, hardButton, extremeButton;
	
	public MenuDifficultyView()
	{
        difficultyLabel = new JLabel("Choose difficulty :");
        difficultyLabel.setSize(200, 30);
        difficultyLabel.setLocation(frameWidth/2-100,150);
		
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
        
   	 	this.add(difficultyLabel,new Integer(1));
   	 	this.add(easyButton,new Integer(1));
   	 	this.add(mediumButton,new Integer(1));
   	 	this.add(hardButton,new Integer(1));
   	 	this.add(extremeButton,new Integer(1));
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
}
