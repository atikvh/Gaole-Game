package pokemon_project;

public class Water extends Pokemon {
	
	public Water(String name, String type, String skillone, String skilltwo, int HP)
	{
		moveType = type = "Water";
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
		if ("Ice".equals(moveType)&&"Water".equals(moveType)&&"Fire".equals(moveType)) {
			//not very effective
			double damage = HPdamage*0.25;
			hitPoint -= damage;
		}
		if ("Grass".equals(moveType)&&"Electric".equals(moveType)) {
			//super effective
			double damage = HPdamage*1;
			hitPoint -= damage;
		}
	    if (hitPoint < 0) {
            hitPoint = 0;
        }
	}
}