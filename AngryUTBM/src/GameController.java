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
	private Pigeon p;
	
	private ArrayList<Entity> entities;
	
	public GameController() {
		angryModel = new GameModel();
		entities = angryModel.getEntityList();
		
		for (int i = 0; i < entities.size(); ++i) {
			if (entities.get(i) instanceof Pigeon)
				p = (Pigeon) entities.get(i);
		}
		
		angryFrame = new GameFrame(this, entities);
		angryMenu = angryFrame.getAngryViewMenu();
		angryView = angryFrame.getAngryView();
		
		startButton = angryMenu.getStartButton();
		startButton.addActionListener(this);
	
		angryModel.setDisplay(angryView);
		angryModel.addListListener(angryView);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {		
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
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(startButton)) {
			angryFrame.setGame();
		}
	}


}


