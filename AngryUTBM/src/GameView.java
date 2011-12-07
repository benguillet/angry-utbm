import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GameView extends JPanel {
	private Pigeon pige1;
	private Level map;
	
	public GameView(GameController controller) {

        addKeyListener(controller);
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);

        map = new Level();
        pige1 = new Pigeon();
        
	}
	
	public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(map.getImage(), 0, 0, this);
        g2d.drawImage(pige1.getImage(), pige1.getPosition().getX(), pige1.getPosition().getY(), this);

        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

	public Pigeon getPige1() {
		return pige1;
	}

	public void setPige1(Pigeon pige1) {
		this.pige1 = pige1;
	}

	public Level getMap() {
		return map;
	}

	public void setMap(Level map) {
		this.map = map;
	}
	
}
