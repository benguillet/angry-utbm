
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import java.util.ArrayList;

import javax.swing.Timer;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GameView extends JPanel implements ActionListener {
	private Level map;
	private Timer timer;
	private ArrayList<Entity> entities;
	
	
	public GameView(GameController controller, ArrayList<Entity> entities) {

        addKeyListener(controller);
        setFocusable(true);
        setDoubleBuffered(true);

        timer = new Timer(5, this);
        map = new Level();  
        
        this.entities = entities;
        
       	timer.start();
	}
	
	public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(map.getImage(), 0, 0, this);
        
        for (int i = 0; i < entities.size(); ++i) {
        	if (entities.get(i) instanceof Bird) {
            	Bird bird = (Bird) entities.get(i);
        		for (int j = 0; j < bird.getEggLeft(); ++j) {
        			Egg egg = new Egg(0,0);
        			g2d.drawImage(egg.getImage(), 600+j*15, 20, this);
        		}
        	}
        }
        
        for (int i = 0; i < entities.size(); ++i) {
            g2d.drawImage(entities.get(i).getImage(), entities.get(i).getPosition().getX(), entities.get(i).getPosition().getY(), this);
        	//g2d.drawRect(entities.get(i).getBound().x,entities.get(i).getBound().y,entities.get(i).getBound().width,entities.get(i).getBound().height);
        }
        
        
        /*// On affiche les pigeons
        for (int i = 0; i < pigeons.size(); ++i ) {
        	Pigeon p = (Pigeon) pigeons.get(i);
            g2d.drawImage(p.getImage(), p.getPosition().getX(), p.getPosition().getY(), this);
        }
        
         // On affiche les cochons
        for (int i = 0; i < pigs.size(); ++i ) {
            Pig p = (Pig) pigs.get(i);
            g2d.drawImage(p.getImage(), p.getPosition().getX(), p.getPosition().getY(), this);
            g2d.drawRect(p.getBound().x,p.getBound().y,p.getBound().width,p.getBound().height);
        }
        
       // On affiche les oeufs lachés
        for (int i = 0; i < pigeons.size(); ++i ) {
        	ArrayList<Egg> eggs = pigeons.get(i).getEggs();
        	
        	for (int j = 0; j < eggs.size(); ++j ) {
        		Egg e = (Egg) eggs.get(j);
        		g2d.drawImage(e.getImage(), e.getPosition().getX(), e.getPosition().getY(), this);
        	}
        }
        
        Egg e = new Egg(0,0);        
        // On affiche les oeufs restants	
        for (int i = 0; i < pigeons.get(0).getEggLeft(); ++i) {
        		g2d.drawImage(e.getImage(), 600+i*15, 20, this);
        }*/
        
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }
	
	public void setEntityList(ArrayList<Entity> entities) {
		this.entities = entities;
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
