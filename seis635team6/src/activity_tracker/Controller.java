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
	
	/** Constructor
	 * Default constructor called by ActivityTrackerMain
	 * @author Liz
	 * @author Antoinette
	 */
	public Controller(){
		scanner = new Scanner (System.in);
		goalFile = new File("goal.txt");
		goal = new Goal(goalFile);
		gtfr = new TextFileRead(goalFile);
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
				userName = scanner.nextLine();
			} while(userName.length() < 0);
		this.loadActivities(); //load user's activities
		this.displayInitialPrompt(); //go to menu prompts
	}
	/**
	 * @author Liz
	 * @throws IOException 
	 * 
	 */
	public void displayInitialPrompt() throws IOException{
		String response = null;
		do {
			System.out.println("What would you like to do?");
			System.out.println("1) Create Goal");
			System.out.println("2) View Goal");
			System.out.println("3) Create Activity");
			System.out.println("4) View Activities");
			System.out.println("5) Quit");
			response = scanner.nextLine();


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
				goalType = scanner.nextLine();
			if(!goalType.equals(4)){
				if(goalType.equals("1")) gt="Marathon";
				else if (goalType.equals("2")) gt="10K";
				else if (goalType.equals("3")) gt="5K";
				else {
					//HANDLE THE INCORRECT HERE!!!
					System.out.println("Incorrect Goal type");
				}
				System.out.println("Please enter a start goal date in the form MMDDYYYY");
				startdate = Integer.parseInt(scanner.nextLine().trim());
				System.out.println("Please enter an end goal date in the form MMDDYYYY");
				enddate = Integer.parseInt(scanner.nextLine().trim());
				goal.setGoal(new Goal(userName, gt, startdate, enddate));
				
			}
		}
	}
	/**
	 * @author Antoinette
	 * 
	 */
	public Object displayCreateActivityPrompt() throws IOException{
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime(); //set to today
		Date duration = null;
		String title = "";
		String note = "";
		Activity activity = new Activity(userName);
		
		System.out.println("Record an activity"); //initial prompt title
		System.out.println("For today? Enter Y or N"); //default to today for usability
		String response = scanner.nextLine();
		
		if(response.equals("Y") || response.equals("y") ) //get today's activity's duration
		{
			title = this.getTextInput("title");
			if (title == null) return null;
			duration = this.getDuration();
			note = this.getTextInput("note");
		}
		else if (response.equals("N") || response.equals("n")) //get activity's date
		{
			System.out.println("Enter an activity for...");
			System.out.println("(Y)esterday");
			System.out.println("A date in MMDDYYYY format");
			
			response = scanner.nextLine();
			if (response.equals("Y") || response.equals("y"))
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
		
		//save prompt not working as expected
		/*System.out.println("Save this activity now? Y/N");
		response = scanner.nextLine();
		
		if(response.equals("Y") || response.equals("y") )
		{
			this.saveActivities();
		}*/
		
		return null;
	}
	

	private void displayActivities() {
		ListIterator<Activity> iterator = activityList.objectlist.listIterator();
		
		do {
			System.out.println(iterator.next().toString());
		} while(iterator.hasNext());
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
	 * Saves all activities to a file named after the user.
	 * @author Antoinette
	 * @throws IOException
	 */
	private void saveActivities() throws IOException{
		activityList.writeObjectFile();
	}
	/**
	 * Manages activity duration-related prompts.
	 * @author Antoinette
	 * @return
	 */
	private Date getDuration(){
		Date dur = null;
		String response = null;
		do
		{
			response = this.getTextInput("duration as HHMMSS");
			
			if(response != null)
			{
				try
				{
					dur = durationFormat.parse(response);
				}
				catch (ParseException e)
				{
					System.err.println("Input not in expected format");
				}
			}
		}while (response == null && dur == null);
		
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
		response = scanner.nextLine();
		
		if(response.equals("P") || response.equals("p"))
		{
				response = null;
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
		System.out.println("Application now closing.");
		System.exit(0);
	}
}
