package activity_tracker;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class Goal extends TextType{

		//constructor
		//where user specific goals are stored
	
		//setGoal
		//goal options: C25K, 5K, 10K, half-marathon, etc
	
		//getGoal
	
	private String username;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getStartdate() {
		return startdate;
	}

	public void setStartdate(int startdate) {
		this.startdate = startdate;
	}

	public String getGoaltype() {
		return goaltype;
	}

	public void setGoaltype(String goaltype) {
		this.goaltype = goaltype;
	}

	public int getEnddate() {
		return enddate;
	}

	public void setEnddate(int enddate) {
		this.enddate = enddate;
	}



	private int startdate;
	
	private String goaltype;

	private int enddate;
	
	BufferedWriter writer;
	
	BufferedReader br;
	
	//FileWriter fw;
	
	public boolean setGoal (String username, String goaltype, int startdate, int enddate,File goalFile){

		//text file in the form:
		//username; startdate; enddate; goaltype

				try {

					BufferedWriter out = new BufferedWriter(new FileWriter(goalFile,true));
					out.newLine();
					out.append(username + ";" + goaltype + ";" + startdate + ";" + enddate + ";");
					
					out.close();
					return true;

		        } catch (IOException e) {
		        	//System.out.print("you fail");
		        	return false;
		        }

	    }
	
	public Goal (){
		
	}
	public String toString(){
		return username + " " + goaltype + " " + startdate + " " + enddate + " ";
	}
	
	public Goal (String username, String goaltype, int startdate, int enddate){
		this.username=username;
		this.goaltype=goaltype;
		this.startdate=startdate;
		this.enddate=enddate;
	}
	   //eventually delete 
	/*
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
	*/


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File goalFile = new File("Goal.txt");
		Goal goal = new Goal();
		goal.setGoal("Liz","BeAwesome",1234,56789,goalFile);
		goal.setGoal("Sue","RunMaybe",1234,56789,goalFile);
		//goal.getGoal("random user",goalFile);
	}

}
