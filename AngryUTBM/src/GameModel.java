import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;


public class GameModel implements ActionListener {
	private GameView display;
	private Level map;
	private ArrayList<Pigeon> pigeons;
	private ArrayList<Pig> pigs;
	private ArrayList<Egg> eggs;
	private Timer timer;
	
	public GameModel() {
		map = new Level();
		pigeons = new ArrayList<Pigeon>();
		pigeons.add(new Pigeon());
		eggs = pigeons.get(0).getEggs();
		pigs = new ArrayList<Pig>();
		pigs.add(new Pig());
		pigs.get(0).start();
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

	public ArrayList<Pig> getPigList() {
		return pigs;
	}

	public ArrayList<Pigeon> getPigeonList() {
		return pigeons;
	}
	
	public ArrayList<Egg> getEggList() {
		return eggs;
	}
	
	public void actionPerformed(ActionEvent event) {
        for (int i = 0; i < pigeons.size(); ++i ) {
        	ArrayList<Egg> eggs = pigeons.get(i).getEggs();
        	
        	for (int j = 0; j < eggs.size(); ++j ) {
        		Egg e = (Egg) eggs.get(j);
        		if (e.isVisible())
                	e.move();
                else
                	eggs.remove(i);
        	}
        }
        
    }
	
}
