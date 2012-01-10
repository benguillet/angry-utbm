package view;

import main.GameFrame;
import model.Player;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class GameViewMenu extends JLayeredPane {
	
	final int frameWidth = GameFrame.getFrameSize().width;
	final int frameHeight = GameFrame.getFrameSize().height;

	private String titleImagePath = "res/images/title.png";
	private String backgroundImagePath = "res/images/background.png";
	private Image image,title;
	
	private JPanel backPanel;
	protected JButton backButton;
	
	public GameViewMenu()
	{

		
		ImageIcon ii = new ImageIcon(backgroundImagePath);
	    image = ii.getImage();

	    ImageIcon ti = new ImageIcon(titleImagePath);
	    title = ti.getImage();
	      
	    backPanel= new JPanel() {
	    
			public void paint(Graphics g) {
				g.drawImage(image, 0, 0,frameWidth, frameHeight, null);
				g.drawImage(title,frameWidth/2-295, 20, null);
			
			}
		};
		
		backPanel.setSize(new Dimension(frameWidth, frameHeight));
	    setFocusable(true);
        setDoubleBuffered(true);
        
        backButton = new JButton("BACK");
        backButton.setSize(100,30);
        backButton.setLocation(1000, 500);
        
        this.add(backPanel,new Integer(0));
        this.add(backButton,new Integer(1));
   	 	        
        this.setVisible(true);
	}
	
}
