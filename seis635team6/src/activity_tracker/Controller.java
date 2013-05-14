package activity_tracker;

import java.io.Console;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 
 * @author Liz
 * @author Antoinette
 *
 */
public class Controller {
	
	//menu options: record activity, set goal, view schedule, view training
	
	//sub-prompts for record activity
	
	//sub-prompts for set goal
	Goal goal;
	Scanner scanner;
	File goalFile;
	TextFileRead gtfr;
	
	String datePattern = "MMddyyy";
	SimpleDateFormat format = new SimpleDateFormat(datePattern);
	
	String durationPattern = "hhmmss";
	SimpleDateFormat durationFormat = new SimpleDateFormat(durationPattern);
	
	public Controller(File goalFile){
		goal = new Goal(goalFile);
		scanner = new Scanner (System.in);
		goalFile = new File("goal.txt");
		gtfr = new TextFileRead(goalFile);
		
	}
	
	public Controller(){
		scanner = new Scanner (System.in);	
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
		System.out.println("5) Quit");
		String response = scanner.next();
		
		do {
		if(response.equals("1")) this.displayCreateGoalPrompt(userName);
		else if (response.equals("2")) this.diplayGoals(userName);
		else if (response.equals("3")) this.displayCreateActivityPrompt(userName);
		else if (response.equals("4")) this.displaySchedule();
		else if (response.equals("99")) this.displayCreateSchedulePrompt(); //added for administrator creation of serialized schedules
		//return n;
		} while (!response.equals("5"));
	}
	
	public void diplayGoals(String userName){
		Goal[] g = goal.getGoal();
		//gl = tfr.getTextEntries(goalFile, "goal");
		//System.out.println("gl is " + gl.length);
		int ctr=0;
		while (g[ctr]!=null){
			if(g[ctr].getUsername().equals(userName)){
				System.out.println(g[ctr].toString());
				System.out.println(ctr);
			}
			System.out.println("current user name is " + g[ctr].getUsername());
			ctr++;
		}
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
				goal.setGoal(new Goal(userName, gt, startdate, enddate));
				
			}
		}
	}
	/**
	 * @author Antoinette
	 * @param userName
	 */
	public void displayCreateActivityPrompt(String userName){
		Calendar cal = Calendar.getInstance();
		Date dur;
		Date date;
		int error = 0;
		
		System.out.println("Record an activity");
		System.out.println("For today? Enter Y or N");
		String response = scanner.next();
		
		if(response == "Y" || response == "y" ) //get activity's duration
		{
			date = cal.getTime();
			System.out.println("Enter duration as HHMMSS");
			do
			{
				error = 0;
				response = scanner.next();
				if(response == "P" || response == "p")
				{
					this.displayCreateActivityPrompt(userName);
				}
				else
				{

					try
					{
						dur = durationFormat.parse(response);
					}
					catch (ParseException e)
					{
						error = 1;
						System.err.println("Input not in expected format");
						System.out.println("Enter duration as HHMMSS or type P for previous menu");
					}
				}
			}while (error > 0);
		}
		else if (response == "N" || response == "n") //get activity's date
		{
			System.out.println("Enter an activity for...");
			System.out.println("(Y)esterday");
			System.out.println("A date in MMDDYYYY format");
			
			response = scanner.next();
			if (response == "Y" || response == "y")
			{
				
			}
		}
	}
	

	private void displaySchedule() {
		// TODO Auto-generated method stub
		
	}
	
	private void displayCreateSchedulePrompt() {
		// TODO Auto-generated method stub
		
	}
}
