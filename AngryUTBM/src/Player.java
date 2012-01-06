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
	
	// Score par niveau
	private ArrayList<Integer> scoreEasy;
	private ArrayList<Integer> scoreMedium;
	private ArrayList<Integer> scoreHard;
	private ArrayList<Integer> scoreExtreme;
	
	private ArrayList<Integer> easy;
	private ArrayList<Integer> medium;
	private ArrayList<Integer> hard;
	private ArrayList<Integer> extreme;
	
	private int levelNumber;

	public Player(String name) {

		this.name = name;

		easy = new ArrayList<Integer>();
		medium = new ArrayList<Integer>();
		hard = new ArrayList<Integer>();
		extreme = new ArrayList<Integer>();
		
		scoreEasy = new ArrayList<Integer>();
		scoreMedium = new ArrayList<Integer>();
		scoreHard = new ArrayList<Integer>();
		scoreExtreme = new ArrayList<Integer>();
		
		
		// Permet de créer des listes de la bonne taille et ainsi d'éviter les OutOfBoundExceptions
		for (int i = 0; i < LevelNumber.getLevelNumber(); ++i) {
			scoreEasy.add(0);
			scoreMedium.add(0);
			scoreHard.add(0);
			scoreExtreme.add(0);
		}
		
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

	/*public String toString() {
		String result = "Name : " + name + "\n" + "Score : " + score + "\n" +
				"Easy : " + easy.toString() + "\n" +
				"Medium : " + medium.toString() + "\n" + 
				"Hard : " + hard.toString() +
				"Extreme : " + extreme.toString();
		return result;
	}*/
	
	public String toString() {
		return name;
	}

	public boolean isFinished(int level, String difficulty) {
		if (difficulty.equals("easy")) {
			return easy.contains(level);
		} else if (difficulty.equals("normal")) {
			return medium.contains(level);
		} else if (difficulty.equals("hard")){
			return hard.contains(level);
		} else if (difficulty.equals("extreme")){
			return extreme.contains(level);
		}
		return false;
	}

	public void finished(int level, String difficulty, int score) {
		if (difficulty.equals("easy") && !(easy.contains(level))) {
			easy.add(level);
			// l'index des levels de scoreEasy commence à 0
			scoreEasy.set(level-1, score);
		} else if (difficulty.equals("normal") && !(medium.contains(level))) {
			medium.add(level);
			scoreMedium.set(level-1, score);
		} else if (difficulty.equals("hard") && !(hard.contains(level))) {
			hard.add(level);
			scoreHard.set(level-1, score);
		} else if (difficulty.equals("extreme") && !(extreme.contains(level))) {
			extreme.add(level);
			scoreExtreme.set(level-1, score);
		}
		save();
	}
	
	public String getName() {
		return name;
	}
}
