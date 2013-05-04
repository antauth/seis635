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
			//BufferedReader reader = new BufferedReader(new FileReader(file));
			Scanner s = new Scanner (new FileReader (file)).useDelimiter(";");
			//String line = null;
			TextType[] textType = new TextType[500];

			int cnt=0;
			
			while(s.hasNext()){
				/*System.out.print(s.next());
				System.out.print(s.next());
				String firstlong=s.next();
				long l = Long.parseLong(s.next().trim());
				System.out.print(l);
				*/
				//System.out.print(cnt);
				textType[cnt] = new Goal(s.next(),
						s.next(),
						Long.parseLong(s.next().trim()),
						Long.parseLong(s.next().trim()));
				//System.out.print(textType[cnt].getUsername());
				//System.out.print(textType[cnt].getStartdate());
				cnt++;
				//System.out.print(s.hasNext());
			/*while ((line = reader.readLine()) != null ) {
				if(type.equals("goal")){	
					int ctr=0;
					int cnt=0;
					
					String[] tokens = line.split(";");
					System.out.print(tokens.length);
					System.out.print(tokens[0]);
					System.out.print(tokens[1]);
					System.out.print(tokens[2]);
					while(ctr<tokens.length){
						textType[cnt] = new Goal(tokens[ctr],tokens[ctr+1],Long.parseLong(tokens[ctr+2]),
								Long.parseLong(tokens[ctr+3]));
						cnt++;
						ctr=ctr+4;
					}
					//for (String t : tokens)
					//	System.out.print(t + " ");
				}
				else if(type.equals("activity")){
					
				}
				else if(type.equals("schedule")){
					
				}
			}
			*/
			}
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
