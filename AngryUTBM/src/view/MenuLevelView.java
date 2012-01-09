package view;

import java.util.ArrayList;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class MenuLevelView extends GameViewMenu
{
	private ArrayList<JButton> lvlButtons;

	public MenuLevelView()
	{
        lvlButtons = new ArrayList<JButton>();
        
        for (int lvlNumber = 0; lvlNumber < 5; ++lvlNumber) {
        	lvlButtons.add(new JButton("" + (lvlNumber+1)));
        	lvlButtons.get(lvlNumber).setSize(60,60);
        	int lineNumber = lvlNumber / 5;
        	lvlButtons.get(lvlNumber).setLocation(frameWidth/2-190+(lvlNumber%5)*80,frameHeight/2-80 + lineNumber*80);
        }
        
   	 	for (JButton button : lvlButtons) {
   	 		this.add(button, new Integer(1));
   	 	}
		
	}
	
	public ArrayList<JButton> getLvlButtons()
	{
		return lvlButtons;
	}
}
