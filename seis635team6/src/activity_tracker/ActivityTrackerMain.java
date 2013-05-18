package activity_tracker;

import java.io.IOException;

/**
 * 
 * @author Antoinette
 *
 */
public class ActivityTrackerMain {
	
	/**
	 * Required main method for Java programs.
	 * However, all logic carried out in Controller class.
	 * @param args
	 * @throws IOException 
	 */
	
	public static void main(String[] args) throws IOException {
		
		//instantiate controller class
		Controller controller = new Controller();
		controller.displayUserPrompt();
		//give control to Controller for display of user prompts
		
	}

}
