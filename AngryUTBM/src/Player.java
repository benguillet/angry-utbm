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
	private ArrayList<Integer> medium;
	private ArrayList<Integer> hard;
	private ArrayList<Integer> extreme;

	public Player(String name) {

		this.name = name;

		easy = new ArrayList<Integer>();
		medium = new ArrayList<Integer>();
		hard = new ArrayList<Integer>();
		extreme = new ArrayList<Integer>();
		score = 0;
		this.save();
	}

	public static Player loadFromFile(String name) {
		try {
			FileInputStream fichier = new FileInputStream("save/" + name
					+ ".save");
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
			file.delete();
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
		String result = "Name : " + name + "\n" + "Score : " + score + "\n" +
				"Easy : " + easy.toString() + "\n" +
				"Medium : " + medium.toString() + "\n" + 
				"Hard : " + hard.toString() +
				"Extreme : " + extreme.toString();
		return result;
	}

	public boolean isFinished(int level, String difficulty) {
		if (difficulty.equals("easy")) {
			return easy.contains(level);
		} else if (difficulty.equals("normal")) {
			return medium.contains(level);
		} else if (difficulty.equals("hard")){
			return hard.contains(level);
		} else {
			return extreme.contains(level);
		}
	}

	public void finished(int level, String difficulty) {
		if (difficulty.equals("easy") && !(easy.contains(level))) {
			easy.add(level);
		} else if (difficulty.equals("normal") && !(medium.contains(level))) {
			medium.add(level);
		} else if (difficulty.equals("hard") && !(hard.contains(level))) {
			hard.add(level);
		} else if (difficulty.equals("extreme") && !(extreme.contains(level))) {
			extreme.add(level);
		}
	}
	
	public String getName() {
		return name;
	}
	
	public int getScore() {
		return score;
	}
	
	public int addToScore(int add) {
		score = score + add;
		return score;
	}
}
