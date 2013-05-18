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
	String filename;
	
	/**
	 * Creates a linked list for objects.
	 * 
	 */
	public GenericActivityFile (){
		objectlist = new LinkedList<E>();
		objectnavigator = objectlist.listIterator();
		filename = "empty.txt";
	}
	
	//read object file
	@SuppressWarnings("unchecked")
	public void readObjectFile(String fn) throws IOException{
		this.setFilename(fn);
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
				System.err.println("IO exception in reader. Filename is".concat(filename));
			} 
			catch (NullPointerException e)
			{
				System.err.println("Null pointer exception");
			}
			finally
			{
				o.close();
			}
			
		}
		//else throw new NullPointerException();
	}
	
	//write to object file
	public void writeObjectFile() throws IOException{
		File file = new File(filename);
		ListIterator<E> iterate = objectlist.listIterator(0);//start at the first item
		System.out.print(objectlist.size());
		
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
				System.err.println("IO exception. Filename is".concat(filename));
			}
			finally
			{
				p.close();
			}
	}
	
	//get next object
	public E getNext()
	{
		if (objectnavigator.hasNext())
			return objectnavigator.next();
		else
			return null;
	}
	
	//get previous object
	public E getPrevious()
	{
		if (objectnavigator.hasPrevious())
			return objectnavigator.previous();
		else
			return null;
	}
	
	public void addObject(E obj)
	{
		objectlist.add(obj);
	}
	
	//get filename
	public String getFilename()
	{
		return filename;
	}
	
	//set filename
	public void setFilename(String f)
	{
		filename = f;
	}
}
