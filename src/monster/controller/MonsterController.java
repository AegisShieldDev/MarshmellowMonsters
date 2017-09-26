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
		
		//Code that handles the eyes 1       ////////////////////////////////////////////////////////////////////////////////////////////////////////
		boolean toggle = true;
		int consumed = 0;
		String response = popup.getResponse(currentMonster.getName() + " George wants to know how many eyes you want to eat. He has " + currentMonster.getEyeCount()+ ", please type in how many");
		
		while(!isValidInteger(response))
		{
			popup.displayText("grr, type in a valid answer!");
			response = popup.getResponse("Type in an integer value!");
		}
		
		if((currentMonster.getEyeCount() - Integer.parseInt(response))<0)
		{
			toggle = false;
			while(toggle == false)
			{
				popup.displayText("grr, type in a valid answer");
				response = popup.getResponse("Type in an integer value less then or equal to " + currentMonster.getEyeCount());
				if(isValidInteger(response) && ((currentMonster.getEyeCount() - Integer.parseInt(response)) >= 0))
				{
					toggle = true;
				}
			}
		}
		
		//Checks if user input is valid, passes error message if not
		if(isValidInteger(response))
		{
			consumed = Integer.parseInt(response);
		}
		
		currentMonster.setEyeCount(currentMonster.getEyeCount() - consumed);
		popup.displayText("I now have " + currentMonster.getEyeCount() + " eyes.");
		
		//End code that handles the eyes 1   ////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//Code that handles the arms         ////////////////////////////////////////////////////////////////////////////////////////////////////////
		int armEat = 0;
		response = popup.getResponse("How many arms are you interested in eating? I have " + currentMonster.getArms() + " arms");
		
		while(!isValidInteger(response))
		{
			popup.displayText("grr, type in a valid answer!");
			response = popup.getResponse("Type in an integer value!");
		}
		
		if((currentMonster.getArms() - Integer.parseInt(response))<0)
		{
			toggle = false;
			while(toggle == false)
			{
				popup.displayText("grr, type in a valid answer");
				response = popup.getResponse("Type in an integer value less then or equal to " + currentMonster.getArms());
				if(isValidInteger(response) && ((currentMonster.getArms() - Integer.parseInt(response)) >= 0))
				{
					toggle = true;
				}
			}
		}
		
		//Checks if user input is valid, passes error message if not		
		if(isValidInteger(response))
		{
			armEat = Integer.parseInt(response);
		}
		
		if(armEat == 0) 
		{
			popup.displayText("Not hungry? So sad");
		}
		else
		{
			currentMonster.setArmCount(currentMonster.getArms() - armEat);
			popup.displayText("Ok, now I have this many arms: " + currentMonster.getArms());
		}
		//  End code that handles the arms   ////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//  Code that handles the eyes 2     ////////////////////////////////////////////////////////////////////////////////////////////////////////
		int eyeEat = 0;
		response = popup.getResponse("How many eyes are you interested in eating? I have " + currentMonster.getEyeCount());
		
		while(!isValidInteger(response))
		{
			popup.displayText("grr, type in a valid answer!");
			response = popup.getResponse("Type in an integer value!");
		}
		
		if((currentMonster.getEyeCount() - Integer.parseInt(response))<0)
		{
			toggle = false;
			while(toggle == false)
			{
				popup.displayText("grr, type in a valid answer");
				response = popup.getResponse("Type in an integer value less then or equal to " + currentMonster.getEyeCount());
				if(isValidInteger(response) && ((currentMonster.getEyeCount() - Integer.parseInt(response)) >= 0))
				{
					toggle = true;
				}
			}
		}
		
		//Checks if user input is valid, passes error message if not
		if(isValidInteger(response))
		{
			eyeEat = Integer.parseInt(response);
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
		//End code that handles the eyes 2   ////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//Code that handles Tentacles        ////////////////////////////////////////////////////////////////////////////////////////////////////////
		Double tentacleEat = 0.0;
		response = popup.getResponse("How many tentacles are you interested in eating? I have " + currentMonster.getTentacleAmount());
		
		while(!isValidDouble(response))
		{
			popup.displayText("grr, type in a valid answer!");
			response = popup.getResponse("Type in a double value!");
		}
		
		if((currentMonster.getArms() - Double.parseDouble(response))<0)
		{
			toggle = false;
			while(toggle == false)
			{
				popup.displayText("grr, type in a valid answer");
				response = popup.getResponse("Type in a double value less then or equal to " + currentMonster.getTentacleAmount());
				if(isValidDouble(response) && ((currentMonster.getTentacleAmount() - Double.parseDouble(response)) >= 0))
				{
					toggle = true;
				}
			}
		}
		
		//Checks if user input is valid, passes error message if not
		if(isValidDouble(response))
		{
			tentacleEat = Double.parseDouble(response);
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
		//End code that handles the tentacles////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//Code that handles the Bloop        ////////////////////////////////////////////////////////////////////////////////////////////////////////
		boolean bloopEat = false;
		
		if(currentMonster.hasBloop())
		{
			response = popup.getResponse("Would you like to eat my bloop?");
			
			
			
			//Checks if user input is valid, passes error message if not
			if(isValidBoolean(response))
			{
				bloopEat = Boolean.parseBoolean(response);
			}
			else
			{
				while(!isValidBoolean(response))
				{
					popup.displayText("grr, type true or false!");
					response = popup.getResponse("Type in true or false!");
				}
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
		//Ends code that handles the bloop  ////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//Closes the window when finished
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
