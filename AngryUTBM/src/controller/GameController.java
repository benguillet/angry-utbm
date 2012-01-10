package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import main.GameFrame;
import model.GameModel;
import model.ListChangedEvent;
import model.ListListener;
import model.entities.Bird;
import model.entities.Entity;
import model.entities.Sparrow;

public class GameController implements KeyListener, ListListener, MouseListener,MouseMotionListener{
	
	//private GameView angryView;
	private GameModel angryModel;
	private GameFrame angryFrame;
	
	private Bird currentBird;
	private boolean isBirdPicked = false;
	private int pickX;
	private int pickY;
	
	private ArrayList<Entity> entities;
	
	public GameController(GameFrame Frame){
		angryFrame = Frame;
		angryModel = Frame.getAngryModel();
	}
	
	@Override
	public void keyPressed(KeyEvent e) {	
		switch (e.getKeyCode()) {
			case KeyEvent.VK_RIGHT:
				if(currentBird.isFlying())
					currentBird.moveRight();
				break;
			case KeyEvent.VK_LEFT:
				if(currentBird.isFlying())
					currentBird.moveLeft();
				break;
			case KeyEvent.VK_UP:
				if(!currentBird.isFlying())
					currentBird.setAngle(currentBird.getAngle()+0.1);
				break;
			case KeyEvent.VK_DOWN:
				if(!currentBird.isFlying())
					currentBird.setAngle(currentBird.getAngle()-0.1);
				break;
			case KeyEvent.VK_M:
				currentBird.launch();
				break;
			case KeyEvent.VK_S:
				// On interdit le vol stationaire pour les moineaux
				if(!(currentBird instanceof Sparrow))
					currentBird.volStationaire();
				break;
			case KeyEvent.VK_SPACE:
				//p.fire();	
				if(currentBird.isFlying())
					angryModel.addEgg();
				break;
			case KeyEvent.VK_ESCAPE:
				angryFrame.setMenuLevel();
				break;
			// Plus de rechargement possible (trop facile sinon)	
			/*case KeyEvent.VK_R:
				currentBird.reload();
				break;*/
			default:
				System.out.println("je gere pas cette touche ! Blaireau !");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void listChanged(ListChangedEvent event) {
		this.entities = event.getEntityList();
		this.currentBird = event.getCurrentBird();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(!currentBird.isFlying())
		{
			if(e.getX()>= currentBird.getPosition().getX() && e.getX() <= currentBird.getPosition().getX()+currentBird.getImageWidth())
				if(e.getY()>= currentBird.getPosition().getY() && e.getY() <= currentBird.getPosition().getY()+currentBird.getImageHeight())
				{
					isBirdPicked = true;
					pickX = e.getX();
					pickY = e.getY();
				}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if(isBirdPicked){
			double deltaX = currentBird.getStartLocationX() - e.getX();
			double deltaY = currentBird.getStartLocationY() - e.getY();
			float speed = (float)Math.sqrt((deltaX*deltaX)+(deltaY*deltaY));
			currentBird.setAngle(-Math.atan(deltaY/deltaX));
			currentBird.setSpeed(speed);
			if(deltaX > 0)
				currentBird.launch();
			else{
				currentBird.setPosition(currentBird.getStartLocationX(), currentBird.getStartLocationY());
			}
		}
		isBirdPicked = false;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		if(isBirdPicked)
		{
			double deltaX = currentBird.getStartLocationX() - e.getX();
			double deltaY = currentBird.getStartLocationY() - e.getY();
			float speed = (float)Math.sqrt((deltaX*deltaX)+(deltaY*deltaY));
			currentBird.setAngle(-Math.atan(deltaY/deltaX));
			currentBird.setSpeed(speed);
			currentBird.setPosition(e.getX()-currentBird.getImageWidth()/2, e.getY()-currentBird.getImageHeight()/2);
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	}
}


