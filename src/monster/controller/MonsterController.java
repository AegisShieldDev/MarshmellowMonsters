package monster.controller;

import monster.model.MarshmellowMonster;
import java.util.Scanner;
import monster.view.MonsterDisplay;

public class MonsterController
{
	private MonsterDisplay popup;
	
	public MonsterController()
	{
		popup = new MonsterDisplay();
	}
	
	public void start()
	{
		MarshmellowMonster basic = new MarshmellowMonster();
//		System.out.println(basic);
		popup.displayText(basic.toString());
		MarshmellowMonster george = new MarshmellowMonster("GEORGE the GeOrgE",7,4,5.9, true);
//		System.out.println(george);
		popup.displayText(george.toString());
		popup.displayText("I am feeling hungry, I am going to eat George's face");
		george.setEyeCount(george.getEyeCount()-3);
		popup.displayText(george.toString());
		popup.displayText("I am feeling hungry, I am going to eat George's arms");
		george.setArmCount(george.getArms()-3);
		popup.displayText(george.toString());
		
		george.setArmCount(5);
		george.setBloop(true);
		george.setEyeCount(5);
		george.setTentacleAmount(5);
		
		interactWithMonster(george);
	}
	
	private void interactWithMonster(MarshmellowMonster currentMonster)
	{
		Scanner myScanner = new Scanner(System.in);
		int consumed = 0;
		String responce = popup.getResponce(currentMonster.getName() + " is back! He grows stuff back. He wants to know how many eyes you want to eat, please type in how many");
		
		if(isValidInteger(responce))
		{
			consumed = Integer.parseInt(responce);
		}
		
		//int consumed = myScanner.nextInt();
		currentMonster.setEyeCount(currentMonster.getEyeCount() - consumed);
		System.out.println(currentMonster);
		
		
		
		
		//arms
		popup.getResponce("How many arms are you interested in eating? I have " + currentMonster.getArms() + " arms");
		int armEat = myScanner.nextInt();
		
		if(armEat == 0) 
		{
			System.out.println("Not hungry? So sad");
		}
		else if(armEat < 0)
		{
			System.out.println("Math must be hard for you");
		}
		else if(armEat > currentMonster.getArms())
		{
			System.out.println("you're not allowed to eat more then exists on me");
		}
		else
		{
			currentMonster.setArmCount(currentMonster.getArms() - armEat);
			System.out.println("Ok, now I have this many arms: " + currentMonster.getArms());
		}
		
		
		//eyes
		System.out.println("How many eyes are you interested in eating? I have " + currentMonster.getEyeCount());
		int eyeEat = myScanner.nextInt();
		
		if(eyeEat == 0) 
		{
			System.out.println("Not hungry? So sad");
		}
		else if(eyeEat < 0)
		{
			System.out.println("Math must be hard for you");
		}
		else if(eyeEat > currentMonster.getEyeCount())
		{
			System.out.println("you're not allowed to eat more then exists on me");
		}
		else
		{
			currentMonster.setEyeCount(currentMonster.getEyeCount() - eyeEat);
			System.out.println("Ok, now I have this many eyes: " + currentMonster.getEyeCount());
		}
		
		popup.displayText("Hi there, ready to play?");
		String answer = popup.getResponce("What is the air speed of a coconut laden swallow?");
		myScanner.close();
		
		
		
	}
	
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
			popup.displayText("You need to input an int, " + sample + " is not valid.");
		}
		
		return valid;
	}
}
