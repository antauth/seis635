/**
 * 
 */
package activity_tracker;

import java.util.*;
import java.io.*;

/**
 * @author Antoinette
 *
 */
public class ActivityFile {

	//instance variables
	List<Activity> activitylist;
	ListIterator<Activity> activitynavigator;
	ObjectInputStream o;
	FileInputStream f;
	/**
	 * Creates a linked list for activity objects.
	 * 
	 */
	public ActivityFile (){
		activitylist = new LinkedList<Activity>();
		activitynavigator = activitylist.listIterator();
	}
	
	//read activity file
	public void readActivityFile(String filename) throws IOException{
		File file = new File(filename);
		
		if (file.exists())
		{
			try
			{
				f = new FileInputStream(filename);
				o = new ObjectInputStream(f);
				
				try
				{
					do
					{
						activitylist.add((Activity) o.readObject());
					}while(f.available() > 0);
				}
				catch (EOFException e)
				{
					System.err.println("End of file reached");
				}
				catch (ClassNotFoundException e)
				{
					System.err.println("Class does not exist");
				}
			}
			catch (FileNotFoundException e)
			{
				System.err.println("File not found exception");
			}
			catch (IOException e)
			{
				System.err.println("IO exception");
			}
			finally
			{
				o.close();
			}
			
		}
		else throw new NullPointerException();
	}
	
	//write to activity file
	
	//get next activity
	public Activity getNext(){
		return activitynavigator.next();
	}
	
	//get previous activity
}
