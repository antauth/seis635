package activity_tracker;

import java.util.Calendar;

public class ActivityLinkedList extends ShellLinkedList {

	public ActivityLinkedList() {
		super();
	}
	
	public void insert (Activity a)
	{
		ActivityNode an = new ActivityNode( new Activity (a));
		an.setNext(head);
		head = an;
		numberOfItems++;
	}
	
	public Activity delete (String username, Calendar cal)
		throws DataStructureException
	{
		ActivityNode current = head;
		ActivityNode previous = null;
		while ( current != null
				&& current.getActivity().getUsername() != username
				&& current.getActivity().getDate() != cal)
		{
			previous = current;
			current = current.getNext();
		}
		
		if (current == null)
			throw new DataStructureException ( "No workout found for " + username + 
					" on " + cal.getTime());
			
		else
		{
			if (current == head)
				head = head.getNext(); //delete head
			else
				previous.setNext(current.getNext());
			
			numberOfItems--;
			return current.getActivity();
		}
	}
	
	//add peek method

}
