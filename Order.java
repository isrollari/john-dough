package johnDough;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Order {
int order_ID;
String date;
String name;
boolean is_processed = false;

int totalRaised=0; 
int Glazed=0;
int SugarR=0;
int ChocolateR=0;

double priceGlazed = 1.25;
double priceSugarR = 1.15;
double priceChocolateR = 1.35;

int totalCake=0;
int Plain=0;
int ChocolateC=0;
int SugarC=0;

double pricePlain = 1.00;
double priceChocolateC = 1.40;
double priceSugarC = 1.20;

int totalFilled=0;
int Lemon=0;
int Grape=0;
int Custard=0;

double priceLemon = 1.75;
double priceGrape = 1.75;
double priceCustard = 2.00;

int total_quantity;
double total_price;

public static ArrayList<Order> OrderList = new ArrayList<>();

public Order(){

}

public Order(int order_ID, String date, String name, int glazed, int sugarR, int chocolateR, int plain,
		int chocolateC, int sugarC, int lemon, int grape, int custard) {
	super();
	this.order_ID = order_ID;
	this.date = date;
	this.name = name;
	Glazed = glazed;
	SugarR = sugarR;
	ChocolateR = chocolateR;
	Plain = plain;
	ChocolateC = chocolateC;
	SugarC = sugarC;
	Lemon = lemon;
	Grape = grape;
	Custard = custard;
	this.totalRaised = Glazed +  SugarR + ChocolateR;
	this.totalCake = Plain +  SugarC + ChocolateC;
	this.totalFilled = Lemon + Grape  + Custard;
	this.total_quantity = totalRaised + totalCake + totalFilled;
	this.total_price = (Glazed * priceGlazed) + (ChocolateR * priceChocolateR) + (SugarR * priceSugarR);
	this.total_price += (SugarC * priceSugarC)+(ChocolateC * priceChocolateC)+(Plain * pricePlain);
	this.total_price += (Lemon * priceLemon)+(Grape * priceGrape)+(Custard *priceCustard);
}

	public static void openOrder(){

		String csvFile = "order-history.csv";
		String line = "";
		String csvSplitBy = ",";
		int count = 0;

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

			while ((line = br.readLine()) != null) {

				if (count == 0) {
					count++;
					continue; // skip the first line
				}

				String[] orderStr = line.split(csvSplitBy);

				// Access the order data using the index of the array
				int orderId = Integer.parseInt(orderStr[0]);
				String date = orderStr[2];
				String name = orderStr[1];
				int totalRaised = Integer.parseInt(orderStr[3]);
				int glazed = Integer.parseInt(orderStr[4]);
				int sugarR = Integer.parseInt(orderStr[5]);
				int chocolateR = Integer.parseInt(orderStr[6]);
				int totalCake = Integer.parseInt(orderStr[7]);
				int plain = Integer.parseInt(orderStr[8]);
				int chocolateC = Integer.parseInt(orderStr[9]);
				int sugarC = Integer.parseInt(orderStr[10]);
				int totalFilled = Integer.parseInt(orderStr[11]);
				int lemon = Integer.parseInt(orderStr[12]);
				int grape = Integer.parseInt(orderStr[13]);
				int custard = Integer.parseInt(orderStr[14]);

				Order order = new Order();
				order.setOrder_ID(orderId);
				order.setDate(name);
				order.setName(date);
				order.setTotalRaised(totalRaised);
				order.setGlazed(glazed);
				order.setSugarR(sugarR);
				order.setChocolateR(chocolateR);
				order.setTotalCake(totalCake);
				order.setPlain(plain);
				order.setChocolateC(chocolateC);
				order.setSugarC(sugarC);
				order.setTotalFilled(totalFilled);
				order.setLemon(lemon);
				order.setGrape(grape);
				order.setCustard(custard);
				OrderList.add(order);

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void writeOrder() {

		FileWriter csvWriter;
		try {
			csvWriter = new FileWriter("order-history.xlsx");

			// write the data rows
			for (Order order : OrderList) {
				csvWriter.append((char) order.getOrder_ID());
				csvWriter.append(",");
				csvWriter.append(order.getDate());
				csvWriter.append(",");
				csvWriter.append(order.getName());
				csvWriter.append(",");
				csvWriter.append((char) order.getTotalRaised());
				csvWriter.append(",");
				csvWriter.append((char) order.getGlazed());
				csvWriter.append(",");
				csvWriter.append((char) order.getSugarR());
				csvWriter.append(",");
				csvWriter.append((char) order.getChocolateR());
				csvWriter.append(",");
				csvWriter.append((char) order.getTotalCake());
				csvWriter.append(",");
				csvWriter.append((char) order.getPlain());
				csvWriter.append(",");
				csvWriter.append((char) order.getChocolateC());
				csvWriter.append(",");
				csvWriter.append((char) order.getSugarC());
				csvWriter.append(",");
				csvWriter.append((char) order.getTotalFilled());
				csvWriter.append(",");
				csvWriter.append((char) order.getLemon());
				csvWriter.append(",");
				csvWriter.append((char) order.getGrape());
				csvWriter.append(",");
				csvWriter.append((char) order.getCustard());
				csvWriter.append("\n");
			}

			System.out.println("Inventory successfully written");

			csvWriter.flush();
			csvWriter.close();

		} catch (IOException e) {
			System.err.println("Error writing inventory to CSV file: " + e.getMessage());
		}
	}

	public static void printOrders(){
		for (Order order : OrderList) {
			System.out.println("OrderID: " + order.getOrder_ID());
			System.out.println("Date: "+ order.getDate());
			System.out.println("Name: " + order.getName());
			System.out.println("totalRaised: "+ order.getTotalRaised());
			System.out.println("Glazed: " + order.getGlazed());
			System.out.println("SugarR: "+ order.getSugarR());
			System.out.println("ChocolateR: " + order.getChocolateR());
			System.out.println("totalCake: "+ order.getTotalCake());
			System.out.println("Plain: " + order.getPlain());
			System.out.println("ChocolateC: "+ order.getChocolateC());
			System.out.println("SugarC: " + order.getSugarC());
			System.out.println("totalFilled: "+ order.getTotalFilled());
			System.out.println("Lemon: " + order.getLemon());
			System.out.println("Grape: "+ order.getGrape());
			System.out.println("Custard: "+ order.getCustard());
			System.out.println();
		}
	}

	public void setOrder_ID(int order_ID) {
		this.order_ID = order_ID;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTotalRaised(int totalRaised) {
		this.totalRaised = totalRaised;
	}

	public void setGlazed(int glazed) {
		Glazed = glazed;
	}

	public void setSugarR(int sugarR) {
		SugarR = sugarR;
	}

	public void setChocolateR(int chocolateR) {
		ChocolateR = chocolateR;
	}

	public void setTotalCake(int totalCake) {
		this.totalCake = totalCake;
	}

	public void setPlain(int plain) {
		Plain = plain;
	}

	public void setChocolateC(int chocolateC) {
		ChocolateC = chocolateC;
	}

	public void setSugarC(int sugarC) {
		SugarC = sugarC;
	}

	public void setTotalFilled(int totalFilled) {
		this.totalFilled = totalFilled;
	}

	public void setLemon(int lemon) {
		Lemon = lemon;
	}

	public void setGrape(int grape) {
		Grape = grape;
	}

	public void setCustard(int custard) {
		Custard = custard;
	}

	public void setTotal_quantity(int total_quantity) {
		this.total_quantity = total_quantity;
	}

	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}

	public void setIs_processed(boolean is_processed) {
	this.is_processed = is_processed;
}


public int getOrder_ID() {
	return order_ID;
}


public String getDate() {
	return date;
}


public String getName() {
	return name;
}


public boolean isIs_processed() {
	return is_processed;
}


public int getTotalRaised() {
	return totalRaised;
}


public int getGlazed() {
	return Glazed;
}


public int getSugarR() {
	return SugarR;
}


public int getChocolateR() {
	return ChocolateR;
}


public double getPriceGlazed() {
	return priceGlazed;
}


public double getPriceSugarR() {
	return priceSugarR;
}


public double getPriceChocolateR() {
	return priceChocolateR;
}


public int getTotalCake() {
	return totalCake;
}


public int getPlain() {
	return Plain;
}


public int getChocolateC() {
	return ChocolateC;
}


public int getSugarC() {
	return SugarC;
}


public double getPricePlain() {
	return pricePlain;
}


public double getPriceChocolateC() {
	return priceChocolateC;
}


public double getPriceSugarC() {
	return priceSugarC;
}


public int getTotalFilled() {
	return totalFilled;
}


public int getLemon() {
	return Lemon;
}


public int getGrape() {
	return Grape;
}


public int getCustard() {
	return Custard;
}


public double getPriceLemon() {
	return priceLemon;
}


public double getPriceGrape() {
	return priceGrape;
}


public double getPriceCustard() {
	return priceCustard;
}


public int getTotal_quantity() {
	return total_quantity;
}


public double getTotal_price() {
	return total_price;
}




}
