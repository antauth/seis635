package activity_tracker;

public abstract class ShellLinkedList {
	protected ActivityNode head;
	protected int numberOfItems;

	public ShellLinkedList()
	{
		head = null;
		numberOfItems = 0;
	}
	
	public int getNumberOfItems()
	{
		return numberOfItems;
	}
	
	public boolean isEmpty()
	{
		return (numberOfItems == 0);
	}
	
	public String toString()
	{
		String listString = "";
		ActivityNode current = head;
		for (int i = 0; i < numberOfItems; i++)
		{
			listString += current.getActivity().toString() + "/n";
			current = current.getNext();
		}
		return listString;
	}
}
