package johnDough;
import java.util.*;
import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class EmployeeMenu {
	//TODO: update(add/remove) inventory information
	public void run() {
		Scanner inputsc = new Scanner(System.in);
		int mchoice, IDchoice, tmp = 0;
		boolean validID;
		
		while (true) {
			System.out.println("Please select an option below:");
			System.out.println("1. View current orders");
			System.out.println("2. Update an order's status to \"processed\"");
			System.out.println("3. Enter inventory information");
			
			mchoice = inputsc.nextInt();
			
			switch(mchoice) {
			case 1:
				for (int i = 0; i < Orders.inventory.size(); i++)
					Orders.printOrder(i);
				
				break;
			case 2:
				System.out.println("Please enter the order's ID that you'd like to update:");
				
				IDchoice = inputsc.nextInt();
				validID = false;
				
				for (int i = 0; i < Orders.inventory.size(); i++) {
					if (Orders.inventory.get(i).order_ID == IDchoice)
						tmp = i;
						validID = true;
				}
				
				if (!validID) {
					System.out.println("That ID isn't in the list of current orders");
					break;
				}
				
				Orders.inventory.get(tmp).setIs_processed(true);
				break;
			case 3:
				//insert inventory stuff here
				break;
			default:
				System.out.println("That's not a valid option");
			}
		}
	}
}
