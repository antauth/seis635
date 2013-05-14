package activity_tracker;

public class Schedule extends GenericActivity {

	//set instance variables
	int day;
	float distance;
	final static String systemUser = "system";
	
	//constructor
	public Schedule (int d, String a, String u, float dist, String ttl)
	{
		super (ttl, u);
		day = d;
		distance = dist;
	}
	
	public Schedule (Schedule s)
	{
		super(s);
		day = s.day;
		distance = s.distance;
	}
	
		//account for schedule owner: system or user
		//when user modifies a schedule it changes to a new schedule
	public void setSchedule( int d, String u, float dist, String t )
	{
		if (u == systemUser)
		{
			day = d;
			distance = dist;
		}
		else if (this.getUsername() == systemUser)
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
	
	
	public float getDistance()
	{
		return distance;
	}
	
	public String toString()
	{
		return getUsername() + "," + day + "," + getTitle() + "," + getType() + "," + distance;
	}
		
}
