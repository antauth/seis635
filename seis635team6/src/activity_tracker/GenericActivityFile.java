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
public class GenericActivityFile<E extends GenericActivity> {

	//instance variables
	List<E> objectlist;
	ListIterator<E> objectnavigator;
	ObjectInputStream o;
	FileInputStream f;
	ObjectOutputStream p;
	FileOutputStream g;
	
	/**
	 * Creates a linked list for objects.
	 * 
	 */
	public GenericActivityFile (){
		objectlist = new LinkedList<E>();
		objectnavigator = objectlist.listIterator();
	}
	
	//read object file
	@SuppressWarnings("unchecked")
	public void readObjectFile(String filename) throws IOException{
		File file = new File(filename);
		
		if (file.exists())
		{
			try
			{
				f = new FileInputStream(file);
				o = new ObjectInputStream(f);
				
				try
				{
					do
					{
						objectlist.add((E) o.readObject());
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
	
	//write to object file
	public void writeObjectFile(String filename, List<E> a) throws IOException{
		File file = new File(filename);
		ListIterator<E> iterate = a.listIterator();
		
			try
			{
				g = new FileOutputStream(file);
				p = new ObjectOutputStream(g);
				
				try
				{
					do
					{
						p.writeObject(iterate.next());
					} while(iterate.hasNext());
				}
				catch (EOFException e)
				{
					System.err.println("End of file reached");
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
	
	//get next object
	public E getNext(){
		return objectnavigator.next();
	}
	
	//get previous object
	public E getPrevious(){
		return objectnavigator.previous();
	}
}
