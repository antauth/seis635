package activity_tracker;

import java.util.*;

public class Activity extends GenericActivity { 

	//instance variables
	private Calendar c = Calendar.getInstance();
	private Date date = c.getTime();
	private Date duration;
	private String note;
	
	/** Constructor
	 * @param date		activity date
	 * @param duration	activity duration
	 * @param type		activity type
	 * @param title		activity title
	 * @param note		activity notes
	 * @param username	which user activity belongs to
	 */
	public Activity( Date d, Date dur, String ttl, String n, String u)
	{
		super (ttl, u);
		date = d;
		duration = dur;
		note = n;
	}
	
	public Activity (String u)
	{
		super(u);
		duration = null;
		note = "";
	}
	
	public Activity (Activity a)
	{
		super(a);
		date = a.date;
		duration = a.duration;
		note = a.note;
	}
	
	public void setDate (Date d)
	{
		this.date = d;
	}
	
	public void setDuration (Date d)
	{
		this.duration = d;
	}
	
	public void setNote (String n)
	{
		this.note = n;
	}
	
	public Date getDate()
	{
		return date;
	}
	
	public Date getDuration()
	{
		return duration;
	}
	
	public String getNote()
	{
		return note;
	}
	
	public String toString()
	{
		return getUsername() + "," + date + "," + getTitle() + "," + getType() + "," + duration;
	}
}
