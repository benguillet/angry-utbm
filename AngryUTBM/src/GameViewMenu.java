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
import javax.swing.text.LayeredHighlighter;

import sun.net.ProgressEvent;
import sun.net.ProgressListener;

import com.sun.xml.internal.ws.api.server.Container;


public class GameViewMenu extends JLayeredPane {

	private String backgroundImagePath = "res/images/backgroundMenu.png";
	private String backgroundImagePathCredit = "res/images/backgroundCredit.png";
	private String imgBird1 = "res/images/pigeon.png";
	private int x;
	private int y;
	private Image image;
	private JButton startButton;
	
	public GameViewMenu(GameController controller)
	{
		ImageIcon ii = new ImageIcon(backgroundImagePath);
	    image = ii.getImage();
	     JPanel backPanel= new JPanel(){
	    
			public void paint(Graphics g) {
				g.drawImage(image, 0, 0, null);
			}
		};
		backPanel.setSize(new Dimension(800, 600));
	    
	    addKeyListener(controller);
	    x=0;
	    y=0;
	    setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        startButton = new JButton("Start game");
        startButton.setSize(200,30);
        startButton.setLocation(400-100, 400-15);
        
        this.add(backPanel,new Integer(0));
   	 	this.add(startButton,new Integer(1));
        
        this.setVisible(true);
	}
	
	public void paint(Graphics g) {
        super.paint(g);
        x++;
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(new ImageIcon(imgBird1).getImage(), 0, 0, this);
       
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
      
	}
	public JButton getStartButton()
	{
		return startButton;
	}
}
