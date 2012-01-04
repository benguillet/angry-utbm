import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;
import javax.swing.event.EventListenerList;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;


public class GameModel implements ActionListener {
	private GameView display;
	private Level map;
	private ArrayList<Player> players;
	private ArrayList<Entity> entities;
	private Bird currentBird;
	private Timer timer;
	private EntityThread entityThread;
	private EventListenerList listeners;
	private Player currentPlayer;
	private String difficulty;
	private int currentLevel;
	
	public GameModel() {
		entities = new ArrayList<Entity>();
		
		players = new ArrayList<Player>();
		// on parcourt tous les elements du repertoire
		try{
			File initial = new File ("save");
			for (File f:initial.listFiles())
			{
				FileInputStream fis = new FileInputStream(f);
				ObjectInputStream ois = new ObjectInputStream(fis);
				Player pl = (Player)ois.readObject();
				players.add(pl);
			}			
		}
		catch(Exception e)
		{
			//message d'exception
		}
		
		timer = new Timer(5, this);
		timer.start();
		
		listeners = new EventListenerList();
		
		entityThread = new EntityThread(entities);
		addListListener(entityThread);
		//entityThread.start();
	}

	public GameView getDisplay() {
		return display;
	}

	public void setDisplay(GameView display) {
		this.display = display;
	}

	public Level getMap() {
		return map;
	}
	
	public ArrayList<Player> getPlayers(){
		return players;
	}

	public void setMap(Level map) {
		this.map = map;
		entities = map.getEntityList();
		for(Entity e : entities) {
			if(e instanceof Bird) {
				currentBird = (Bird) e;
				break;
			}
		}
		fireListChanged();
		entityThread.start();
	}
	
	public ArrayList<Entity> getEntityList() {
		return entities;
	}
	
	public void addEgg() {
		int eggLeft = currentBird.getEggLeft();
		
		if (eggLeft > 0) {
			entities.add(new Egg((int)currentBird.getPosition().getX(), (int)currentBird.getPosition().getY()));
			currentBird.setEggLeft(eggLeft-1);
    	}
    	else
    		System.out.println("Plus d'oeufs ! Fail ! Appuie sur R pour recharger !");
	}
	
	public void checkCollision() {
		for (int i = 0; i < entities.size(); ++i) {
			if (entities.get(i) instanceof Egg) {
				Egg e = (Egg) entities.get(i);
				Rectangle hitBoxEgg = e.getBound();
				// collision avec les entities
		        for (int j = 0; j < entities.size(); ++j) {
					if (entities.get(j) instanceof Pig) {
						Pig pigTest = (Pig)entities.get(j);
			            Rectangle hitBoxPig= pigTest.getBound();
			            if(testCollision(hitBoxEgg,hitBoxPig)) {
			            	entities.remove(i);
			            	entities.remove(j);
			            	boolean win = true;
			            	for (Entity entity : entities) {
			            		if (entity instanceof Pig) {
			            			win = false;
			            			break;
			            		}
			            	}
			            	if(win) {
			            		win();
			            	}
			            }
					}
		        }
				int dx=0;
				int dy=0;
				int tabMap[][]= map.getTabMap();
				// collision avec le decor
				for(int y=0;y<map.getTabMapSizeY();y++)
				{	
					for(int x=0; x<map.getTabMapSizeX();x++)
					{
						if(tabMap[y][x]==1 || tabMap[y][x]==2)
						{
							Rectangle HitBox = new Rectangle(dx,dy,26,26);
							if(testCollision(hitBoxEgg, HitBox))
							{
								entities.remove(i);
								if(tabMap[y][x]==2)
									tabMap[y][x]=0;
								break;
							}
						}
						dx=dx+26;
					}
					dy=dy+26;
			    	dx=0;
					}
				}
			}
	}
				
			
	
	public boolean testCollision(Rectangle x, Rectangle y)
	{
		if(x.intersects(y))
			return true;
		return false;
	}
	
	public void actionPerformed(ActionEvent event) {
        for (int i = 0; i <entities.size(); ++i ) {
        	if (entities.get(i) instanceof Egg) {
        		if (!entities.get(i).isVisible())
                	entities.remove(i);
        	}
    		if (entities.get(i) instanceof Bird) {
        		if (!entities.get(i).isVisible()) {
                	entities.remove(i);
            		boolean loose = true;
            		for (Entity entity : entities) {
            			if (entity instanceof Bird) {
            				currentBird = (Bird) entity;
            				loose = false;
            				break;
            			}
            		}
            		if(loose) {
            			loose();
            		}
        		}
        	}
        }
        checkCollision();
        fireListChanged();
    }
	
	public void addListListener(ListListener listener) {
		listeners.add(ListListener.class, listener);
	}
	
	public void removeListListener(ListListener l) {
		listeners.remove(ListListener.class, l);
	}
	
	public void fireListChanged(){
		ListListener[] listenerList = (ListListener[])listeners.getListeners(ListListener.class);
		
		for(ListListener listener : listenerList){
			listener.listChanged(new ListChangedEvent(this, getEntityList(), currentBird));
		}
	}
	
	public void win() {
		System.out.println("Bravo! Vous avez gagn�!");
		currentPlayer.finished(currentLevel, difficulty);
	}
	
	public void loose() {
		System.out.println("La loose! Vous avez perdu!");
	}
	
	public void setCurrentPlayer(Player p) {
		currentPlayer = p;
	}
	
	public void setDifficulty(String dif) {
		difficulty = dif;
	}
	
	public void setCurrentLevel(int l) {
		currentLevel = l;
	}
	
	public Bird getCurrentBird() {
		return currentBird;
	}
}
