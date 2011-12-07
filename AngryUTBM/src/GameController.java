import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameController implements KeyListener {
	private GameView angryView;
	private GameFrame angryFrame;
	private Pigeon pige1;
	
	public GameController() {
		angryFrame = new GameFrame(this);
		angryView = angryFrame.getAngryView();
		pige1 = angryView.getPige1();
		
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
			default:
				System.out.println("je gère pas cette touche ! Connard !");		
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


}


