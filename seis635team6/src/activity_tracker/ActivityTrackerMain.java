package activity_tracker;

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
	 */
	public static void main(String[] args) {
		//instantiate controller class
		Controller controller = new Controller();

		//give control to Controller for display of user prompts
		controller.displayUserPrompt();
	}

}
