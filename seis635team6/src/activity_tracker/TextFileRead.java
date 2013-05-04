/**
 * 
 */
package activity_tracker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			TextType[] textType = null;
			while ((line = reader.readLine()) != null ) {
				if(type.equals("goal")){	
					int ctr=0;
					int cnt=0;
					String[] tokens = line.split(";");
					
					while(tokens[ctr]!=null){
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

	}

}
