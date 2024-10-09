package pokemon_project;
import java.util.*;
import java.io.*;

public class Player {
    private int playerNumber;
    private int Score;

    public Player() {
        this.playerNumber = generateRandomPlayerNumber();
        this.Score = 0;
    }
    private int generateRandomPlayerNumber() {
        Random random = new Random();
        return random.nextInt(90000) + 10000; // Generates a random number between 10000 and 99999
    }

    public int getPlayerNumber() {
        System.out.println("Player's Number: " + playerNumber);
        return playerNumber;
    }
	public void setScore(int Score) {
		this.Score = Score;
	}
	public void saveTopScoresToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("scores.txt", true))) {
            // Append the player's number and score to the file
            writer.println(playerNumber + " - " + Score);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
    public void displayTopScores() {
        try (Scanner scanner = new Scanner(new File("scores.txt"))) {
            List<String> scoresList = new ArrayList<>();

            // Read all scores into a list
            while (scanner.hasNextLine()) {
                scoresList.add(scanner.nextLine());
            }

            // Sort the list in descending order based on scores
            scoresList.sort((score1, score2) -> {
                int value1 = Integer.parseInt(score1.split(" - ")[1].trim());
                int value2 = Integer.parseInt(score2.split(" - ")[1].trim());
                return Integer.compare(value2, value1);
            });

            // Print the sorted scores
            System.out.println("Top 5 Scores:");
            System.out.println("ID NUMBER||SCORE");
            int count = 0;
            for (String score : scoresList) {
                if (count < 5) {
                    System.out.println(score);
                    count++;
                } else {
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
	//This method returns a string containing player information
    public String tellPlayerInfo() {
        return "Player Number: " + playerNumber + "\nScore: " + Score;
    }
}