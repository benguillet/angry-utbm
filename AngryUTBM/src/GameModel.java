
public class GameModel {
	private GameView display;
	private Level map;
	private Pigeon pig1;
	
	
	public GameModel() {
		
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

	public Pigeon getPig1() {
		return pig1;
	}

	public void setPig1(Pigeon pig1) {
		this.pig1 = pig1;
	}
	
}
