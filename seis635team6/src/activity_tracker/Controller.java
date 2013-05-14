package activity_tracker;

import java.io.Console;
import java.io.File;
import java.io.IOException;
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
	Scanner scanner; //get user input at command prompts
	String userName ="";
	Goal goal;
	File goalFile;
	TextFileRead gtfr;
	GenericActivityFile<Activity> activityList = new GenericActivityFile<Activity>(); //for tracking user's activity list
	GenericActivityFile<Schedule> scheduleList = new GenericActivityFile<Schedule>(); //for tracking schedule list
	
	//set pattern for date input
	String datePattern = "MMddyyy";
	SimpleDateFormat format = new SimpleDateFormat(datePattern);
	
	//set pattern for duration input
	String durationPattern = "hhmmss";
	SimpleDateFormat durationFormat = new SimpleDateFormat(durationPattern);
	
	/** Overloaded Constructor
	 * @author Liz
	 * @param goalFile
	 */
	public Controller(File goalFile){
		goal = new Goal(goalFile);
		scanner = new Scanner (System.in);
		goalFile = new File("goal.txt");
		gtfr = new TextFileRead(goalFile);
	}
	/** Constructor
	 * Default constructor called by ActivityTrackerMain
	 * @author Antoinette
	 */
	public Controller(){
		scanner = new Scanner (System.in);	
	}
	/**
	 * User can enter any name as user name.
	 * System does not store user names.
	 * Once user is identified any activities associated with user are loaded from file.
	 * @author Liz
	 * @author Antoinette
	 */
	public void displayUserPrompt() throws IOException{
		//TODO check input for errors
			do {
				System.out.println("Please enter your username");
				userName = scanner.next();
			} while(userName.length() < 0);
		this.loadActivities(); //load user's activities
		this.displayInitialPrompt(); //go to menu prompts
	}
	/**
	 * @author Liz
	 * 
	 */
	public void displayInitialPrompt(){
		System.out.println("What would you like to do?");
		System.out.println("1) Create Goal");
		System.out.println("2) View Goal");
		System.out.println("3) Create Activity");
		System.out.println("4) View Activities");
		System.out.println("5) Quit");
		String response = scanner.next();
		
		do {
		if(response.equals("1")) this.displayCreateGoalPrompt();
		else if (response.equals("2")) this.diplayGoals();
		else if (response.equals("3")) this.displayCreateActivityPrompt();
		else if (response.equals("4")) this.displayActivities();
		else if (response.equals("99")) this.displayCreateSchedulePrompt(); //added for administrator creation of serialized schedules
		else this.ungracefulExit();
		} while (!response.equals("5"));
	}
	/**
	 * @author Liz
	 * 
	 */
	public void diplayGoals(){
		Goal[] g = goal.getGoal();
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
	/**
	 * @author Liz
	 * 
	 */
	public void displayCreateGoalPrompt(){
		System.out.println("Please enter goal type");
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
	 * 
	 */
	public void displayCreateActivityPrompt(){
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime(); //set to today
		Date duration = null;
		String title = "";
		String note = "";
		Activity activity = new Activity(userName);
		
		System.out.println("Record an activity"); //initial prompt title
		System.out.println("For today? Enter Y or N"); //default to today for usability
		String response = scanner.next();
		
		if(response == "Y" || response == "y" ) //get today's activity's duration
		{
			title = this.getTextInput("title");
			duration = this.getDuration();
			note = this.getTextInput("note");
		}
		else if (response == "N" || response == "n") //get activity's date
		{
			System.out.println("Enter an activity for...");
			System.out.println("(Y)esterday");
			System.out.println("A date in MMDDYYYY format");
			
			response = scanner.next();
			if (response == "Y" || response == "y")
			{
				cal.add(Calendar.DAY_OF_MONTH, -1);
				date = cal.getTime();
				title = this.getTextInput("title");
				duration = this.getDuration();
				note = this.getTextInput("note");
			}
		}
		else
		{
			this.ungracefulExit();
		}
		//set activity's user-entered parameters
		activity.setTitle(title);
		activity.setNote(note);
		activity.setDuration(duration);
		activity.setDate(date);
		
		//add activity to list
		this.activityList.addObject(activity);
	}
	

	private void displayActivities() {
		// TODO Auto-generated method stub
		
	}
	
	private void displayCreateSchedulePrompt() {
		// TODO Auto-generated method stub
		
	}
	
	////////////START utility functions//////////////
	/**
	 * Populates activity linked list with activities from file.
	 * @author Antoinette
	 * @throws IOException
	 */
	private void loadActivities() throws IOException{
		activityList.readObjectFile(userName);
	}
	/**
	 * Manages activity duration-related prompts.
	 * @author Antoinette
	 * @return
	 */
	private Date getDuration(){
		Date dur = null;
		int error = 0;
		String response;
		
		System.out.println("Enter duration as HHMMSS");
		do
		{
			error = 0;
			response = scanner.next();
			if(response == "P" || response == "p")
			{
				this.displayCreateActivityPrompt();
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
		
		return dur;
	}
	/**
	 * Handles taking text-based input and allows return to previous menu.
	 * @author Antoinette
	 * @param param
	 * @return
	 */
	private String getTextInput(String param)
	{
		String response;
		
		System.out.println("Enter ".concat(param).concat(" or type P for previous menu"));
		response = scanner.next();
		
		if(response == "P" || response == "p")
		{
				this.displayCreateActivityPrompt();
		}
		
		return response;
	}
	/**
	 * Handles most program exits when user input does not match anticipated input.
	 * Not user friendly.
	 * @author Antoinette
	 */
	private void ungracefulExit()
	{
		System.out.println("No appropriate responses given. Application now closing.");
		System.exit(0);
	}
}
