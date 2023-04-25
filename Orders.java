package johnDough;
import java.util.*;

import java.util.ArrayList;

public class Orders {
	 //TODO:
	public static ArrayList<Order> inventory = new ArrayList<>();
	int i=1;
	public void placeOrder(String date, String name, HashMap<String, Integer> ordered)
	{
		HashMap<String, Integer> tmp = new HashMap<>();
		tmp.put("Raised Glazed", 0);
		tmp.put("Raised Sugar", 0);
		tmp.put("Raised Chocolate", 0);
		tmp.put("Cake Plain", 0);
		tmp.put("Cake Chocolate", 0);
		tmp.put("Cake Sugar", 0);
		tmp.put("Filled Lemon", 0);
		tmp.put("Filled Grape", 0);
		tmp.put("Filled Custard", 0);
		
		ordered.forEach((s, i) -> {
			tmp.put(s, i);
		});
		
		Order temp = new Order(i, date, name, tmp.get("Raised Glazed"), tmp.get("Raised Sugar"), tmp.get("Raised Chocolate"),  tmp.get("Cake Plain"),
				 tmp.get("Cake Chocolate"), tmp.get("Cake Sugar"), tmp.get("Filled Lemon"), tmp.get("Filled Grape"), tmp.get("Filled Custard"));
		inventory.add(temp);
		this.i++;
	}
	
	public static void printOrder(int index)
	{
		System.out.println("Date: "+inventory.get(index).getDate());
		System.out.println("Name: "+inventory.get(index).getName());
		System.out.println("Total Quantity: "+inventory.get(index).getTotal_quantity());
		System.out.println("Price: "+inventory.get(index).getTotal_price());
		System.out.println("Order ID "+inventory.get(index).getOrder_ID());
		if(inventory.get(index).getGlazed() != 0) {
			System.out.println("Number of Glazed Doughnuts: "+ inventory.get(index).getGlazed());
		}
		if(inventory.get(index).getSugarR() != 0) {
			System.out.println("Number of Raised Sugar Doughnuts: "+ inventory.get(index).getSugarR());
		}
		if(inventory.get(index).getChocolateR() != 0) {
			System.out.println("Number of Raised Chocolate Doughnuts: "+ inventory.get(index).getChocolateR());
		}
		if(inventory.get(index).getPlain() != 0) {
			System.out.println("Number of Plain Cake Doughnuts: "+ inventory.get(index).getPlain());
		}
		if(inventory.get(index).getChocolateC() != 0) {
			System.out.println("Number of Chocolate Cake Doughnuts: "+ inventory.get(index).getChocolateC());
		}
		if(inventory.get(index).getSugarC() != 0) {
			System.out.println("Number of Sugar Cake Doughnuts: "+ inventory.get(index).getSugarC());
		}
		if(inventory.get(index).getLemon() != 0) {
			System.out.println("Number of Lemon Filled Doughnuts: "+ inventory.get(index).getLemon());
		}
		if(inventory.get(index).getGrape() != 0) {
			System.out.println("Number of Grape Filled Doughnuts: "+ inventory.get(index).getGrape());
		}
		if(inventory.get(index).getCustard() != 0) {
			System.out.println("Number of Custard Filled Doughnuts: "+ inventory.get(index).getCustard());
		}
		
		
		
		
		
		/*
		if(inventory.get(index).isIs_processed())
		{
			System.out.println("Order has been processed");
		}else {
			System.out.println("Order has not been processed");
		}
		*/
	}
}
