package activity_tracker;

public class ScheduleLinkedList extends ShellLinkedList {

	public ScheduleLinkedList() {
		super();
	}
	
	public void insert (Schedule s)
	{
		ScheduleNode sn = new ScheduleNode( new Schedule (s));
		sn.setNext(head);
		head = sn;
		numberOfItems++;
	}
	
	public Schedule delete (String username, int day)
		throws DataStructureException
	{
		ScheduleNode current = head;
		ScheduleNode previous = null;
		while ( current != null
				&& current.getSchedule().getUsername() != username
				&& current.getSchedule().getDay() != day)
		{
			previous = current;
			current = current.getNext();
		}
		
		if (current == null)
			throw new DataStructureException ( "No workout found for " + username + 
					" on Day " + day);
			
		else
		{
			if (current == head)
				head = head.getNext(); //delete head
			else
				previous.setNext(current.getNext());
			
			numberOfItems--;
			return current.getSchedule();
		}
	}
	
	//add peek method

}
