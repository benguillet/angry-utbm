import java.util.ArrayList;


public class EnemyThread extends Thread {
	private ArrayList<Entity> entities;
	
	public EnemyThread(ArrayList<Entity> entities) {
		this.entities = entities;
	}
	
	public void run(){
		while(true) {
			for(Entity entity : entities) {
				if (entity instanceof Pig) {
					entity.move();
				}
			}
			
			try {
				Thread.sleep(15);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
