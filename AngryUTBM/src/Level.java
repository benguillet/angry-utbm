import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;


public class Level {
	private String backgroundImagePath = "res/images/background.png";
	private Image image;
	private int tabMap[][];
	private int tabMapSizeX = 47;
	private int tabMapSizeY = 22;
	private Rectangle tabCollision[][];
	private String grassImagePath = "res/images/grass.png";
	private Image grass;
	private String blockImagePath = "res/images/block.png";
	private Image block;
	private boolean levelFinish;
	private ArrayList<Entity> entities;
	
	public Level() {
	    ImageIcon ii = new ImageIcon(backgroundImagePath);
	    image = ii.getImage();
	    
    }
	
	public Level(String fichierMapPath) {
		ImageIcon ii = new ImageIcon(backgroundImagePath);
	    image = ii.getImage();
	    ImageIcon gr = new ImageIcon(grassImagePath);
	    grass = gr.getImage();
	    ImageIcon bl = new ImageIcon(blockImagePath);
	    block = bl.getImage();
	    entities = new ArrayList<Entity>();
	    
	    try
	    {
			FileInputStream ips=new FileInputStream(fichierMapPath); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			ligne = br.readLine();
			while(!ligne.equals("Map")) {
				int X, Y;
				if(ligne.equals("Pig")) {
					ligne = br.readLine();
					X = Integer.parseInt(ligne);
					ligne = br.readLine();
					Y = Integer.parseInt(ligne);
					entities.add(new Pig(X,Y));
				}
				if(ligne.equals("Pigeon")) {
					entities.add(new Pigeon());
				}
				ligne = br.readLine();
			}
			
			tabMap = new int[tabMapSizeY][tabMapSizeX];
			
			for(int i=0;i<tabMapSizeY;i++)
			{	
				ligne = br.readLine();
				
				for(int j=0; j<tabMapSizeX;j++)
				{
					
					char car = ligne.charAt(j);
					String st = String.valueOf(car);
					tabMap[i][j]= Integer.parseInt(st);
				}
			}
				
	    }
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
	    
	}
	
	public Image getImage() {
        return image;
    }
	
	public Image getGrass(){
		return grass;
	}
	
	public Image getBlock(){
		return block;
	}
	
	public int[][] getTabMap(){
		return tabMap;
	
	}
	public int getTabMapSizeX(){
		return tabMapSizeX;
	}
	public int getTabMapSizeY(){
		return tabMapSizeY;
	}	
	
	public ArrayList<Entity> getEntityList() {
		return entities;
	}
}
