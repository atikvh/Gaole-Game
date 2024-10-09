package pokemon_project;


public class Pokemon {
	protected String pokeName;
	protected int hitPoint;
	protected PokemonBall pokemonBall;
	protected String moveType;
	protected String firstSkill;
	protected String secondSkill;
	protected int HPdamage;
	
	public Pokemon() {
		
	}
	public Pokemon (String name, PokemonBall ball) 
	{
		this.pokeName = name;
		this.pokemonBall = ball;
	}
	public void setPokemonName (String name) 
	{
		pokeName = name;
	}
	public String getPokemonName() 
	{
		return pokeName;
	}
	public void setPokemonHP(int HP) 
	{
		hitPoint = HP;
	} 
	
	public int getPokemonHP() 
	{
		return hitPoint;
	}
	public void setSuitablePokeball (PokemonBall ball) 
	{
		pokemonBall = ball;
	}
	public PokemonBall getSuitablePokeball() {
		return pokemonBall;
	}
	public String getMoveType() {
		return moveType;
	}
    public void reducePokemonHP(int damage) {
    	HPdamage = damage;
    	hitPoint -= damage;
        if (hitPoint < 0) {
            hitPoint = 0;
        }
        System.out.println(pokeName + "'s HP reduced to " + hitPoint);
    }
	public String toShowPokemonInfo() {
		return String.format("Pokemon = %s" + "Hit Point = %d", pokeName, hitPoint);
	}
	public String pokemonAttack() {
		return String.format("%s incoming!", firstSkill);
	}
	public String pokemonDefend() {
		return String.format("%s defence!", secondSkill);
	}
}

