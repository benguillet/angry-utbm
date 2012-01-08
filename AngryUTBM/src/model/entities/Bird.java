package model.entities;
import java.awt.Dimension;
import java.util.ArrayList;

public abstract class Bird extends Entity {
	protected short flyingTime;
	protected int eggLeft;
	protected ArrayList<Egg> eggs;
	protected boolean isFlying = false;
	protected boolean isMoving;
	private double time;
	private double angle;
	protected Dimension frameSize;
	private double accelX;
	private double accelY;
	protected int startLocationX;
	protected int startLocationY;
	private long lastTime;
	private long flyingTimeLeft;
	
	public Bird(int x, int y, int width, int height) {
		super(x,y,width,height);
		isMoving = false;
		time = 0.1;
		angle = 45;
		accelX = 0;
		startLocationX = x;
		startLocationY = y;
		accelY = 9.81;
		flyingTimeLeft = 10000;
	}
	
	public Bird(int width, int height) {
		super(40,400,width,height);
		isMoving = false;
		time = 0.1;
		angle = 45;
		accelX = 0;
		startLocationX = 40;
		startLocationY = 400;
		accelY = 9.81;
		flyingTimeLeft = 10000;
	}
	
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
	
    public void move() {
    	if(isMoving)
    	{
    		
	    	hitBox.x = (int) Math.round(speed*Math.cos(angle)*time+0.5*accelX*time*time+startLocationX);
	    	hitBox.y = (int) Math.round(0.5*accelY*time*time-Math.sin(angle)*speed*time+startLocationY);
	    	time+=0.1;
	    	if (hitBox.y > (int) frameSize.getHeight() || hitBox.y > (int) frameSize.getWidth())
				visible = false;
    	}
    	if(isFlying) {
	    	long currentTime = System.currentTimeMillis();
	    	flyingTimeLeft -= (currentTime - lastTime);
	    	lastTime = currentTime;
	    	if(flyingTimeLeft <= 0)
	    		visible = false;
    	}
    }
    
    public void launch(){
    	isMoving = true;
    	isFlying = true;
    	lastTime = System.currentTimeMillis();
    }
    
	public void moveRight() {
		accelX+=0.1;
    }
    
    public void moveLeft() {
    	accelX-=0.1;
    }
    
	public abstract void moveUp();
	public abstract void moveDown();
	public abstract void reload();
	
	public long getFlyingTimeLeft() {
		return flyingTimeLeft;
	}
}
