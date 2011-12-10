import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class GameViewMenu extends JPanel  implements ActionListener{

	private String backgroundImagePath = "res/images/background.png";
	private Image image;
	private JButton startButton;
	
	public GameViewMenu(GameController controller)
	{
		ImageIcon ii = new ImageIcon(backgroundImagePath);
	    image = ii.getImage();
	    
	    addKeyListener(controller);
	    setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        startButton = new JButton("Start game");
        startButton.setSize(50, 50);
        
        this.add(startButton,new Integer(0));
        
        this.setVisible(true);
	}
	
	public void paint(Graphics g) {
        super.paint(g);
        
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(image, 0, 0, this);
        
        
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
        
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		repaint();
		
	}
	public JButton getStartButton()
	{
		return startButton;
	}

	
}
