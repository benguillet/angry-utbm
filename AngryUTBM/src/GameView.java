
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

import java.util.ArrayList;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GameView extends JPanel implements ListListener {
	private Level map;
	private ArrayList<Entity> entities;
	private int frameHeight = 600;
	private int frameWidth = 1200;
	private Bird currentBird;
	
	
	public GameView(ArrayList<Entity> entities) {

        setFocusable(true);
        setDoubleBuffered(true);
        
        this.entities = entities; 
	}
	
	public void paint(Graphics g) {
        super.paint(g);

        // On affiche le level
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(map.getImage(), 0, 0,frameWidth,frameHeight, this);
        
        int tabMap[][]= map.getTabMap();
        
	    int dx=0;
	    int dy=0;
	    
	    for(int i=0; i<map.getTabMapSizeY();i++)
	    {
	    	for(int j=0; j<map.getTabMapSizeX();j++)
	    	{
	    		switch(tabMap[i][j])
	    		{
	    		case 1 :
	    			g2d.drawImage(map.getGrass(), dx, dy, this);
	    			break;
	    		case 2 :
	    			g2d.drawImage(map.getBlock(), dx, dy, this);
	    			break;
	    		default :
	    			break;
	    		}
	    		
	    		dx=dx+26;
	    	}
	    	dy=dy+26;
	    	dx=0;
	    }
        
	    
	    
	    int k = 0;
	    boolean first = true;
	    for(Entity e : entities) {
	    	if(e instanceof Bird) {
	    		g2d.drawImage(e.getImage(), frameWidth*4/5+k*15, 100, this);
	    		k++;
	    		if(first){
	    			Egg egg = new Egg(0,0);
	    			for (int j = 0; j < currentBird.getEggLeft(); ++j) {
	        			g2d.drawImage(egg.getImage(), frameWidth*4/5+j*15, 20, this);
	        		}
	    		}
	    		first = false;
	    	}
	    }
        
        for (Entity e : entities) {
        	if (!(e instanceof Bird) || e == currentBird) { // on affiche pas tous les oiseaux, juste le courant
        		g2d.drawImage(e.getImage(), (int) e.getPosition().getX(), (int) e.getPosition().getY(), this);
        	}
        }
        
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }
	
	public void setEntityList(ArrayList<Entity> entities) {
		this.entities = entities;
	}
	

	public Level getMap() {
		return map;
	}

	public void setMap(Level map) {
		this.map = map;
	}

	@Override
	public void listChanged(ListChangedEvent event) {
		entities = event.getEntityList();
		currentBird = event.getCurrentBird();
		repaint();
		
	}
	
}
