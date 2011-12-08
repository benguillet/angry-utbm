import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.Timer;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GameView extends JPanel implements ActionListener {
	private Level map;
	private Timer timer;
	
	private ArrayList<Pigeon> pigeons;
	private ArrayList<Pig> pigs;
	
	public GameView(GameController controller, ArrayList<Pigeon> pigeons2, ArrayList<Pig> pigs2) {

        addKeyListener(controller);
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);

        timer = new Timer(5, this);
        map = new Level();
        
		pigeons = pigeons2;
		pigs = pigs2;
        
        timer.start();
	}
	
	public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(map.getImage(), 0, 0, this);
        
        for (int i = 0; i < pigeons.size(); ++i ) {
        	Pigeon p = (Pigeon) pigeons.get(i);
            g2d.drawImage(p.getImage(), p.getPosition().getX(), p.getPosition().getY(), this);
        }
        
        for (int i = 0; i < pigs.size(); ++i ) {
            Pig p = (Pig) pigs.get(i);
            g2d.drawImage(p.getImage(), p.getPosition().getX(), p.getPosition().getY(), this);
        }
        
        for (int i = 0; i < pigeons.size(); ++i ) {
        	ArrayList<Egg> eggs = pigeons.get(i).getEggs();
        	
        	for (int j = 0; j < eggs.size(); ++j ) {
        		Egg e = (Egg) eggs.get(j);
        		g2d.drawImage(e.getImage(), e.getPosition().getX(), e.getPosition().getY(), this);
        	}
        }

        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }
	
	public void setEntityLists(ArrayList<Pigeon> pigeons2, ArrayList<Pig> pigs2) {
		pigeons = pigeons2;
		pigs = pigs2;
	}

	public void actionPerformed(ActionEvent event) {
        repaint();
    }
	

	public Level getMap() {
		return map;
	}

	public void setMap(Level map) {
		this.map = map;
	}
	
}
