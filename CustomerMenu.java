package johnDough;
import java.util.*;
import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class CustomerMenu extends Menu {
	HashMap<String, Float> menuOptions = new HashMap<>();
	
	public CustomerMenu(File f) throws FileNotFoundException {
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
		Scanner inputsc = new Scanner(System.in);
		String tmp, customerName;
		int mchoice;
		HashMap<String, Integer> ordered = new HashMap<>();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd LLLL yyyy");
		Orders tod = new Orders();
		menuOptions.forEach((s, f) -> {
			ordered.put(s, 0);
		});
		
		while(true) {
			System.out.println("Welcome to the Socorro Doughnut Factory. Please select an option below:");
			System.out.println("1. View the menu");
			System.out.println("2. Place an order");
			
			mchoice = inputsc.nextInt();
			inputsc.nextLine();
			
			switch(mchoice) {
			case 1:
				menuOptions.forEach((s, f) -> {
					System.out.println(s+" doughnuts: $"+f);
				});
				break;
			case 2:
				menuOptions.forEach((s, f) -> {
					System.out.println(s+" doughnuts: $"+f);
				});
				System.out.println();
				
				System.out.println("Please enter the number of each type of dougnut you'd like in the form 'doughnut Type, number'.");
				System.out.println("When you're done, type 'place order' and press enter");
				
				while (true) {
					tmp = inputsc.nextLine();
					
					if (tmp.equals("place order")) {
						System.out.println("Please enter your name:");
						customerName = inputsc.nextLine();
						
						break;
					} else if (!ordered.containsKey(tmp.split(",")[0])) {
						System.out.println("That's not a valid doughnut type.");
					} else
						ordered.put(tmp.split(",")[0], Integer.parseInt(tmp.split(",")[1].trim()));
				}
				
				tod.placeOrder(LocalDate.now().format(format), customerName, ordered);
				break;
			default:
				System.out.println("That's not a valid option.");
			}
		}
	}
}
