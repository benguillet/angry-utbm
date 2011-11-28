import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class GameController implements KeyListener {
	
	@Override
	public void keyPressed(KeyEvent e) {	
		switch (e.getKeyCode()) {
			case KeyEvent.VK_RIGHT:
				System.out.println("j'vais à droiteeeeeeeee");
				break;
			case KeyEvent.VK_LEFT:
				System.out.println("j'vais à gauche");
				break;
			case KeyEvent.VK_UP:
				System.out.println("j'vais à hauuut");
				break;
			case KeyEvent.VK_DOWN:
				System.out.println("j'vais en baaaaas");
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
