/**
 * 
 */
package activity_tracker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
	
	public TextFileRead(File file, String type){
		this.file=file;
		this.type=type;
	}
	
	public TextType[] getTextEntries() {
		try{
			Scanner s = new Scanner (new FileReader (file)).useDelimiter(";");
			TextType[] textType = new TextType[500];

			int cnt=0;
			if (type.equals("goal")){
				while(s.hasNext()){
					textType[cnt] = new Goal(s.next(),
							s.next(),
							Long.parseLong(s.next().trim()),
							Long.parseLong(s.next().trim()));
					
					cnt++;
				}
			}
			/*else if (type.equals("schedule")){
				while(s.hasNext()){
					//Schedule (int d, String a, String u, float dist, String t)
					textType[cnt] = new Schedule(Integer.parseInt(s.next().trim()), s.next(),
							s.next(),Float.parseFloat(s.next().trim()),s.next());
					cnt++;
				}
			}
			*/
			
			return textType;
		}
		catch(IOException e){
			return null;
		}
	}

	
	
	private void elseif() {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File goalFile = new File("Goal.txt");
		Goal goal = new Goal();
		TextFileRead t = new TextFileRead(goalFile,"goal");
		TextType[] a = t.getTextEntries();
		//goal.setGoal("Liz","BeAwesome",1234,56789,goalFile);
		//goal.setGoal("Sue","RunMaybe",1234,56789,goalFile);
		//System.out.print(a[0].getUsername());
	}

}
