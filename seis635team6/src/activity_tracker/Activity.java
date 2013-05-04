package activity_tracker;

import java.util.*;

public class Activity extends GenericActivity { 

	//instance variables
	private Calendar c = Calendar.getInstance();
	private float duration;
	private String note;
	
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
		super (ttl, u);
		c = d;
		duration = dur;
		note = n;
	}
	
	public Activity (Activity a)
	{
		super(a);
		c = a.c;
		duration = a.duration;
		note = a.note;
	}
	
	public void setActivity( Calendar d, float dur, String ttl, String n, String u )
	{
		d = c;
		duration = dur;
		note = n;
		
		//setUsername(u);
		//setTitle;
	}
	
	public Calendar getDate()
	{
		return c;
	}
	
	public float getDuration()
	{
		return duration;
	}
	
	public String getNote()
	{
		return note;
	}
	
	public String toString()
	{
		return getUsername() + "," + c.getTime() + "," + getTitle() + "," + getType() + "," + duration;
	}
}
