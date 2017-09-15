package monster.controller;

import monster.model.MarshmellowMonster;
import java.util.Scanner;

public class MonsterController
{
	public void start()
	{
		MarshmellowMonster basic = new MarshmellowMonster();
		System.out.println(basic);
		MarshmellowMonster george = new MarshmellowMonster("GEORGE the GeOrgE",7,4,5.9, true);
		System.out.println(george);
		System.out.println("I am feeling hungry, I am going to eat George's face");
		george.setEyeCount(george.getEyeCount()-3);
		System.out.println(george);
		System.out.println("I am feeling hungry, I am going to eat George's arms");
		george.setArmCount(george.getArms()-3);
		System.out.println(george);
		System.out.println("I am feeling hungry, I am going to eat George's tentacles");
		george.setTentacleAmount(george.getTentacleAmount()-2.2);
		System.out.println(george);
		System.out.println("I am feeling hungry, I am going to eat George's face");
		george.setEyeCount(george.getEyeCount()-2);
		System.out.println(george);
		System.out.println("I am feeling hungry, I am going to eat George's tentacles");
		george.setTentacleAmount(george.getTentacleAmount()-2.2);
		System.out.println(george);
		System.out.println("I am feeling hungry, I am going to eat George's first Bloop");
		System.out.println(george);
		System.out.println("I am feeling hungry, I am going to eat George's face");
		george.setEyeCount(george.getEyeCount()-2);
		System.out.println(george);
		System.out.println("I am feeling hungry, I am going to eat George's arm");
		george.setArmCount(george.getArms()-1);
		System.out.println(george);
		System.out.println("I am feeling hungry, I am going to eat George's tentacles");
		george.setTentacleAmount(george.getTentacleAmount()-1.5);
		System.out.println(george);
		System.out.println("I am feeling hungry, I am going to eat George's second Bloop, the last part of George");
		george.setBloop(false);
		System.out.println(george);
		System.out.println("George is out of parts");
		System.out.println("George is gone");
		System.out.println("Goodbye, George");
		System.out.println("");
		System.out.println("");
		
		interactWithMonster(george);
	}
	
	private void interactWithMonster(MarshmellowMonster currentMonster)
	{
		Scanner myScanner = new Scanner(System.in);
		System.out.println(currentMonster.getName() + " is back! He wants to know how many eyes you want to eat, please type in how many");
		int consumed = myScanner.nextInt();
		currentMonster.setEyeCount(currentMonster.getEyeCount() - consumed);
		System.out.println(currentMonster);
		
		myScanner.close();
	}
}
