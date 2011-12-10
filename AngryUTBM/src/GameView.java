
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
	
	private ArrayList<Pigeon> pigeons;
	private ArrayList<Pig> pigs;
	
	public GameView(GameController controller, ArrayList<Pigeon> pigeons, ArrayList<Pig> pigs) {

        addKeyListener(controller);
        setFocusable(true);
        setDoubleBuffered(true);

        timer = new Timer(5, this);
        map = new Level("res/maps/lvl01.txt");
        
        this.pigeons = pigeons;
		this.pigs = pigs;
        
       	timer.start();
	}
	
	public void paint(Graphics g) {
        super.paint(g);

        // On affiche le level
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(map.getImage(), 0, 0, this);
        
        int tabMap[][]= map.getTabMap();
        
	    int dx=0;
	    int dy=0;
	    
	    for(int i=0; i<24;i++)
	    {
	    	for(int j=0; j<32;j++)
	    	{
	    		switch(tabMap[i][j])
	    		{
	    		case 1 :
	    			g2d.drawImage(map.getGrass(), dx, dy, this);
	    			break;
	    		case 2 :
	    			g2d.drawImage(map.getBloc(), dx, dy, this);
	    			break;
	    		default :
	    			break;
	    		}
	    		
	    		dx=dx+25;
	    	}
	    	dy=dy+25;
	    	dx=0;
	    }
        
        
        // On affiche les pigeons
        for (int i = 0; i < pigeons.size(); ++i ) {
        	Pigeon p = (Pigeon) pigeons.get(i);
            g2d.drawImage(p.getImage(), p.getPosition().getX(), p.getPosition().getY(), this);
        }
        
        
        // On affiche les cochons
        for (int i = 0; i < pigs.size(); ++i ) {
            Pig p = (Pig) pigs.get(i);
            g2d.drawImage(p.getImage(), p.getPosition().getX(), p.getPosition().getY(), this);
        }
        
        // On affiche les oeufs lachés
        for (int i = 0; i < pigeons.size(); ++i ) {
        	ArrayList<Egg> eggs = pigeons.get(i).getEggs();
        	
        	for (int j = 0; j < eggs.size(); ++j ) {
        		Egg e = (Egg) eggs.get(j);
        		g2d.drawImage(e.getImage(), e.getPosition().getX(), e.getPosition().getY(), this);
        	}
        }
        
        Egg e = new Egg();        
        // On affiche les oeufs restants	
        for (int i = 0; i < pigeons.get(0).getEggLeft(); ++i) {
        		g2d.drawImage(e.getImage(), 600+i*15, 20, this);
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
