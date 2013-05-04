package activity_tracker;

public abstract class GenericActivity { 

	//instance variables
	private String type = "running"; 
	private String title;
	private String username;
	
	public GenericActivity()
	{
	}
	
	public GenericActivity( String ttl, String u)
	{
		title = ttl;
		username = u;
	}
	
	public GenericActivity (GenericActivity g)
	{
		type = g.type;
		title = g.title;
		username = g.username;
	}
	
	public void setGenericActivity( String ttl, String u )
	{
		//set default title if none provided
		if (ttl == ""){
			title = "Running";
		}
		else
		{
			title = ttl;
		}
		
		username = u;
	}
	
	public String getType()
	{
		return type;
	}
	
	public String getTitle()
	{
		return title;
	}
	
	public String getUsername()
	{
		return username;
	}
	
	public String toString()
	{
		return username + "," + title + "," + type;
	}
}
