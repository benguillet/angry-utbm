import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;

public class GameController implements KeyListener, ActionListener {
	private GameView angryView;
	private GameViewMenu angryMenu;
	private GameFrame angryFrame;
	private Pigeon pige1;
	private JButton startButton;
	
	public GameController() {
		angryFrame = new GameFrame(this);
		angryMenu = angryFrame.getAngryViewMenu();
		angryView = angryFrame.getAngryView();
		pige1 = angryView.getPige1();
		startButton = angryMenu.getStartButton();
		
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_RIGHT:
				pige1.moveRight();
				angryView.repaint();
				break;
			case KeyEvent.VK_LEFT:
				pige1.moveLeft();
				angryView.repaint();
				break;
			case KeyEvent.VK_UP:
				pige1.moveUp();
				angryView.repaint();
				break;
			case KeyEvent.VK_DOWN:
				pige1.moveDown();
				angryView.repaint();
				break;
			case KeyEvent.VK_SPACE:
				pige1.fire();	
				angryView.repaint();
				break;
			case KeyEvent.VK_ESCAPE:
				angryFrame.setMenu();
				break;
			case KeyEvent.VK_R:
				pige1.reload();
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


