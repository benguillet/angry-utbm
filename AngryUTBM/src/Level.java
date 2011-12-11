import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;


public class Level {
	private String backgroundImagePath = "res/images/background.png";
	private Image image;
	private int tabMap[][];
	private Rectangle tabCollision[][];
	private String grassImagePath = "res/images/grass.png";
	private Image grass;
	private String blockImagePath = "res/images/block.png";
	private Image block;
	private boolean levelFinish;

	
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
	    
	    try
	    {
			FileInputStream ips=new FileInputStream(fichierMapPath); 
			InputStreamReader ipsr=new InputStreamReader(ips);
			BufferedReader br=new BufferedReader(ipsr);
			String ligne;
			
			tabMap = new int[22][31];
						
			for(int i=0;i<22;i++)
			{	
				ligne = br.readLine();
				
				for(int j=0; j<31;j++)
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
	
}
