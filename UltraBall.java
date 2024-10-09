package pokemon_project;

public class UltraBall extends PokemonBall {
    
	public UltraBall() {
		BallType = "Ultra Ball";
		catchRate = 62.4;
	}
	@Override
	public String getBallType() {
		return BallType;
	}
	public void setCatchRate(double rate) {
		catchRate = rate;
	}
	@Override
	public double getCatchRate() {
		return catchRate;
	}
}