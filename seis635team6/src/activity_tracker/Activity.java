package activity_tracker;

import java.util.*;

public class Activity { //this should probably be a collection

	//instance variables
	private Calendar c = Calendar.getInstance();
	private float duration;
	private String type = "running"; //assume running for initial build
	private String title;
	private String note;
	private String username;
	
	/** Constructor
	 * @param date		activity date
	 * @param duration	activity duration seconds???
	 * @param type		activity type
	 * @param title		activity title
	 * @param note		activity notes
	 * @param username	which user activity belongs to
	 */
	public Activity( Calendar d, float dur, String ttl, String n, String u)
	{
		c = d;
		duration = dur;
		title = ttl;
		note = n;
		username = u;
	}
	
	public Activity (Activity a)
	{
		c = a.c;
		duration = a.duration;
		type = a.type;
		title = a.title;
		note = a.note;
		username = a.username;
	}
	
	public void setActivity( Calendar d, float dur, String ttl, String n, String u )
	{
		d = c;
		duration = dur;
		
		//set default title if none provided
		if (ttl == ""){
			title = "Running";
		}
		else
		{
			title = ttl;
		}
		
		note = n;
		
		username = u;
	}
	
	public Calendar getDate()
	{
		return c;
	}
	
	public String getType()
	{
		return type;
	}
	
	public float getDuration()
	{
		return duration;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public String getNote()
	{
		return note;
	}
	
	public String getUsername()
	{
		return username;
	}
}
