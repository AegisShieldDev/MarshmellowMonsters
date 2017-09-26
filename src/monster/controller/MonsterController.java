package monster.controller;

import monster.model.MarshmellowMonster;
import monster.view.MonsterDisplay;
//import java.util.Scanner;

public class MonsterController
{
	private MonsterDisplay popup;
	
	public MonsterController()
	{
		popup = new MonsterDisplay();
	}
	
	public void start()
	{	
	/*
		int count = 0;
		while(count < 10)
		{
			popup.displayText("Am I not the coolest??");
			count += 2;
		}
		*/
		//Create George, the monster
		MarshmellowMonster george = new MarshmellowMonster("GEORGE the GeOrgE",7,4,5.9, true);
		popup.displayText("George is a monster with " +george.getArms()+ " arms, "+ george.getEyeCount()+ " eyes, bloop=" + george.hasBloop() + ", and " + george.getTentacleAmount() + " tentacles");
		
		
		//Pass the monster into the interactWithMonster method
		interactWithMonster(george);
	}
	
	private void interactWithMonster(MarshmellowMonster currentMonster)
	{
		//Scanner myScanner = new Scanner(System.in);
		//int consumed = myScanner.nextInt();
		//int armEat = myScanner.nextInt();
		//int eyeEat = myScanner.nextInt();
		//myScanner.close();
		
		//Code that handles the eyes 1
		int consumed = 0;
		String responce = popup.getResponce(currentMonster.getName() + " George wants to know how many eyes you want to eat. He has " + currentMonster.getEyeCount()+ ", please type in how many");
		
		//Checks if user input is valid, passes error message if not
		if(isValidInteger(responce))
		{
			consumed = Integer.parseInt(responce);
		}
		
		currentMonster.setEyeCount(currentMonster.getEyeCount() - consumed);
		popup.displayText("I now have " + currentMonster.getEyeCount() + " eyes.");
		
		//End code that handles the eyes 1
		
		//Code that handles the arms
		int armEat = 0;
		responce = popup.getResponce("How many arms are you interested in eating? I have " + currentMonster.getArms() + " arms");
		
		//Checks if user input is valid, passes error message if not
		if(isValidInteger(responce))
		{
			armEat = Integer.parseInt(responce);
		}
		
		if(armEat == 0) 
		{
			popup.displayText("Not hungry? So sad");
		}
		else if(armEat < 0)
		{
			popup.displayText("Math must be hard for you");
		}
		else if(armEat > currentMonster.getArms())
		{
			popup.displayText("you're not allowed to eat more then exists on me");
		}
		else
		{
			currentMonster.setArmCount(currentMonster.getArms() - armEat);
			popup.displayText("Ok, now I have this many arms: " + currentMonster.getArms());
		}
		//End code that handles the arms
		
		//Code that handles the eyes 2
		int eyeEat = 0;
		responce = popup.getResponce("How many eyes are you interested in eating? I have " + currentMonster.getEyeCount());
		
		//Checks if user input is valid, passes error message if not
		if(isValidInteger(responce))
		{
			eyeEat = Integer.parseInt(responce);
		}
		
		if(eyeEat == 0) 
		{
			popup.displayText("Not hungry for eyes? So sad");
		}
		else if(eyeEat < 0)
		{
			popup.displayText("Math must be hard for you");
		}
		else if(eyeEat > currentMonster.getEyeCount())
		{
			popup.displayText("you're not allowed to eat more then exists on me");
		}
		else
		{
			currentMonster.setEyeCount(currentMonster.getEyeCount() - eyeEat);
			popup.displayText("Ok, now I have this many eyes: " + currentMonster.getEyeCount());
		}
		//End code that handles the eyes 2
		
		//Code that handles Tentacles
		Double tentacleEat = 0.0;
		responce = popup.getResponce("How many tentacles are you interested in eating? I have " + currentMonster.getTentacleAmount());
		
		//Checks if user input is valid, passes error message if not
		if(isValidDouble(responce))
		{
			tentacleEat = Double.parseDouble(responce);
		}
		if(tentacleEat == 0) 
		{
			popup.displayText("Not hungry? So sad");
		}
		else if(tentacleEat < 0)
		{
			popup.displayText("Math must be hard for you");
		}
		else if(tentacleEat > currentMonster.getTentacleAmount())
		{
			popup.displayText("you're not allowed to eat more then exists on me");
		}
		else
		{
			currentMonster.setTentacleAmount(currentMonster.getTentacleAmount() - tentacleEat);
			popup.displayText("Ok, now I have this many tentacles: " + currentMonster.getTentacleAmount());
		}
		//End code that handles the tentacles
		
		//Code that handles the Bloop
		boolean bloopEat = false;
		
		if(currentMonster.hasBloop())
		{
			responce = popup.getResponce("Would you like to eat my bloop?");
			
			//Checks if user input is valid, passes error message if not
			if(isValidBoolean(responce))
			{
				bloopEat = Boolean.parseBoolean(responce);
			}
			
			if(bloopEat)
			{
				currentMonster.setBloop(false);
				popup.displayText(currentMonster.getName() + " no longer has a bloop, it has been eaten.");
			}
			else
			{
				popup.displayText("You do not eat the monster's bloop.");
			}
		}
		else
		{
			popup.displayText("This monster does not have a bloop");
		}
		//Ends code that handles the bloop
		
		System.exit(0);
	}
	
	//Checks if an integer is valid, gives an error message if not
	private boolean isValidInteger(String sample)
	{
		boolean valid = false;
	
		try
		{
			Integer.parseInt(sample);
			valid = true;
		}
		catch(NumberFormatException error)
		{
			popup.displayText("You need to input an int, " + sample + " is not a valid answer.");
		}
		
		return valid;
	}
	
	//checks if a double is valid, gives an error message if not
	private boolean isValidDouble(String sampleDouble)
	{
		boolean valid = false;
		
		try
		{
			Double.parseDouble(sampleDouble);
			valid = true;
		}
		catch(NumberFormatException error)
		{
			popup.displayText("You need to type in a double, " + sampleDouble + " is not a valid answer.");
		}
		
		return valid;
	}
	
	//checks if a boolean is valid, gives an error message if not
	private boolean isValidBoolean(String sampleBoolean)
	{
		boolean valid = false;
		
		try
		{
			Boolean.parseBoolean(sampleBoolean);
			valid = true;
		}
		catch(NumberFormatException error)
		{
			popup.displayText("You need to type in a boolean, " + sampleBoolean + " does not count");
		}
		
		return valid;
	}
}
