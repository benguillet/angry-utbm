package view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuOptionsView extends GameViewMenu
{
	
	private JLabel controlsLabel,controlsImageLabel;
	private String controlsImagePath = "res/images/controls.png";
	private Image image;
	
	public MenuOptionsView()
	{
		ImageIcon ii = new ImageIcon(controlsImagePath);
	    image = ii.getImage();
	    
	    controlsLabel = new JLabel("Controls :");
        controlsLabel.setSize(200, 30);
        controlsLabel.setLocation(frameWidth/2-100,150);
        
        controlsImageLabel= new JLabel() {
    	    
			public void paint(Graphics g) {
				g.drawImage(image,frameWidth/2, frameHeight/2, null);
			
			}
		};
		
		this.add(controlsLabel,new Integer(1));
	}

}
