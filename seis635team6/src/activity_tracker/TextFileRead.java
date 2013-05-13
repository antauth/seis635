/**
 * 
 */
package activity_tracker;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

/**
 * @author Liz
 *
 */
public class TextFileRead {

	/**
	 * @param args
	 */
	
	File file;
	String type;
	
	public TextFileRead(File file){
		//this.file=file;
		//this.type=type;
		this.file=file;
	}
	/*
	public Goal[] getTextEntries(File file, String type) {
		try{
			Scanner s = new Scanner (new FileReader (file)).useDelimiter(";");
			Goal[] textType = new Goal[500];

			int cnt=0;
			if (type.equals("goal")){
				while(s.hasNext()){
					textType[cnt] = new Goal(s.next(),
							s.next(),
							Integer.parseInt(s.next().trim()),
							Integer.parseInt(s.next().trim()));
					cnt++;
				}
			}
			
			return textType;
		}
		catch(IOException e){
			return null;
		}
	}
	*/
	/*
	 * This method reads a file and converts 
	 * it to a string
	 * 
	 * @param file of type File
	 * @return String - concatenated string
	 * 
	 */
	
	public String textToString() {
		StringBuilder s= new StringBuilder();
		try{
			Scanner sc=new Scanner(file);
			sc.nextLine();		
		while (sc.hasNextLine()) {
			s.append(sc.nextLine());
		   
		}
		sc.close();
		}
		catch(IOException e){
			
		}
		return s.toString();
	}
	/*
	 * This method takes a string and appends
	 * it to a specified text file
	 * 
	 * @param file of type file
	 * @param s of type String
	 * @return boolean : true if successfully written else false
	 * 
	 */
	
	public boolean addToText(String s){
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(file));
			out.newLine();
			out.append(s);
			
			out.close();
			return true;
	
	    } catch (IOException e) {
	    	//System.out.print("you fail");
	    	return false;
	    }
	}


	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		File goalFile = new File("Goal.txt");
		Goal goal = new Goal(goalFile);
		//System.out.print("start " + t.textToString() + " end");
		//TextType[] a = t.getTextEntries();
		//goal.setGoal("Liz","BeAwesome",1234,56789,goalFile);
		//goal.setGoal("Sue","RunMaybe",1234,56789,goalFile);
		//System.out.print(a[0].getUsername());
		goal.setGoal(new Goal("Liz","BeAwesome",1234,56789));
		//goal.getGoal();
		goal.setGoal(new Goal("Sue","RunMaybe",1234,56789));
		//System.out.println("start1 " + t.textToString() + " 1end");
	}*/

}
