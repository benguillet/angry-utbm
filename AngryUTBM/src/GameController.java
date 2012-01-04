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
	
	private Pigeon p;
	
	private ArrayList<Entity> entities;
	
	public GameController(GameFrame Frame){
		angryFrame = Frame;
		angryModel = Frame.getAngryModel();
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {		
		switch (e.getKeyCode()) {
		case KeyEvent.VK_RIGHT:
			if(p.getFlyingState())
				p.moveRight();
			break;
		case KeyEvent.VK_LEFT:
			if(p.getFlyingState())
				p.moveLeft();
			break;
		case KeyEvent.VK_UP:
			if(p.getFlyingState())
				p.moveUp();
			break;
		case KeyEvent.VK_DOWN:
			if(p.getFlyingState())
				p.moveDown();
			break;
		case KeyEvent.VK_M:
			p.lancer();
			break;
		case KeyEvent.VK_S:
			p.volStationaire();
			break;
		case KeyEvent.VK_SPACE:
			//p.fire();	
			angryModel.addEgg();
			break;
		case KeyEvent.VK_ESCAPE:
			angryFrame.setMenu();
			break;
		case KeyEvent.VK_R:
			p.reload();
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
		p = angryModel.getCurrentPigeon();
	}
}


