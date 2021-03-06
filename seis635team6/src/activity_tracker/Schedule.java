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
			day = d;
			distance = dist;
			this.setUsername(u);
			this.setTitle(t);
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
