package model.entities;

abstract class Enemy extends Entity {
	private int resistance = 3;
	
	public Enemy(int x, int y, int width, int height) {
		super(x,y,width, height);
	}
}