import java.util.ArrayList;

public interface Bird extends Entity {
	public short flyingTime = 0;
	public short eggLeft = 0;
	public ArrayList<Entity> eggList = null;
}
