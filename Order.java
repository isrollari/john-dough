package johnDough;

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
