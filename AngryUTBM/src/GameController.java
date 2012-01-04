import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GameController implements KeyListener, ListListener{
	
	//private GameView angryView;
	private GameModel angryModel;
	private GameFrame angryFrame;
	
	private Bird currentBird;
	
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
			if(currentBird.isFlying())
				currentBird.moveUp();
			break;
		case KeyEvent.VK_DOWN:
			if(currentBird.isFlying())
				currentBird.moveDown();
			break;
		case KeyEvent.VK_M:
			currentBird.launch();
			break;
		case KeyEvent.VK_S:
			currentBird.volStationaire();
			break;
		case KeyEvent.VK_SPACE:
			//p.fire();	
			angryModel.addEgg();
			break;
		case KeyEvent.VK_ESCAPE:
			angryFrame.setMenu();
			break;
		case KeyEvent.VK_R:
			currentBird.reload();
			break;
		default:
			System.out.println("je gère pas cette touche ! Blaireau !");
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
}


