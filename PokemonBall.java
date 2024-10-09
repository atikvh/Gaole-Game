package pokemon_project;

public class PokemonBall {
	protected String BallType;
	protected String BallColor; 
	protected double catchRate;
	
    public PokemonBall() {
    	
    }
    public PokemonBall(String type, String color) {
    	BallType = type;
    	BallColor = color;
    }
    public void setBallType(String type) {
    	BallType = type;
    }
    public String getBallType() {
    	return BallType;
    }
    public void setBallColor(String color) {
    	BallColor = color;
    }
    public String getBallColor() {
    	return BallColor;
    }
    public double getCatchRate() {
    	return catchRate;
    }
    public String toShowBallInfo() {
    	return String.format("Pokemon Ball: %s, " + "Color: %s. ", BallType, BallColor);
    }
	public String toShowSuccessCatch() {
		return String.format("Wild pokemon caught with %s! Congratulations!", BallType);
	}
}