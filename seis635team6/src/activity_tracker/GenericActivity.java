package activity_tracker;

public abstract class GenericActivity { 

	//instance variables
	private String type = "running"; 
	private String title;
	private String username;
	
	public GenericActivity(String u)
	{
		type = "running";
		title = "Running";
		username = u;
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
	
	public void setUsername(String u){
		username = u;
	}
	
	public void setTitle(String t){
		title = t;
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
