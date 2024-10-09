package pokemon_project;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
	protected Coin coinRequired;
	protected Player player;
	protected String gameMode;
	protected Pokemon appearPokemon1; //3 wild Pokemon appear in the beginning
	protected Pokemon appearPokemon2; 
	protected Pokemon appearPokemon3;
	public static Pokemon ownPokemon; //1/3 Pokemon caught from the appearance
	protected ArrayList<Pokemon> GameCharacter;
	public int TotalScore;
	
	
	public Game() {
		this.gameMode = "Battle and Catch";
		this.GameCharacter = new ArrayList<>();
		
		Pokemon Charizard = new Fire("Charizard","Fire", "Blast burn", "Fire Spin", 120);

		Pokemon Talonflame = new Fire("Talonflame","Fire", "Flame charge", "Brave bird", 130);
		
		Pokemon Articuno = new Ice("Articuno","Ice","Ice Symbol", "Freezing wind",120);
		
		Pokemon Aurorus = new Ice("Aurorus","Ice", "Blizzard burn", "Frost wall", 160);
		
		Pokemon Bulbasaur = new Grass("Bulbasaur","Grass", "Power whip", "Vine whip", 100);
		
		Pokemon Leafeon = new Grass("Leafeon","Grass","Grass knot", "Leaf guard", 110);
		
		Pokemon Pikachu = new Electric("Pikachu","Electric", "Wild charge", "Thunder rock", 70);
		
		Pokemon Zapdos = new Electric("Zapdos", "Electric", "Thunder snipe", "Drill peck", 110);
		
	    Pokemon Vaporeon = new Water("Vaporeon", "Water", "Water Shroud", "Hydro pump", 110);
		
		Pokemon Lapras = new Water("Lapras","Water", "Hail", "Hydro pump", 110);

		GameCharacter.add(Charizard);
		GameCharacter.add(Talonflame);
		GameCharacter.add(Articuno);
		GameCharacter.add(Aurorus);
		GameCharacter.add(Bulbasaur);
		GameCharacter.add(Leafeon);
		GameCharacter.add(Pikachu);
		GameCharacter.add(Zapdos);
		GameCharacter.add(Vaporeon);
		GameCharacter.add(Lapras);
	}
	public void startGame() {
		Player player = new Player();
		
		Coin coinRequired = new Coin(1);
		while (true) {
			System.out.println("Insert 1 coin to start game (enter amount): ");
			int choice = playerInput();
			if (choice < coinRequired.getQuantity()) {
				System.out.println("Insufficient coins. Please insert " + coinRequired.getQuantity() + " coin(s) to start the game.");
			}else if (choice > coinRequired.getQuantity()) {
				System.out.println("Extra coins inserted! Coin will be rejected.");
				break;
			}else {
	            System.out.println("Coins inserted successfully!");
	            break;
			}
		}
		player.getPlayerNumber();
		BattlePokemon battle = new BattlePokemon();
		System.out.println("Welcome to Pokemon Gaole 'Battle and Catch'!");
		appearPokemon1 = generateRandomPokemon();
		appearPokemon2 = generateRandomPokemon();
		appearPokemon3 = generateRandomPokemon();
		displayPokemonAppeared();
		catchOnetoOwn();		
		battle.startBattle();
    	player.setScore(battle.TotalScore);
		System.out.println(player.tellPlayerInfo());
		player.saveTopScoresToFile();
		player.displayTopScores();
	}
	public void displayPokemonAppeared() {
		System.out.println("You may encounter these Pokemon?");
		if (appearPokemon1 != null) {
			System.out.println("1. " + appearPokemon1.toShowPokemonInfo());
		}
		if (appearPokemon2 != null) {
			System.out.println("2. " + appearPokemon2.toShowPokemonInfo());
		}
		if (appearPokemon3 != null) {
			System.out.println("3. " + appearPokemon3.toShowPokemonInfo());
		}
	}
	protected Pokemon generateRandomPokemon() {
		
        if (GameCharacter.isEmpty()) {
            System.out.println("Error: List is empty.");
            return null; 
        }

        Random random = new Random();
        int randomIndex = random.nextInt(GameCharacter.size());
        Pokemon randomPokemon = GameCharacter.get(randomIndex);
        if (true) {
        	GameCharacter.remove(randomIndex);
        	GameCharacter.remove(ownPokemon);
        }
        return randomPokemon;
    }
	private void catchOnetoOwn() {
	    while (true) {
	        System.out.println("Choose a Pokemon to catch (1-3): ");
	        int choice = playerInput();

	        if (choice >= 1 && choice <= 3) {
	            switch (choice) {
	                case 1:
	                    ownPokemon = appearPokemon1;
	                    System.out.println(ownPokemon.getPokemonName() + " successfully caught!");
	                    break;
	                case 2:
	                    ownPokemon = appearPokemon2;
	                    System.out.println(ownPokemon.getPokemonName() + " successfully caught!");
	                    break;
	                case 3:
	                    ownPokemon = appearPokemon3;
	                    System.out.println(ownPokemon.getPokemonName() + " successfully caught!");
	                    break;
	                default:
	                    System.out.println("Invalid choice.");
	                    break;
	            }
	            System.out.println("You caught: " + ownPokemon.toShowPokemonInfo());
	            break;
	        } else if (choice > 3) {
	            System.out.println("Invalid choice, please choose again.");
	        }
	    }
	}

    public Pokemon getOwnPokemon() {
    	return ownPokemon;
    }
    protected int playerInput() {
        @SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        return choice;
    }

    public int getTotalScore() {
    	return TotalScore;
    }
    public void calculateScore(int hp1, int hp2) {
    	TotalScore = hp1 + hp2;
    }
}
