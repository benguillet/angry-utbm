import java.util.ArrayList;
import java.util.List;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;
import javax.swing.event.EventListenerList;


public class GameModel implements ActionListener {
	private GameView display;
	private Level map;
	private ArrayList<Entity> entities;
	private Pigeon currentPigeon;
	private Timer timer;
	private EnemyThread enemyThread;
	private EventListenerList listeners;
	
	public GameModel() {
		map = new Level("res/maps/lvl01.txt");
		entities = new ArrayList<Entity>();
		currentPigeon = new Pigeon();
		entities.add(currentPigeon);
		entities.add(new Pig());	
		
		enemyThread = new EnemyThread(entities);
		enemyThread.start();
		
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

	public void setMap(Level map) {
		this.map = map;
	}
	
	public ArrayList<Entity> getEntityList() {
		return entities;
	}
	
	public void addEgg() {
		short eggLeft = currentPigeon.getEggLeft();
		
		if (eggLeft > 0) {
			entities.add(new Egg(currentPigeon.getPosition().getX(), currentPigeon.getPosition().getY()));
			currentPigeon.setEggLeft(eggLeft--);
    	}
    	else
    		System.out.println("Plus d'oeufs ! Fail ! Appuie sur R pour recharger !");
	}
	
	public void checkCollision()
	{
		
				for (int i = 0; i < entities.size(); ++i) {
					if (entities.get(i) instanceof Egg)
					{
						Egg e = (Egg) entities.get(i);
						Rectangle hitBoxEgg = e.getBound();
					// collision avec les entities
		            for (int j = 0; j < entities.size(); ++j) {
		    			if (entities.get(j) instanceof Pig){
		    				Pig pigTest = (Pig)entities.get(j);
				            Rectangle hitBoxPig= pigTest.getBound();
				            if(testCollision(hitBoxEgg,hitBoxPig))
				            {
				            	entities.remove(i);
				            	entities.remove(j);
				            }
		    			}
		            }
					int dx=0;
					int dy=0;
					int tabMap[][]= map.getTabMap();
					// collision avec le decor
					/*for(int y=0;y<24;y++)
					{	
						for(int x=0; x<32;x++)
						{
							if(tabMap[y][x]==1 || tabMap[y][x]==2)
							{
								Rectangle HitBox = new Rectangle(dx,dy,25,25);
								if(testCollision(hitBoxEgg, HitBox))
								{
									entities.remove(i);
									break;
								}
							}
							dx=dx+25;
						}
						dy=dy+25;
				    	dx=0;
					}*/
					}
				}
				
			
				
	}
	
	public boolean testCollision(Rectangle x, Rectangle y)
	{
		if(x.intersects(y))
		{
			System.out.print("collision");
			return true;
		}
		return false;
	}
	
	public void actionPerformed(ActionEvent event) {
        for (int i = 0; i <entities.size(); ++i ) {
        	if (entities.get(i) instanceof Egg) {
        		if (entities.get(i).isVisible())
                	entities.get(i).move();
                else
                	entities.remove(i);
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
