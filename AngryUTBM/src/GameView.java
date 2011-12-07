import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import java.util.ArrayList;

import javax.swing.Timer;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GameView extends JPanel implements ActionListener {
	private Pigeon pige1;
	private Pig pig1;
	private Level map;
	private Timer timer;
	
	public GameView(GameController controller) {

        addKeyListener(controller);
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);

        timer = new Timer(5, this);
        map = new Level();
        pige1 = new Pigeon();
        pig1 = new Pig();
        
        timer.start();
	}
	
	public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(map.getImage(), 0, 0, this);
        g2d.drawImage(pige1.getImage(), pige1.getPosition().getX(), pige1.getPosition().getY(), this);
        g2d.drawImage(pig1.getImage(), pig1.getPosition().getX(), pig1.getPosition().getY(), this);

        
        ArrayList<Egg> eggs = pige1.getEggs();

        for (int i = 0; i < eggs.size(); ++i ) {
            Egg e = (Egg) eggs.get(i);
            g2d.drawImage(e.getImage(), e.getPosition().getX(), e.getPosition().getY(), this);
        }

        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

	public void actionPerformed(ActionEvent event) {
        ArrayList<Egg> eggs = pige1.getEggs();

        for (int i = 0; i < eggs.size(); ++i ) {
            Egg e = (Egg) eggs.get(i);
            if (e.isVisible())
            	e.move();
            else
            	eggs.remove(i);
        }
        
        repaint();
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
