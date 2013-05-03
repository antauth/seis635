package RunScheduler;

import java.io.*;

public class Goal {
	
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
		System.out.print("you might still succeed?");
		//text file in the form:
		//username; startdate; enddate; goaltype
		
		/*
		 * BufferedReader br = new BufferedReader(new FileReader("file.txt"));
    try {
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        while (line != null) {
            sb.append(line);
            sb.append("\n");
            line = br.readLine();
        }
        String everything = sb.toString();
    } finally {
        br.close();
    }
		 */

				try {
					fw = new FileWriter("Goal.txt");
					BufferedWriter out = new BufferedWriter(fw);
					//out.newLine();
					out.write(username + "; " + startdate + "; " + enddate + "; " + goaltype + ";");
					out.close();
		        System.out.print("I should have printed something");
		        } catch (IOException e) {
		        	System.out.print("you fail");
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
		Goal goal = new Goal("Liz","Be Awesome",1234, 56789);
	}
}
