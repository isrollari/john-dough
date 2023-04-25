package johnDough;
import java.util.*;
import java.io.*;

public class AdminOptions extends Menu {
	HashMap<String, Float> menuOptions = new HashMap<>();
	
	public AdminOptions(File f) throws FileNotFoundException {
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
		int mchoice;
		adminReport reports = new adminReport();
		
		while (true) {
			System.out.println("Please select an option:");
			System.out.println("1. Generate reports");
			System.out.println("2. View menu");
			System.out.println("3. Edit menu");
			
			mchoice = inputsc.nextInt();
			inputsc.nextLine();
			
			switch(mchoice) {
			case 1:
				
				
				break;
			case 2:
				menuOptions.forEach((s, f) -> {
					System.out.println(s+" doughnuts: $"+f);
				});
				
				break;
			case 3:
				break;
			default:
				System.out.println("That's not a valid option");
			}
		}
	}
}
