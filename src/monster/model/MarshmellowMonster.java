package monster.model;

public class MarshmellowMonster
{
	//Declaration section
	private String name;
	private int eyeCount, armCount;
	private double tentacleAmount;
	private boolean hasBloop;
	
	public MarshmellowMonster()
	{
		
	}
	
	public MarshmellowMonster(String name, int eyeCount, int arms, int tentacleCount, boolean hasBloop)
	{
		this.name = name;
		this.eyeCount = eyeCount;
		this.armCount = arms;
		this.tentacleAmount = tentacleCount;
		this.hasBloop = hasBloop;
	}
	
	public String toString()
	{
		String description = "I am a monster, my name is " + name + ", I have "+ eyeCount + " eyes and only ";
		description += tentacleAmount + " tentacles but I have " + armCount + " arms! " + hasBloop + " tells you";
		description += " if I have a bloop";
		
		return description;
	}
}
