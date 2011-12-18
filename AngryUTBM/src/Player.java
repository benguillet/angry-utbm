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
		finished(1, "easy");
		finished(2, "easy");
		finished(3, "easy");
		normal = new ArrayList<Integer>();
		finished(1, "normal");
		finished(8, "normal");
		hard = new ArrayList<Integer>();
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
		String result = "Name : " + name + "\n" + "Score : " + score + "\n"
				+ "Easy : " + easy.toString() + "\n" + "Normal : "
				+ normal.toString() + "\n" + "Hard : " + hard.toString();
		return result;
	}

	public boolean isFinished(int level, String difficulty) {
		if (difficulty.equals("easy")) {
			return easy.contains(level);
		} else if (difficulty.equals("normal")) {
			return normal.contains(level);
		} else {
			return hard.contains(level);
		}
	}

	public void finished(int level, String difficulty) {
		if (difficulty.equals("easy") && !(easy.contains(level))) {
			easy.add(level);
		} else if (difficulty.equals("normal") && !(normal.contains(level))) {
			normal.add(level);
		} else {
			hard.add(level);
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
