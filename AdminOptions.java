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

	public void run() throws FileNotFoundException {
		Scanner inputsc = new Scanner(System.in);
		int mchoice, schoice;
		String tmp;
		float newprice;
		
		while (true) {
			System.out.println("Please select an option:");
			System.out.println("1. Generate reports");
			System.out.println("2. View menu");
			System.out.println("3. Edit menu");
			System.out.println("4. Change factory output");
			System.out.println("5. Exit the program");
			
			mchoice = inputsc.nextInt();
			inputsc.nextLine();
			
			switch(mchoice) {
			case 1:
				System.out.println("Please select a report to generate:");
				System.out.println("1. Sales summary");
				System.out.println("2. Stale doughnut summary");
				
				schoice = inputsc.nextInt();
				inputsc.nextLine();
				
				switch(schoice) {
				case 1:
					adminReport.generateAdminReport();
					adminReport.writeAdminReport();
					break;
				case 2:
					adminReport.generateAdminReportStale();
					adminReport.writeAdminReportStale();
					break;
				default:
					System.out.println("That's not a valid option");
				}
				
				break;
			case 2:
				menuOptions.forEach((s, f) -> {
					System.out.println(s+" doughnuts: $"+f);
				});
				
				break;
			case 3:
				System.out.println("Please enter the doughnut type to change the price point of:");
				tmp = inputsc.nextLine();
				
				if (!menuOptions.containsKey(tmp))
					System.out.println("That isn't in the list");
					
				System.out.println("Please enter the new price point:");
				newprice = inputsc.nextFloat();
				inputsc.nextLine();
				
				menuOptions.put(tmp, newprice);
				
				try {
					FileWriter csvwriter = new FileWriter("menu.csv");
					
					csvwriter.flush();
					
					menuOptions.forEach((s,f) -> {
						try {
							csvwriter.append(s);
							csvwriter.append(",");
							csvwriter.append(String.valueOf(f));
						} catch (IOException e) {
							System.out.println("Error writing to file");
							e.printStackTrace();
						}
					});
					
					csvwriter.close();
				} catch(IOException e) {
					System.out.println("Error reading file");
					System.exit(1);
				}
				
				break;
			case 4:
				System.out.println("Please enter a new number of doughnuts to produce:");
				
				schoice = inputsc.nextInt();
				inputsc.nextLine();
				
				Orders.DailyDoughnuts = schoice;
				
				break;
			case 5:
				System.out.println("Exiting the program");
				System.exit(0);
				break;
			default:
				System.out.println("That's not a valid option");
			}
		}
	}
}
