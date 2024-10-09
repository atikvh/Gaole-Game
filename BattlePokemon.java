package pokemon_project;

import java.util.ArrayList;

import java.util.Random;

public class BattlePokemon extends Game{
	private Pokemon ally1;
	private Pokemon ally2;
	private Pokemon opponent1;
	private Pokemon opponent2;
	private PokemonBall chosenBall;
	private ArrayList<Pokemon> BattleCharacter;
	private ArrayList<PokemonBall> Ball;
	private int pokemonCaughtCounter = 0;
	
	public BattlePokemon() {
		this.BattleCharacter = new ArrayList<>();
		this.Ball = new ArrayList<>();

		PokemonBall PokeBall = new PokeBall();
		PokemonBall GreatBall = new GreatBall();
		PokemonBall UltraBall = new UltraBall();
		PokemonBall MasterBall = new MasterBall();
		
		Ball.add(PokeBall);
		Ball.add(GreatBall);
		Ball.add(UltraBall);
		Ball.add(MasterBall);
		
		Pokemon Charizard = new Fire("Charizard" ,"Fire", "Blast burn", "Fire Spin", 120);
		Charizard.setSuitablePokeball(MasterBall);
		
		Pokemon Talonflame = new Fire("Talonflame", "Fire" ,"Flame charge", "Brave bird", 130);
		Talonflame.setSuitablePokeball(UltraBall);
		
		Pokemon Articuno = new Ice("Articuno","Ice" ,"Ice Symbol", "Freezing wind", 120);
		Articuno.setSuitablePokeball(PokeBall);
		
		Pokemon Aurorus = new Ice("Aurorus","Ice" ,"Blizzard burn", "Frost wall", 160);
		Aurorus.setSuitablePokeball(MasterBall);
		
		Pokemon Bulbasaur = new Grass("Bulbasaur","Grass" , "Power whip", "Vine whip", 100);
		Bulbasaur.setSuitablePokeball(MasterBall);
		
		Pokemon Leafeon = new Grass("Leafeon","Grass" ,"Grass knot", "Leaf guard", 110);
		Leafeon.setSuitablePokeball(GreatBall);
		
		Pokemon Pikachu = new Electric("Pikachu","Electric" , "Wild charge", "Thunder rock", 70);
		Pikachu.setSuitablePokeball(PokeBall);
		
		Pokemon Zapdos = new Electric("Zapdos","Electric" ,"Thunder snipe", "Drill peck", 110);
		Zapdos.setSuitablePokeball(GreatBall);
		
		Pokemon Vaporeon = new Water("Vaporeon","Water" ,"Water Shroud", "Hydro pump", 110);
		Vaporeon.setSuitablePokeball(UltraBall);
		
		Pokemon Lapras = new Water("Lapras","Water" ,"Hail", "Hydro pump", 110);
		Lapras.setSuitablePokeball(PokeBall);
		
		BattleCharacter.add(Charizard);
		BattleCharacter.add(Talonflame);
		BattleCharacter.add(Articuno);
		BattleCharacter.add(Aurorus);
		BattleCharacter.add(Bulbasaur);
		BattleCharacter.add(Leafeon);
		BattleCharacter.add(Pikachu);
		BattleCharacter.add(Zapdos);
		BattleCharacter.add(Vaporeon);
		BattleCharacter.add(Lapras);
		
	}
    public void startBattle() {
    	
        ally1 = ownPokemon;//caught from start
        coinRequired = new Coin(2);
		while (true) {
			System.out.println("Insert 2 coins to rent a second ally (enter amount): ");
			int insertedCoins = playerInput();
			if (insertedCoins < coinRequired.getQuantity()) {
				System.out.println("Insufficient coins. Please insert " + coinRequired.getQuantity() + " coins to rent a second ally.");
			}else if (insertedCoins > coinRequired.getQuantity()) {
				System.out.println("Extra coins inserted! Coin will be rejected.");
				break;
			}else {
	            System.out.println("Coins inserted successfully!");
	            break;
			}
		}
        ally2 = generateRandomPokemon();//optional, insert more coin to rent
        opponent1 = generateRandomPokemon();
        opponent2 = generateRandomPokemon();//one of the 3 Pokemon appeared in the game start -> not do
    	System.out.println("Two wild pokemon has appeared!");
        displayOpponentInfo();
        displayAllyInfo();
        roundBattle();
        
    }
    private void roundBattle() {
        for (int round = 1; round <= 4; round++) {
            System.out.println("## Round " + round);
            playerTurn(ally1, opponent1);
            wildPokemonTurn(opponent1, ally1);
            playerTurn(ally2, opponent2);
            wildPokemonTurn(opponent2, ally2);
            displayInfo();
            
           if (ally1.getPokemonHP() == 0) {
            	if(ally2.getPokemonHP() == 0) {
	                System.out.println("Both your Pokémon fainted!");
	                calculateScore(ally1.getPokemonHP(), ally2.getPokemonHP());
	                endBattle();
           	}
            }
            if (opponent1.getPokemonHP() == 0) {
            	if(opponent2.getPokemonHP() == 0) {
	                System.out.println("You defeated the wild Pokémon!");
	                chosenBall = generateRandomPokemonBall(Ball);
	                catchGauge();
	                catchSuccessCalculate(opponent1);
	                catchSuccessCalculate(opponent2);
	                calculateScore(ally1.getPokemonHP(), ally2.getPokemonHP());
	                endBattle();
            	}
            }
            if (round == 4) {
            	if(ally1.getPokemonHP() > 0 || ally2.getPokemonHP() > 0) {
            		System.out.println("You defended against the wild Pokémon!");
            		chosenBall = generateRandomPokemonBall(Ball);
            		catchGauge();
            		catchSuccessCalculate(opponent1);
            		catchSuccessCalculate(opponent2);
            		calculateScore(ally1.getPokemonHP(), ally2.getPokemonHP());
            		endBattle();
            	}
            }
        }
    }
    private void endBattle() {
    	System.out.println("Battle ended!");
    }
    private void displayOpponentInfo() {
    	System.out.println("Your opponent:");
    	if (opponent1 != null) {
    		System.out.println("1. " + opponent1.toShowPokemonInfo());
    	}
    	if (opponent2 != null) {
    		System.out.println("2. " + opponent2.toShowPokemonInfo());
    	}
    }
    private void displayAllyInfo() {
    	System.out.println("Your team:");
    	if (ally1 != null) {
    		System.out.println("1. " + ally1.toShowPokemonInfo());
    	}
    	if (ally2 != null) {
    		System.out.println("2. " + ally2.toShowPokemonInfo());
    	}
    }
    @Override
	protected Pokemon generateRandomPokemon() {
		
        if (BattleCharacter.isEmpty()) {
            System.out.println("Error: List is empty.");
            return null; 
        }
        
        Random random = new Random();
        int randomIndex = random.nextInt(BattleCharacter.size());
        Pokemon randomPokemon = BattleCharacter.get(randomIndex);
        
        if (true) {
        	BattleCharacter.remove(randomIndex);
        	BattleCharacter.remove(ownPokemon);
        }
        return randomPokemon;
    }
	private void playerTurn(Pokemon ally, Pokemon opponent) {
	    if (ally != null) {
	        performAttack(ally, opponent);
	        System.out.println(ally.pokemonAttack());
	    }
	}
	private void wildPokemonTurn(Pokemon opponent, Pokemon ally) {
		System.out.println("Enemy's attack!");
	    if (opponent != null) {
	        performAttack(opponent, ally);
	        System.out.println(ally.pokemonDefend());
	    }
	}

	private void performAttack(Pokemon attacker, Pokemon target) {
	    if (attacker != null && target != null) {
	        System.out.println(attacker.getPokemonName() + " attacks " + target.getPokemonName());
	        target.reducePokemonHP(attacker.getPokemonHP());
	    }
	}

	private void displayInfo() {
	    displayOpponentInfo();
	    displayAllyInfo();
	}
	private PokemonBall generateRandomPokemonBall (ArrayList<PokemonBall> Ball) {
		if (Ball.isEmpty()) {
            System.out.println("Error: Ball list is empty.");
            return null;
        }

        Random random = new Random();
        int randomIndex = random.nextInt(Ball.size());
        PokemonBall randomPokemonBall = Ball.get(randomIndex);

        return randomPokemonBall;
	}
    private void catchGauge() {
    	System.out.println("You got the " + chosenBall.getBallType() + "!");
    	System.out.println("Catch gauge is full!");
    	System.out.println("Now! Throw the ball!");
    }
    private void catchSuccessCalculate(Pokemon opponent) { 
        if (chosenBall.getCatchRate() >= (opponent.getSuitablePokeball()).getCatchRate()) {
            System.out.println(opponent.getPokemonName()+ " caught.");
            System.out.println(chosenBall.toShowSuccessCatch());
            pokemonCaughtCounter++;
            } else {
                System.out.println("Catch unsuccessful.");
                System.out.println(opponent.getPokemonName()+ " escaped.");
            }
    }
    @Override
    public void calculateScore(int hp1, int hp2) {
    	if (pokemonCaughtCounter == 1) {
    		int bonusPoints = pokemonCaughtCounter * 100;
    		TotalScore = hp1 + hp2 + bonusPoints;
    		System.out.println("Your battle score: " + TotalScore);
    		System.out.println("You caught " + pokemonCaughtCounter + " pokemon(s).");
    	}
    	else if (pokemonCaughtCounter == 2) {
    		int bonusPoints = pokemonCaughtCounter * 150;
    		TotalScore = hp1 + hp2 + bonusPoints;
    		System.out.println("Your battle score: " + TotalScore);
    		System.out.println("You caught " + pokemonCaughtCounter + " pokemon(s).");
    	}
    	else {
    		TotalScore = hp1 + hp2;
    		System.out.println("Your battle score: " + TotalScore);
    		System.out.println("You caught " + pokemonCaughtCounter + " pokemon(s).");
    	}
    }
}
