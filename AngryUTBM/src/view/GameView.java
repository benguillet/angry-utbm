package view;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JPanel;
import model.Level;
import model.ListChangedEvent;
import model.ListListener;
import model.entities.Bird;
import model.entities.Egg;
import model.entities.Entity;

@SuppressWarnings("serial")
public class GameView extends JPanel implements ListListener {
	private Level map;
	private ArrayList<Entity> entities;
	private int frameHeight = 600;
	private int frameWidth = 1200;
	private Bird currentBird;
	private int currentHighestScore;
	
	
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
        
        g.drawString("Highest Score : " + currentHighestScore, 10, 15);
        g.drawString("Flying time left : " + currentBird.getFlyingTimeLeft(), 10, 30);
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
	
	public void setCurrentHighestScore(int highestScore) {
		this.currentHighestScore = highestScore;
	}

	@Override
	public void listChanged(ListChangedEvent event) {
		entities = event.getEntityList();
		currentBird = event.getCurrentBird();
		repaint();
		
	}
}
