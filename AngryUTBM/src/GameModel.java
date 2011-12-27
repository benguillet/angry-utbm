import java.util.ArrayList;
import java.util.List;

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
	private Pigeon currentPigeon;
	private Timer timer;
	private EntityThread entityThread;
	private EventListenerList listeners;
	private int nbPigeon;
	
	public GameModel() {
		entities = new ArrayList<Entity>();
		currentPigeon = new Pigeon();
		entities.add(currentPigeon);
		
		entities.add(new Pig());	
		
		players = new ArrayList<Player>();
		// on parcourt tout les elements du repertoire
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
		
		entityThread = new EntityThread(entities);
		entityThread.start();
		
		timer = new Timer(5, this);
		timer.start();
		
		listeners = new EventListenerList();
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

	public void setMap(Level map,int nb) {
		this.map = map;
		this.nbPigeon = nb;
		for(int i = 0 ; i < nbPigeon-1 ; i++)
		{
			Pigeon pigeon = new Pigeon();
			entities.add(pigeon);
		}
	}
	
	public ArrayList<Entity> getEntityList() {
		return entities;
	}
	
	public void addEgg() {
		short eggLeft = currentPigeon.getEggLeft();
		
		if (eggLeft > 0) {
			entities.add(new Egg((int)currentPigeon.getPosition().getX(), (int)currentPigeon.getPosition().getY()));
			currentPigeon.setEggLeft(--eggLeft);
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
			            }
					}
		        }
				int dx=0;
				int dy=0;
				int tabMap[][]= map.getTabMap();
				// collision avec le decor
				for(int y=0;y<22;y++)
				{	
					for(int x=0; x<31;x++)
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
    		if (entities.get(i) instanceof Pigeon) {
        		if (!entities.get(i).isVisible())
                	entities.remove(i);
        		for(Entity entity : entities)
        		{
        			if(entity instanceof Pigeon)
        			{
        				currentPigeon = (Pigeon)entity;
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
			listener.listChanged(new ListChangedEvent(this, getEntityList()));
		}
	}
}
