package pokemon_project;

public class GreatBall extends PokemonBall {
    
	public GreatBall() {
		BallType = "Great Ball";
		catchRate = 41.0;
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