package activity_tracker;

import java.io.Console;
import java.io.File;
import java.util.Scanner;

public class Controller {
	
	//menu options: record activity, set goal, view schedule, view training
	
	//sub-prompts for record activity
	
	//sub-prompts for set goal
	Goal goal;
	Scanner scanner;
	File goalFile;
	File activityFile;
	File scheduleFile;
	TextFileRead tfr;
	
	public Controller(){
		goal = new Goal();
		scanner = new Scanner (System.in);
		goalFile = new File("goal.txt");
		tfr = new TextFileRead();
		
	}
	
	public void displayUserPrompt(){
		System.out.println("Please select the number associated to the user");
		System.out.println("Liz");
		System.out.println("Antoinette");
		System.out.println("David");
		String userName = scanner.next();
		this.displayInitialPrompt(userName);
	}
	public void displayInitialPrompt(String userName){
		System.out.println("What would you like to do?");
		System.out.println("1) Create Goal");
		System.out.println("2) View Goal");
		System.out.println("3) Create Activity");
		System.out.println("4) View Schedule");
		String response = scanner.next();
		
		if(response.equals("1")) this.displayCreateGoalPrompt(userName);
		else if (response.equals("2")) this.diplayGoals(userName);
		else if (response.equals("2")) this.displayCreateActivityPrompt();
		else if (response.equals("4")) this.displaySchedule();
		//return n;
	}
	
	public void diplayGoals(String userName){
		Goal[] gl = new Goal[tfr.getTextEntries(goalFile, "goal").length];
		//gl = tfr.getTextEntries(goalFile, "goal");
		//System.out.println("gl is " + gl.length);
		int ctr=0;
		while (tfr.getTextEntries(goalFile, "goal")[ctr]!=null){
			if(tfr.getTextEntries(goalFile, "goal")[ctr].getUsername().equals(userName)){
				System.out.println(tfr.getTextEntries(goalFile, "goal")[ctr].toString());
				System.out.println(ctr);
			}
			System.out.println("current user name is " + tfr.getTextEntries(goalFile, "goal")[ctr].getUsername());
			ctr++;
		}
		this.displayInitialPrompt(userName);
	}
	
	public void displayCreateGoalPrompt(String userName){
		System.out.println("Please Enter Goal Type");
		System.out.println("1) Marathon");
		System.out.println("2) 10K");
		System.out.println("3) 5K");
		System.out.println("4) Spend more time on the couch");
		{
			String goalType;
			int startdate;
			int enddate;
			String gt=null;
				goalType = scanner.next();
			if(!goalType.equals(4)){
				if(goalType.equals("1")) gt="Marathon";
				else if (goalType.equals("2")) gt="10K";
				else if (goalType.equals("3")) gt="5K";
				else {
					//HANDLE THE INCORRECT HERE!!!
					System.out.println("Incorrect Goal type");
				}
				System.out.println("Please enter a start goal date in the form MMDDYYYY");
				startdate = Integer.parseInt(scanner.next().trim());
				System.out.println("Please enter an end goal date in the form MMDDYYYY");
				enddate = Integer.parseInt(scanner.next().trim());
				goal.setGoal(userName, gt, startdate, enddate, goalFile);
				
			}
		}
		this.displayInitialPrompt(userName);
	}
	
	public void displayCreateActivityPrompt(){
		
	}
	

	private void displaySchedule() {
		// TODO Auto-generated method stub
		
	}
}
