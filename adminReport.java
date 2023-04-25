package johnDough;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class adminReport {

    private String reportTime;
    private int totalRaised;
    private int glazed;
    private float priceGlazed;
    private int sugarR;
    private float priceSugarR;
    private int chocolateR;
    private float priceChocolateR;
    private int totalCake;
    private int plain;
    private float pricePlain;
    private int chocolateC;
    private float priceChocolateC;
    private int sugarC;
    private float priceSugarC;
    private int totalFilled;
    private int lemon;
    private float priceLemon;
    private int grape;
    private float priceGrape;
    private int custard;
    private float priceCustard;
    private float totalPrice;
    private int totalQuantity;
    private int staleDoughnts;
    public static ArrayList<adminReport> adminReportData = new ArrayList<>();
    public static ArrayList<adminReport> adminReportStaleData = new ArrayList<>();

    public adminReport(){

    }

    public static void openAdminReport(){
        String csvFile = "admin-report.csv";
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
                String reportTime = (orderStr[0]);
                int totalRaised = Integer.parseInt(orderStr[1]);
                int glazed = Integer.parseInt(orderStr[2]);
                float glazedPrice = Float.parseFloat(orderStr[3]);
                int sugarR = Integer.parseInt(orderStr[4]);
                float sugarRPrice = Float.parseFloat(orderStr[5]);
                int chocolateR = Integer.parseInt(orderStr[6]);
                float chocolateRPrice = Float.parseFloat(orderStr[7]);
                int totalCake = Integer.parseInt(orderStr[8]);
                int plain = Integer.parseInt(orderStr[9]);
                float plainPrice = Float.parseFloat(orderStr[10]);
                int chocolateC = Integer.parseInt(orderStr[11]);
                float chocolateCPrice = Float.parseFloat(orderStr[12]);
                int sugarC = Integer.parseInt(orderStr[13]);
                float sugarCPrice = Float.parseFloat(orderStr[14]);
                int totalFilled = Integer.parseInt(orderStr[15]);
                int lemon = Integer.parseInt(orderStr[16]);
                float lemonPrice = Float.parseFloat(orderStr[17]);
                int grape = Integer.parseInt(orderStr[18]);
                float grapePrice = Float.parseFloat(orderStr[19]);
                int custard = Integer.parseInt(orderStr[20]);
                float custardPrice = Float.parseFloat(orderStr[21]);
                float totalPrice = Float.parseFloat(orderStr[22]);
                int totalQuantity = Integer.parseInt(orderStr[23]);

                adminReport adminreport = new adminReport();
                adminreport.setReportTime(reportTime);
                adminreport.setTotalRaised(totalRaised);
                adminreport.setGlazed(glazed);
                adminreport.setPriceGlazed(glazedPrice);
                adminreport.setSugarR(sugarR);
                adminreport.setPriceSugarR(sugarRPrice);
                adminreport.setChocolateR(chocolateR);
                adminreport.setPriceChocolateR(chocolateRPrice);
                adminreport.setTotalCake(totalCake);
                adminreport.setPlain(plain);
                adminreport.setPricePlain(plainPrice);
                adminreport.setChocolateC(chocolateC);
                adminreport.setPriceChocolateC(chocolateCPrice);
                adminreport.setSugarC(sugarC);
                adminreport.setPriceSugarC(sugarCPrice);
                adminreport.setTotalFilled(totalFilled);
                adminreport.setLemon(lemon);
                adminreport.setPriceLemon(lemonPrice);
                adminreport.setGrape(grape);
                adminreport.setPriceGrape(grapePrice);
                adminreport.setCustard(custard);
                adminreport.setPriceCustard(custardPrice);
                adminreport.setTotalPrice(totalPrice);
                adminreport.setTotalQuantity(totalQuantity);

                adminReportData.add(adminreport);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void openAdminReportStale(){
        String csvFile = "admin-report-stale.csv";
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
                String reportTime = (orderStr[0]);
                int stale = Integer.parseInt(orderStr[1]);

                adminReport adminreport = new adminReport();
                adminreport.setReportTime(reportTime);
                adminreport.setStaleDoughnts(stale);

                adminReportStaleData.add(adminreport);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeAdminReport() {

        FileWriter csvWriter;
        try {
            csvWriter = new FileWriter("doughnut-inventory.xlsx");

            // write the data rows
            for (adminReport adminreport : adminReportData) {
                csvWriter.append(adminreport.getReportTime());
                csvWriter.append(",");
                csvWriter.append((char) adminreport.getTotalRaised());
                csvWriter.append(",");
                csvWriter.append((char) adminreport.getGlazed());
                csvWriter.append(",");
                csvWriter.append((char) adminreport.getPriceGlazed());
                csvWriter.append(",");
                csvWriter.append((char) adminreport.getSugarR());
                csvWriter.append(",");
                csvWriter.append((char) adminreport.getPriceSugarR());
                csvWriter.append(",");
                csvWriter.append((char) adminreport.getChocolateR());
                csvWriter.append(",");
                csvWriter.append((char) adminreport.getPriceChocolateR());
                csvWriter.append(",");
                csvWriter.append((char) adminreport.getTotalCake());
                csvWriter.append(",");
                csvWriter.append((char) adminreport.getPlain());
                csvWriter.append(",");
                csvWriter.append((char) adminreport.getPricePlain());
                csvWriter.append(",");
                csvWriter.append((char) adminreport.getChocolateC());
                csvWriter.append(",");
                csvWriter.append((char) adminreport.getPriceChocolateC());
                csvWriter.append(",");
                csvWriter.append((char) adminreport.getSugarC());
                csvWriter.append(",");
                csvWriter.append((char) adminreport.getPriceSugarC());
                csvWriter.append(",");
                csvWriter.append((char) adminreport.getTotalFilled());
                csvWriter.append(",");
                csvWriter.append((char) adminreport.getLemon());
                csvWriter.append(",");
                csvWriter.append((char) adminreport.getPriceLemon());
                csvWriter.append(",");
                csvWriter.append((char) adminreport.getGrape());
                csvWriter.append(",");
                csvWriter.append((char) adminreport.getPriceGrape());
                csvWriter.append(",");
                csvWriter.append((char) adminreport.getCustard());
                csvWriter.append(",");
                csvWriter.append((char) adminreport.getPriceCustard());
                csvWriter.append(",");
                csvWriter.append((char) adminreport.getTotalPrice());
                csvWriter.append(",");
                csvWriter.append((char) adminreport.getTotalQuantity());
                csvWriter.append(",");

                csvWriter.append("\n");
            }

            System.out.println("Inventory successfully written");

            csvWriter.flush();
            csvWriter.close();

        } catch (IOException e) {
            System.err.println("Error writing inventory to CSV file: " + e.getMessage());
        }
    }

    public static void printAdminReport(){
        for (adminReport adminreport : adminReportData) {
            System.out.println("Report type: "+ adminreport.getReportTime());
            System.out.println("totalRaised: "+ adminreport.getTotalRaised());
            System.out.println("Glazed quantity: " + adminreport.getGlazed());
            System.out.println("Glazed price: " + adminreport.getPriceGlazed());
            System.out.println("SugarR quantity: "+ adminreport.getSugarR());
            System.out.println("SugarR price: "+ adminreport.getPriceSugarR());
            System.out.println("ChocolateR quantity: " + adminreport.getChocolateR());
            System.out.println("ChocolateR price: " + adminreport.getPriceChocolateR());
            System.out.println("totalCake quantity: "+ adminreport.getTotalCake());
            System.out.println("Plain quantity: " + adminreport.getPlain());
            System.out.println("Plain price: " + adminreport.getPricePlain());
            System.out.println("ChocolateC quantity: "+ adminreport.getChocolateC());
            System.out.println("ChocolateC price: "+ adminreport.getPriceChocolateC());
            System.out.println("SugarC quantity: " + adminreport.getSugarC());
            System.out.println("SugarC price: " + adminreport.getPriceSugarC());
            System.out.println("totalFilled: "+ adminreport.getTotalFilled());
            System.out.println("Lemon quantity: " + adminreport.getLemon());
            System.out.println("Lemon price: " + adminreport.getPriceLemon());
            System.out.println("Grape quantity: "+ adminreport.getGrape());
            System.out.println("Grape price: "+ adminreport.getGrape());
            System.out.println("Custard quantity: "+ adminreport.getCustard());
            System.out.println("Custard price: "+ adminreport.getPriceCustard());
            System.out.println("Price: "+ adminreport.getTotalPrice());
            System.out.println("Quantity: "+ adminreport.getTotalQuantity());
            System.out.println();
        }
    }

    public static void printAdminReportStale(){
        for (adminReport adminreport : adminReportStaleData) {
            System.out.println("Report type: "+ adminreport.getReportTime());
            System.out.println("Num of stale: " + adminreport.getStaleDoughnts());
            System.out.println();
        }
    }

    public float getPriceGlazed() {
        return priceGlazed;
    }

    public void setPriceGlazed(float priceGlazed) {
        this.priceGlazed = priceGlazed;
    }

    public float getPriceSugarR() {
        return priceSugarR;
    }

    public void setPriceSugarR(float priceSugarR) {
        this.priceSugarR = priceSugarR;
    }

    public float getPriceChocolateR() {
        return priceChocolateR;
    }

    public void setPriceChocolateR(float priceChocolateR) {
        this.priceChocolateR = priceChocolateR;
    }

    public float getPricePlain() {
        return pricePlain;
    }

    public void setPricePlain(float pricePlain) {
        this.pricePlain = pricePlain;
    }

    public float getPriceChocolateC() {
        return priceChocolateC;
    }

    public void setPriceChocolateC(float priceChocolateC) {
        this.priceChocolateC = priceChocolateC;
    }

    public float getPriceSugarC() {
        return priceSugarC;
    }

    public void setPriceSugarC(float priceSugarC) {
        this.priceSugarC = priceSugarC;
    }

    public float getPriceLemon() {
        return priceLemon;
    }

    public void setPriceLemon(float priceLemon) {
        this.priceLemon = priceLemon;
    }

    public float getPriceGrape() {
        return priceGrape;
    }

    public void setPriceGrape(float priceGrape) {
        this.priceGrape = priceGrape;
    }

    public float getPriceCustard() {
        return priceCustard;
    }

    public void setPriceCustard(float priceCustard) {
        this.priceCustard = priceCustard;
    }

    public float getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getStaleDoughnts() {
        return staleDoughnts;
    }

    public void setStaleDoughnts(int staleDoughnts) {
        this.staleDoughnts = staleDoughnts;
    }

    public String getReportTime() {
        return reportTime;
    }

    public void setReportTime(String reportTime) {
        this.reportTime = reportTime;
    }

    public int getTotalRaised() {
        return totalRaised;
    }

    public void setTotalRaised(int totalRaised) {
        this.totalRaised = totalRaised;
    }

    public int getGlazed() {
        return glazed;
    }

    public void setGlazed(int glazed) {
        this.glazed = glazed;
    }

    public int getSugarR() {
        return sugarR;
    }

    public void setSugarR(int sugarR) {
        this.sugarR = sugarR;
    }

    public int getChocolateR() {
        return chocolateR;
    }

    public void setChocolateR(int chocolateR) {
        this.chocolateR = chocolateR;
    }

    public int getTotalCake() {
        return totalCake;
    }

    public void setTotalCake(int totalCake) {
        this.totalCake = totalCake;
    }

    public int getPlain() {
        return plain;
    }

    public void setPlain(int plain) {
        this.plain = plain;
    }

    public int getChocolateC() {
        return chocolateC;
    }

    public void setChocolateC(int chocolateC) {
        this.chocolateC = chocolateC;
    }

    public int getSugarC() {
        return sugarC;
    }

    public void setSugarC(int sugarC) {
        this.sugarC = sugarC;
    }

    public int getTotalFilled() {
        return totalFilled;
    }

    public void setTotalFilled(int totalFilled) {
        this.totalFilled = totalFilled;
    }

    public int getLemon() {
        return lemon;
    }

    public void setLemon(int lemon) {
        this.lemon = lemon;
    }

    public int getGrape() {
        return grape;
    }

    public void setGrape(int grape) {
        this.grape = grape;
    }

    public int getCustard() {
        return custard;
    }

    public void setCustard(int custard) {
        this.custard = custard;
    }


    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }
}
