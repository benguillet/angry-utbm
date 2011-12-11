import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Player implements Serializable {
	private String name;
	private int score;
	private ArrayList<Integer> easy;
	private ArrayList<Integer> normal;
	private ArrayList<Integer> hard;

	public Player(String name) {
		this.name = name;
		easy = new ArrayList<Integer>();
		easy.add(1);
		easy.add(2);
		easy.add(3);
		normal = new ArrayList<Integer>();
		normal.add(4);
		normal.add(8);
		hard = new ArrayList<Integer>();
		score = 0;
		this.save();
	}

	public static Player loadFromFile(String name) {
		try {
			FileInputStream fichier = new FileInputStream("save/" + name + ".save");
			ObjectInputStream ois = new ObjectInputStream(fichier);
			Player player = (Player) ois.readObject();
			return player;
		} catch (java.io.IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void save() {
		try {

			File folder = new File("save/");
			folder.mkdir();
			File file = new File("save/" + name + ".save");
			file.createNewFile();
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(this);
			oos.flush();
			oos.close();
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}

	}
	
	public String toString() {
		String result = "Name : " + name + "\n" +
	                    "Score : " + score + "\n" +
	                    "Easy : " + easy.toString() +
	                    "Normal : " + normal.toString() +
	                    "Hard : " + hard.toString();
		return result;
	}

}
