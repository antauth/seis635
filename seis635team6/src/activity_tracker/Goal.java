package activity_tracker;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


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
	
	FileWriter fw;
	
	public Goal (String username, String goaltype, long startdate, long enddate){
		this.username=username;
		this.goaltype=goaltype;
		this.startdate=startdate;
		this.enddate=enddate;
		//text file in the form:
		//username; startdate; enddate; goaltype


				try {
					fw = new FileWriter("Goal.txt");
					BufferedWriter out = new BufferedWriter(fw);
					//out.newLine();
					out.append(username + ";" + startdate + ";" + enddate + ";" + goaltype + ";" +"\n");
					out.close();
		        //System.out.print("I should have printed something");
		        } catch (IOException e) {
		        	System.out.print("you fail");
		        }
	    }
	
	public Goal (){
		
	}
	    
	public void getGoal(String username) {
		//Goal goal = new Goal();
		
		try{
		//BufferedReader reader = new BufferedReader(new FileReader("/path/to/file.txt"));
			BufferedReader reader = new BufferedReader(new FileReader("Goal.txt"));
		String line = null;
		int ctr=0;
		//while ((line = reader.readLine()) != null){
		while ((line = reader.readLine()) != null ) {
			//ctr=0;
			//while (ctr<4) {
			//String s = "prefix/dir1/dir2/dir3/dir4";
				String[] tokens = line.split(";");

				for (String t : tokens)
					System.out.print(t + " ");
				
			ctr ++;
			//}
			
		}
		}
		catch(IOException e){
			
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public long getStartdate() {
		return startdate;
	}

	public void setStartdate(long startdate) {
		this.startdate = startdate;
	}

	public String getGoaltype() {
		return goaltype;
	}

	public void setGoaltype(String goaltype) {
		this.goaltype = goaltype;
	}

	public long getEnddate() {
		return enddate;
	}

	public void setEnddate(long enddate) {
		this.enddate = enddate;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Goal goal = new Goal("Liz","BeAwesome",1234, 56789);
		goal = new Goal("Pat","RunMaybe",1234, 56789);
		goal.getGoal("random user");
	}

}
