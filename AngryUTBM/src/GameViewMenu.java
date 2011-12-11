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
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import sun.net.ProgressEvent;
import sun.net.ProgressListener;


public class GameViewMenu extends JLayeredPane {

	private String backgroundImagePath = "res/images/backgroundMenu.png";
	private String backgroundImagePathCredit = "res/images/backgroundCredit.png";
	private String imgBird1 = "res/images/pigeon.png";
	private Image image;
	private JButton startButton;
	private JButton lvl01Button;
	private JButton lvl02Button;
	
	public GameViewMenu(GameFrame frame)
	{
		ImageIcon ii = new ImageIcon(backgroundImagePath);
	    image = ii.getImage();
	   	    
	    JPanel backPanel= new JPanel() {
	    
			public void paint(Graphics g) {
				g.drawImage(image, 0, 0, null);
			}
		};
		
		backPanel.setSize(new Dimension(800, 600));
	    
	    addKeyListener(frame.getController());
	    setFocusable(true);
        setDoubleBuffered(true);
        
        startButton = new JButton("Start game");
        startButton.setSize(200,30);
        startButton.setLocation(400-100, 400-15);
        startButton.addActionListener(frame.getController());
        
        lvl01Button = new JButton("Level 1");
        lvl01Button.setSize(200,30);
        lvl01Button.setLocation(400-100, 400-15);
        lvl01Button.addActionListener(frame.getController());
        
        lvl02Button = new JButton("Level 2");
        lvl02Button.setSize(200,30);
        lvl02Button.setLocation(400-100, 500-15);
        lvl02Button.addActionListener(frame.getController());
        
        this.add(backPanel,new Integer(0));
   	 	this.add(startButton,new Integer(1));
   	 	
   	 	this.add(lvl01Button,new Integer(1));
   	 	this.add(lvl02Button,new Integer(1));
   	 	
   	 	lvl01Button.setVisible(false);
   	 	lvl02Button.setVisible(false);
   	 
        this.setVisible(true);
	}
	
	public void paint(Graphics g) {
        super.paint(g);
        
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(new ImageIcon(imgBird1).getImage(), 0, 0, this);
       
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
      
	}
	
	public JButton getStartButton() {
		return startButton;
	}
	public JButton getLvl01Button() {
		return lvl01Button;
	}
	public JButton getLvl02Button() {
		return lvl02Button;
	}
}
