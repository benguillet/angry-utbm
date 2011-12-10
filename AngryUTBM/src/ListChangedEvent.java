import java.util.ArrayList;
import java.util.EventObject;


@SuppressWarnings("serial")
public class ListChangedEvent extends EventObject {
	public ArrayList<Entity> entities;
	
	public ListChangedEvent(Object source, ArrayList<Entity> entities) {
		super(source);
		
		this.entities = entities;
	}
	
	public ArrayList<Entity> getEntityList() {
		return entities;
	}
}
