package johnDough;
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO initially call Trays file generation, prompt for user(customer, employee, admin), run relevant menu.
		String EmployeePasskey = "ExamplePassword";
		String AdminPasskey = "AdminPassword";
		Scanner inputsc = new Scanner(System.in);
		int mchoice;
		String enteredKey;
		Menu menu = new AdminOptions();
		File FactoryMenu = new File("C:\\Users\\Orion Joseph\\eclipse-workspace\\John-Dough\\src\\johnDough\\menu.csv");
		File DoughnutInventory = new File("C:\\Users\\Orion Joseph\\eclipse-workspace\\John-Dough\\src\\johnDough\\doughnut-inventory.csv");
		
		System.out.println("Please select which menu to run:");
		System.out.println("1. Customer Menu");
		System.out.println("2. Employee Menu");
		System.out.println("3. Admin Menu");
		
		mchoice = inputsc.nextInt();
		inputsc.nextLine();
		
		switch (mchoice) {
		case 1:
			menu = new CustomerMenu(FactoryMenu);
			break;
		case 2:
			System.out.println("Please enter the employee passkey:");
			enteredKey = inputsc.nextLine();
			
			if (!enteredKey.equals(EmployeePasskey)) {
				System.out.println("That's not the correct password");
				System.exit(1);
			}
			
			Trays inventory = new Trays(DoughnutInventory);
			
			menu = new EmployeeMenu(FactoryMenu, inventory);
			break;
		case 3:
			System.out.println("Please enter the admin passkey:");
			enteredKey = inputsc.nextLine();
			
			if (!enteredKey.equals(AdminPasskey)) {
				System.out.println("That's not the correct password");
				System.exit(1);
			}
			
			menu = new AdminOptions();
			break;
		default:
			System.out.println("That's not a valid option");
			System.exit(1);
		}
		
		menu.run();
		inputsc.close();
	}

}
