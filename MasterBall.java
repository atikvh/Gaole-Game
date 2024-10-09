package pokemon_project;

public class MasterBall extends PokemonBall {
    
	public MasterBall() {
		BallType = "Master Ball";
		catchRate = 100.0;
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