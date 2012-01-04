import java.util.ArrayList;

abstract class Bird extends Entity {
	protected short flyingTime;
	protected int eggLeft;
	protected ArrayList<Egg> eggs;
	protected boolean isFlying = false;
	
	public int getEggLeft() {
		return eggLeft;
	}
	
	public void setEggLeft(int i) {
		this.eggLeft = i;
	}
	
	public abstract void volStationaire();
	
	public boolean isFlying() {
		return isFlying;
	}
	
	public abstract void moveUp();
	public abstract void moveDown();
	public abstract void moveLeft();
	public abstract void moveRight();
	
	public abstract void launch();
	public abstract void reload();
}
