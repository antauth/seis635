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
	private TextFileRead tfr;
	//private File goalFile;
	
	private int startdate;
	
	private String goaltype;

	private int enddate;
	
	public boolean setGoal (Goal goal){

		//text file in the form:
		//username; startdate; enddate; goaltype
/*
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
		        */
		
			boolean r = tfr.addToText(goal.toString());
			System.out.print("in set Goal " + tfr.textToString());
			return r;
	    }
	
	public Goal (File file){
		//File goalFile= new File ("Goal.txt");
		tfr = new TextFileRead(file);
		
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
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Goal[] getGoal() {

		int ctr=0;
		String s = tfr.textToString();
		System.out.print(s);
		String[] tokens = s.split(";");
		Goal[] goal = new Goal[500];
		System.out.print(tokens.length);
		while(ctr+3<tokens.length){
			goal[ctr] = new Goal(tokens[ctr],
					tokens[ctr+1],
					Integer.parseInt(tokens[ctr+2].trim()),
					Integer.parseInt(tokens[ctr+3].trim()));
			System.out.println(goal.toString());
			System.out.print("CTR is " + ctr);
			ctr=ctr+4;;
		}
		return goal;

	}
	


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File goalFile = new File("Goal.txt");
		Goal goal = new Goal(goalFile);
		goal.setGoal(new Goal("Liz","BeAwesome",1234,56789));
		goal.getGoal();
		goal.setGoal(new Goal("Sue","RunMaybe",1234,56789));
		goal.getGoal();
		
		//goal.getGoal("random user",goalFile);
	}

}
