import java.util.ArrayList;

abstract class Bird extends Entity {
	protected short flyingTime;
	protected short eggLeft;
	protected ArrayList<Egg> eggs;
	
	public short getEggLeft() {
		return eggLeft;
	}
	
	public void setEggLeft(short eggLeft) {
		this.eggLeft = eggLeft;
	}
	
	public abstract void volStationaire();
}
