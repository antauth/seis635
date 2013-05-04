package activity_tracker;

public class ActivityNode {
	private Activity activity;
	private ActivityNode next;
	
	public ActivityNode()
	{
		activity = null;
		next = null;
	}
	
	public ActivityNode(Activity a)
	{
		setActivity(a);
		next = null;
	}
	
	public Activity getActivity()
	{
		return new Activity( activity);
	}
	
	public ActivityNode getNext()
	{
		return next;
	}
	
	public void setActivity(Activity a)
	{
		activity = new Activity(a);
	}
	
	public void setNext( ActivityNode an)
	{
		next = an;
	}

}
