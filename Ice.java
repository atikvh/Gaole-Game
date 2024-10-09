package pokemon_project;

public class Ice extends Pokemon {
	
	public Ice(String name, String type, String skillone, String skilltwo, int HP)
	{
		moveType = type = "Ice";
		firstSkill = skillone;
		secondSkill = skilltwo;
		pokeName = name;
		hitPoint = HP;
	}
	public String getMoveType()
	{
		return moveType;
	}
	public void setfirstSkill(String skillone)
	{
		firstSkill = skillone;
	}
	public String getfirstSkill() 
	{
		return firstSkill;
	}
	public void setsecondSkill(String skilltwo) {
		secondSkill = skilltwo;
	}
	public String getsecondSkill() {
		return secondSkill;
	}
	@Override
	public String toShowPokemonInfo() 
	{
		return String.format(" Pokemon: %s, " + " Hit Point: %d, " + " Attack type: %s, " + " Skills: %s, %s. ", pokeName, hitPoint , moveType, firstSkill, secondSkill);
	}
	@Override
	public void reducePokemonHP(int HPdamage) {
		if ("Water".equals(moveType)&&"Grass".equals(moveType)&&"Electric".equals(moveType)) {
			//normalEffect
			double damage = HPdamage*0.75;
			hitPoint -= damage;
		}
		if ("Ice".equals(moveType)) {
			//not very effective
			double damage = HPdamage*0.25;
			hitPoint -= damage;
		}
		if ("Fire".equals(moveType)) {
			//super effective
			double damage = HPdamage*1;
			hitPoint -= damage;
		}
	    if (hitPoint < 0) {
            hitPoint = 0;
        }
	}
}