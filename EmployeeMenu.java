package johnDough;
import java.util.*;
import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class EmployeeMenu extends Menu {
	HashMap<String, Float> menuOptions = new HashMap<>();
	
	public EmployeeMenu(File f) throws Exception {
		Scanner filesc = new Scanner(f);
		String doughnutName, tmp;
		float price;
		
		filesc.useDelimiter(",");
		filesc.nextLine();
		
		doughnutName = filesc.next();
		
		while (filesc.hasNext()) {
			tmp = filesc.next();
			price = Float.parseFloat(tmp.split("\n")[0]);
			
			menuOptions.put(doughnutName, price);
			
			if (filesc.hasNext())
				doughnutName = tmp.split("\n")[1];
		}
		
		filesc.close();
	}
	
	public void run() {
		HashMap<String, Integer> ordered = new HashMap<>();
		Scanner inputsc = new Scanner(System.in);
		int mchoice, IDchoice, tmp = 0;
		boolean validID;
		String tmpop, customerName;
		Orders tod = new Orders();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd LLLL yyyy");
		
		while (true) {
			System.out.println("Please select an option below:");
			System.out.println("1. View current orders");
			System.out.println("2. Update an order's status to \"processed\"");
			System.out.println("3. Enter inventory information");
			System.out.println("4. Place an order");
			
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
				break;
			case 4:
				menuOptions.forEach((s, f) -> {
					System.out.println(s+" doughnuts: $"+f);
				});
				System.out.println();
				
				System.out.println("Please enter the number of each type of dougnut you'd like in the form 'doughnut Type, number'.");
				System.out.println("When you're done, type 'place order' and press enter");
				
				while (true) {
					tmpop = inputsc.nextLine();
					
					if (tmpop.equals("place order")) {
						System.out.println("Please enter the customer's name:");
						customerName = inputsc.nextLine();
						
						break;
					} else if (!ordered.containsKey(tmpop.split(",")[0])) {
						System.out.println("That's not a valid doughnut type.");
					} else
						ordered.put(tmpop.split(",")[0], Integer.parseInt(tmpop.split(",")[1].trim()));
				}
				
				tod.placeOrder(LocalDate.now().format(format), customerName, ordered);
				break;
			default:
				System.out.println("That's not a valid option");
			}
		}
	}
}
