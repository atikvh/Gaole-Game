package pokemon_project;

public class PokeBall extends PokemonBall {
    
	public PokeBall() {
		BallType = "Poke Ball";
		catchRate = 28.0;
	}
	@Override
	public String getBallType() {
		return BallType;
	}
	public void setCatchRate(double rate) {
		catchRate = rate;
	}
	public double getCatchRate() {
		return catchRate;
	}
}