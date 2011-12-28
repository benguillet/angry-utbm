import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Pigeon extends Bird {
	private final int PIGEON_SIZE = 58;
	private double accel = 9.81;
	private double time = 0.1;
	private boolean isMoving= false;
	private double angle = 45;
	private Dimension frameSize;
	private int startLocationX = 40;
	private int startLocationY = 400;
	private double accelX = 0;
	private boolean isFlying = false;
	
	public Pigeon() {
	    imagePath = "res/images/pigeon.png";
    	ImageIcon ii = new ImageIcon(imagePath);
	    image = ii.getImage();
	    position = new Point(startLocationX, startLocationY);
	    speed = 100;
	    eggs = new ArrayList<Egg>();
	    eggLeft = 3;
	    frameSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
	}

    public void move() {
    	if(isMoving)
    	{
	    	position.setLocation(speed*Math.cos(angle)*time+0.5*accelX*time*time+startLocationX,0.5*accel*time*time-Math.sin(angle)*speed*time+startLocationY);
	    	time+=0.1;
	    	if (position.getY() > (int) frameSize.getHeight() || position.getX() > (int) frameSize.getWidth())
				visible = false;
    	}
    }
    public void lancer(){
    	isMoving = true;
    	isFlying = true;
    }
    public boolean getFlyingState()
    {
    	return isFlying;
    }
    
	
	public void moveRight() {
		//position.setLocation(position.getX() + speed, position.getY());
		accelX+=0.1;
    }
    
    public void moveLeft() {
    	//position.setLocation(position.getX() - speed, position.getY());
    	accelX-=0.1;
    }
    
    public void moveUp() {
    	//position.setLocation(position.getX() ,position.getY() - speed);
    }
    
    public void moveDown() {
    	//position.setLocation(position.getX(), position.getY() + speed);
    }
    
    public void reload() {
    	eggLeft = 3;
    }
    
    public ArrayList<Egg> getEggs() {
    	return eggs;
    }
    
    
}
