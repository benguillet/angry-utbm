package model;

import view.GameView;
import model.entities.Bird;
import model.entities.Block;
import model.entities.Egg;
import model.entities.Entity;
import model.entities.EntityThread;
import model.entities.Grass;
import model.entities.Pig;

import java.util.ArrayList;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.event.EventListenerList;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;


public class GameModel implements ActionListener {
	private GameView angryView;
	private Level level;
	private ArrayList<Player> players;
	private ArrayList<Entity> entities;
	private Bird currentBird;
	private Timer timer;
	private EntityThread entityThread;
	private EventListenerList listeners;
	private Player currentPlayer;
	private String difficulty;
	private int currentLevel;
	private int currentHighestScore;
	
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
			e.printStackTrace();
		}
		
		timer = new Timer(5, this);
		timer.start();
		
		listeners = new EventListenerList();
		
		entityThread = new EntityThread(entities);
		addListListener(entityThread);
	}

	public GameView getAngryView() {
		return angryView;
	}

	public void setAngryView(GameView display) {
		this.angryView = display;
	}

	public Level getMap() {
		return level;
	}
	
	public ArrayList<Player> getPlayers(){
		return players;
	}

	public void setMap(Level map) {
		this.level = map;
		entities = map.getEntityList();
		for(Entity e : entities) {
			if(e instanceof Bird) {
				currentBird = (Bird) e;
				break;
			}
		}
		fireListChanged();
		if (!entityThread.isAlive())
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
    		System.out.println("Plus d'oeufs ! Fail !");
	}
	
	public void checkCollision() {
		ArrayList<Entity> toRemove = new ArrayList<Entity>(); //On ne retire les entit�s de la liste qu'apr�s �tre sorti de la boucle
		for(Entity entity : entities) {
			int tabMap[][] = level.getTabMap();
			
			if(entity instanceof Egg) {
				Egg egg = (Egg) entity;
				Rectangle hitBoxEgg = egg.getHitBox();
				
				//Collisions oeuf/autre entity
				for(Entity entity2 : entities) {
					if(entity2 instanceof Pig) {
						Pig pig = (Pig) entity2;
						Rectangle hitBoxPig = pig.getHitBox();
						if(hitBoxPig.intersects(hitBoxEgg)) {
							toRemove.add(egg);
							toRemove.add(pig);
			            	boolean win = true;
			            	for (Entity entity3 : entities) {
			            		if (entity3 instanceof Pig && !toRemove.contains(entity3)) {
			            			win = false;
			            			break;
			            		}
			            	}
			            	if(win) {
			            		int score = 0;
			            		for (Entity entity3 : entities) {
				            		if (entity3 instanceof Bird)
				            			++score;
			            		}
			            		win(score);
			            	}
						}
					}
					if(entity2 instanceof Block){
						Block block= (Block) entity2;
						Rectangle hitBoxBlock = block.getHitBox();
						if(hitBoxBlock.intersects(hitBoxEgg)) {
							toRemove.add(egg);
							toRemove.add(block);
							}
					}
					if(entity2 instanceof Grass){
						Grass grass= (Grass) entity2;
						Rectangle hitBoxGrass = grass.getHitBox();
						if(hitBoxGrass.intersects(hitBoxEgg)) {
							toRemove.add(egg);
							}
					}
				}
			}
			
			if(entity instanceof Pig) {
				Pig pig = (Pig) entity;
				Rectangle hitBoxPig = pig.getHitBox();
				//Collisions cochon/d�cor
				for(Entity entity2 : entities) {
					if(entity2 instanceof Block)
					{
						Block block = (Block) entity2;
						Rectangle hitBoxBlock = entity2.getHitBox();
						if(hitBoxPig.intersects(hitBoxBlock))
							pig.changeDirection();
							
					}
				}
				//On v�rifie que le cochon ne va pas marcher sur du vide
				int casex = (hitBoxPig.x / level.getBlockSize());
				int casey = (hitBoxPig.y / level.getBlockSize());
				if(pig.goForward()) {
					if(tabMap[casey+1][casex+1] == 0)
						pig.changeDirection();
				} 
				else {
					if(tabMap[casey+1][casex] == 0)
						pig.changeDirection();
				} 
				
				//Collisions oiseaux/cochons
				for(Entity entity2 : entities) {
					if (entity2 instanceof Bird) {
						Bird bird = (Bird) entity2;
						Rectangle hitBoxBird =  bird.getHitBox();
						if(hitBoxBird.intersects(hitBoxPig)) {
							toRemove.add(pig);
							toRemove.add(bird);
							
			            	boolean win = true;
			            	for (Entity entity3 : entities) {
			            		if (entity3 instanceof Pig) {
			            			win = false;
			            			break;
			            		}
			            	}
			            	if(win) {
			            		int score = 0;
			            		for (Entity entity3 : entities) {
				            		if (entity3 instanceof Bird)
				            			++score;
			            		}
			            		win(score);
			            	}
			            	
		            		boolean lose = true;
		            		for (Entity entity3 : entities) {
		            			if (entity3 instanceof Bird && !toRemove.contains(entity3)) {
		            				currentBird = (Bird) entity3;
		            				lose = false;
		            				break;
		            			}
		            		}
		            		if(lose) {
		            			lose();
		            		}
						}
					}
				}
			}
			if(entity instanceof Bird)
			{
				Bird bird = (Bird) entity;
				Rectangle hitBoxPig = bird.getHitBox();
				//Collisions cochon/d�cor
				for(Entity entity2 : entities) {
					if(entity2 instanceof Block)
					{
						Block block = (Block) entity2;
						Rectangle hitBoxBlock = entity2.getHitBox();
						if(hitBoxPig.intersects(hitBoxBlock))
						{
							toRemove.add(bird);
							toRemove.add(block);
						}
					}
				}
				for (Entity entity3 : entities) {
        			if (entity3 instanceof Bird && !toRemove.contains(entity3)) {
        				currentBird = (Bird) entity3;
        				break;
        			}
				}
			}
		}
		for(Entity entity : toRemove) 
			entities.remove(entity);
					
	}
	
	public void actionPerformed(ActionEvent event) {
        for (int i = 0; i < entities.size(); ++i) {
        	if (entities.get(i) instanceof Egg) {
        		if (!entities.get(i).isVisible())
                	entities.remove(i);
        	}
    		if (entities.get(i) instanceof Bird) {
        		if (!entities.get(i).isVisible()) {
                	entities.remove(i);
            		boolean lose = true;
            		for (Entity entity : entities) {
            			if (entity instanceof Bird) {
            				currentBird = (Bird) entity;
            				lose = false;
            				break;
            			}
            		}
            		if(lose) {
            			lose();
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
	
	public void win(int score) {
		javax.swing.JOptionPane.showMessageDialog(null, "Bravo, tu as gagné ! Ton score est " + score);
		currentPlayer.finished(currentLevel, difficulty, score);
		Level lvl = new Level("res/maps/lvl0" + (currentLevel+1) + ".txt", difficulty);
		if (lvl.isLoaded()) {
			angryView.setMap(lvl);
			this.setMap(lvl);
			this.setCurrentLevel(currentLevel+1);
		}
		else {
			javax.swing.JOptionPane.showMessageDialog(null, "Il n'y a aucun fichier map correspondant à ce niveau, tu peux insulter les développeurs");
		}
	}
	
	public void lose() {
		System.out.println("La lose! Vous avez perdu!");
	}
	
	public String getDifficulty() {
		return difficulty;
	}
	
	public void setDifficulty(String dif) {
		difficulty = dif;
	}
	
	public void setCurrentPlayer(Player p) {
		currentPlayer = p;
	}
	
	public void setCurrentLevel(int l) {
		currentLevel = l;
	}
	
	public void setCurrentHighScore() {
		currentHighestScore = currentPlayer.getHighestScore(difficulty, currentLevel);
		angryView.setCurrentHighestScore(currentHighestScore);
	}
	
	public Bird getCurrentBird() {
		return currentBird;
	}
}
