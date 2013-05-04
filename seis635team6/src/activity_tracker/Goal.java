package activity_tracker;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class Goal {

		//constructor
		//where user specific goals are stored
	
		//setGoal
		//goal options: C25K, 5K, 10K, half-marathon, etc
	
		//getGoal
	
	private String username;
	
	private long startdate;
	
	private String goaltype;

	private long enddate;
	
	BufferedWriter writer;
	
	BufferedReader br;
	
	//FileWriter fw;
	
	public boolean setGoal (String username, String goaltype, long startdate, long enddate,File goalFile){

		//text file in the form:
		//username; startdate; enddate; goaltype

				try {

					BufferedWriter out = new BufferedWriter(new FileWriter(goalFile,true));
					out.append(username + ";" + startdate + ";" + enddate + ";" + goaltype + ";\n");
					out.newLine();
					out.close();
					return true;

		        } catch (IOException e) {
		        	//System.out.print("you fail");
		        	return false;
		        }

	    }
	
	public Goal (){
		
	}
	
	public Goal (String username, String goaltype, long startdate, long enddate){
		this.username=username;
		this.goaltype=goaltype;
		this.startdate=startdate;
		this.enddate=enddate;
	}
	    
	public void getGoal(String username,File goalFile) {
		
		try{
			BufferedReader reader = new BufferedReader(new FileReader(goalFile));
		String line = null;

		while ((line = reader.readLine()) != null ) {

				String[] tokens = line.split(";");

				for (String t : tokens)
					System.out.print(t + " ");
			
		}
		}
		catch(IOException e){
			
		}
	}


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File goalFile = new File("Goal.txt");
		Goal goal = new Goal();
		goal.setGoal("Liz","BeAwesome",1234,56789,goalFile);
		goal.setGoal("Sue","RunMaybe",1234,56789,goalFile);
		goal.getGoal("random user",goalFile);
	}

}
