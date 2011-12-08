import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JButton;

public class GameController implements KeyListener, ActionListener {
	private GameView angryView;
	private GameViewMenu angryMenu;
	private GameModel angryModel;
	private GameFrame angryFrame;
	private JButton startButton;
	
	private ArrayList<Pigeon> pigeons;
	private ArrayList<Pig> pigs;
	private ArrayList<Egg> eggs;
	
	public GameController() {
		angryModel = new GameModel();
		pigeons = angryModel.getPigeonList();
		pigs = angryModel.getPigList();
		
		angryFrame = new GameFrame(this, pigeons, pigs);
		angryMenu = angryFrame.getAngryViewMenu();
		angryView = angryFrame.getAngryView();
		
		startButton = angryMenu.getStartButton();
	
		angryModel.setDisplay(angryView);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		Pigeon p = (Pigeon) pigeons.get(0);
		
		switch (e.getKeyCode()) {
		case KeyEvent.VK_RIGHT:
			p.moveRight();
			break;
		case KeyEvent.VK_LEFT:
			p.moveLeft();
			break;
		case KeyEvent.VK_UP:
			p.moveUp();
			break;
		case KeyEvent.VK_DOWN:
			p.moveDown();
			break;
		case KeyEvent.VK_SPACE:
			p.fire();	
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
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals("Start game"))
		{
			angryFrame.setGame();
		}
	}


}


