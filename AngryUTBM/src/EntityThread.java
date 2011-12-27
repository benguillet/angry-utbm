import java.util.ArrayList;


public class EntityThread extends Thread {
	private ArrayList<Entity> entities;
	
	public EntityThread(ArrayList<Entity> entities) {
		this.entities = entities;
	}
	
	public void run(){
		while(true) {
			for(Entity entity : entities) {
				entity.move();
			}
			
			try {
				Thread.sleep(15);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
