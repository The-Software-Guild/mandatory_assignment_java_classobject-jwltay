import com.controller.DvdController;
import com.view.DvdLibraryView;


public class DvdLibraryApp {
	public static void main(String[] args) {
		
		DvdLibraryView view = new DvdLibraryView();
		DvdController controller = new DvdController();
		Boolean keepRunning = true;
		
		System.out.println("Welcome to the Java DVD Library. What would you like to do?");
		
		while (keepRunning) {
		view.listMenuOptions();
		
		int menuChoice = view.requestNumberInput("index of your choice");
		
		switch(menuChoice) {
			case 1:
				System.out.println("---ADD A DVD---");
				controller.addDvd();
				System.out.println("New DVD created.");
				break;
			case 2:
				System.out.println("---REMOVE A DVD---");
				controller.removeDvd();
				System.out.println("DVD deleted.");
				break;
			case 3:
				System.out.println("---EDIT A DVD---");
				controller.editDvd();
				break;
			case 4:
				System.out.println("---VIEW ALL DVDS---");
				System.out.println("DVDS in library:");
				controller.listDvds();
				break;
			case 5:
				System.out.println("---VIEW A DVD'S DETAILS---");
				// view asks for number and sends it to controller
				controller.showDvdDetails();
				break;
			case 6:
				System.out.println("---SEARCH FOR A DVD---");
				controller.searchDvds();
				break;
			case 7:
				System.out.println("---LOAD DVDS FROM FILE---");
				controller.getDvds();
				break;
			case 8:
				System.out.println("---SAVE DVDS TO FILE---");
				controller.setDvds();
				break;
			case 9:
				System.out.println("---EXIT---");
				System.out.println("Goodbye!");
				keepRunning = false;
				break;
			default:
				System.out.println("Please select one of the options above.");
			}
		}
			
	}

}
