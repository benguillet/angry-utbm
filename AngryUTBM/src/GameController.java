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
	private JButton lvl01Button;
	private JButton lvl02Button;
	private Pigeon p;
	
	private ArrayList<Entity> entities;
	
	public GameController(GameFrame Frame) {
		angryFrame = Frame;
		angryModel = Frame.getAngryModel();
		angryMenu = Frame.getAngryViewMenu();
		angryView = Frame.getAngryView();
		
		entities = angryModel.getEntityList();
		
		for (int i = 0; i < entities.size(); ++i) {
			if (entities.get(i) instanceof Pigeon)
				p = (Pigeon) entities.get(i);
		}
		
		startButton = angryMenu.getStartButton();
		startButton.addActionListener(this);
		
		lvl01Button = angryMenu.getLvl01Button();
		lvl01Button.addActionListener(this);
		
		lvl02Button = angryMenu.getLvl02Button();
		lvl02Button.addActionListener(this);

	
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
			//angryFrame.setGame();
			startButton.setVisible(false);
			lvl01Button.setVisible(true);
			lvl02Button.setVisible(true);
			System.out.println("bite");
		}
		
		if (e.getSource().equals(lvl01Button))
		{
			angryView.setMap(new Level("res/maps/lvl01.txt"));
			angryFrame.setGame();
		}
		
		if (e.getSource().equals(lvl02Button))
		{
			angryView.setMap(new Level("res/maps/lvl02.txt"));
			angryFrame.setGame();
		}
		
	}


}


