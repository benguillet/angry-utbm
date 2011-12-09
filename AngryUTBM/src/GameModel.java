import java.util.ArrayList;
import java.util.List;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;


public class GameModel implements ActionListener {
	private GameView display;
	private Level map;
	private ArrayList<Entity> entities;
	private Pigeon pigeonCurrent;
	
	//private ArrayList<Pigeon> pigeons;
	//private ArrayList<Pig> pigs;
	//private ArrayList<Egg> eggs;
	private Timer timer;
	
	public GameModel() {
		map = new Level();
		entities = new ArrayList<Entity>();
		pigeonCurrent = new Pigeon();
		entities.add(pigeonCurrent);
		entities.add(new Pig());		
		for (int i = 0; i < entities.size(); ++i) {
			if (entities.get(i) instanceof Pig)
				entities.get(i).start();
		}

		//eggs = pigeons.get(0).getEggs();
		//pigs.get(0).start();
		timer = new Timer(5, this);
		timer.start();
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

/*	public ArrayList<Pig> getPigList() {
		return pigs;
	}

	public ArrayList<Pigeon> getPigeonList() {
		return pigeons;
	}
	
	public ArrayList<Egg> getEggList() {
		return eggs;
	}*/
	
	public ArrayList<Entity> getEntityList() {
		return entities;
	}
	
	public void addEgg() {
		entities.add(new Egg(pigeonCurrent.getPosition().getX(), pigeonCurrent.getPosition().getY()));
	}
	
	/*public boolean checkCollision()
	{
		for(int j = 0; j < pigeons.size() ; j++)
		{
			for(int k = 0 ; k < pigs.size();k++)
			{
				ArrayList<Egg> eggs = pigeons.get(j).getEggs();
				Pig pigTest = pigs.get(k);
				
				for (int i = 0; i < eggs.size(); ++i ) {
		            Egg e = (Egg) eggs.get(i);
		            Rectangle hitBoxEgg = e.getBound();
		            Rectangle hitBoxPig= pigTest.getBound();
		            if(testCollision(hitBoxEgg,hitBoxPig))
		            {
		            	eggs.remove(i);
		            }
				}
	        }
		}
		
		return false;
	}
	
	public boolean testCollision(Rectangle x, Rectangle y)
	{
		if(x.intersects(y))
		{
			System.out.print("collision");
			return true;
		}
		return false;
	}*/
	
	public void actionPerformed(ActionEvent event) {
        for (int i = 0; i <entities.size(); ++i ) {
        	if (entities.get(i) instanceof Egg) {
        		if (entities.get(i).isVisible())
                	entities.get(i).move();
                else
                	entities.remove(i);
        	}
        }
      //checkCollision();
    }
}
