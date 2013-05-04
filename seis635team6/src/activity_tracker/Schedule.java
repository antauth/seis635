package activity_tracker;

public class Schedule {

	//set instance variables
	int day;
	String activityType = "running";
	String username;
	float distance;
	String title;
	final static String systemUser = "system";
	
	//constructor
	public Schedule (int d, String a, String u, float dist, String t)
	{
		day = d;
		activityType = a;
		username = u;
		distance = dist;
		title = t;
	}
	
	public Schedule (Schedule s)
	{
		day = s.day;
		activityType = s.activityType;
		username = s.username;
		distance = s.distance;
		title = s.title;
	}
	
		//getSchedule
		//account for schedule owner: system or user
		//when user modifies a schedule it changes to a new schedule
	public void setSchedule( int d, String a, String u, float dist, String t )
	{
		if (u == systemUser)
		{
			day = d;
			activityType = a;
			distance = dist;
			title = t;
		}
		else if (this.username == systemUser)
		{
			//check for existing modification file
			if (true) //TODO: file exists
			{
				//append file
			}
			else
			{
				//create file
				//write to file
			}
		}
	}
	
	public int getDay()
	{
		return day;
	}
	
	public String getActivityType()
	{
		return activityType;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public float getDistance()
	{
		return distance;
	}
	
	public String toString()
	{
		return username + "," + day + "," + title + "," + activityType + "," + distance;
	}
		
}
