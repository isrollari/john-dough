package johnDough;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class adminReport {

    private String reportTime;
    private int totalRaised;
    private int glazed;
    private int sugarR;
    private int chocolateR;
    private int totalCake;
    private int plain;
    private int chocolateC;
    private int sugarC;
    private int totalFilled;
    private int lemon;
    private int grape;
    private int custard;
    private int totalPrice;
    private int totalQuantity;
    private int staleDoughnts;
    public static ArrayList<adminReport> adminReportData = new ArrayList<>();
    public static ArrayList<adminReport> adminReportStaleData = new ArrayList<>();

    public adminReport(){
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
                int sugarR = Integer.parseInt(orderStr[3]);
                int chocolateR = Integer.parseInt(orderStr[4]);
                int totalCake = Integer.parseInt(orderStr[5]);
                int plain = Integer.parseInt(orderStr[6]);
                int chocolateC = Integer.parseInt(orderStr[7]);
                int sugarC = Integer.parseInt(orderStr[8]);
                int totalFilled = Integer.parseInt(orderStr[9]);
                int lemon = Integer.parseInt(orderStr[10]);
                int grape = Integer.parseInt(orderStr[11]);
                int custard = Integer.parseInt(orderStr[12]);
                int totalPrice = Integer.parseInt(orderStr[13]);
                int totalQuantity = Integer.parseInt(orderStr[14]);

                adminReport adminreport = new adminReport();
                adminreport.setReportTime(reportTime);
                adminreport.setTotalRaised(totalRaised);
                adminreport.setGlazed(glazed);
                adminreport.setSugarR(sugarR);
                adminreport.setChocolateR(chocolateR);
                adminreport.setTotalCake(totalCake);
                adminreport.setPlain(plain);
                adminreport.setChocolateC(chocolateC);
                adminreport.setSugarC(sugarC);
                adminreport.setTotalFilled(totalFilled);
                adminreport.setLemon(lemon);
                adminreport.setGrape(grape);
                adminreport.setCustard(custard);
                adminreport.setTotalPrice(totalPrice);
                adminreport.setTotalQuantity(totalQuantity);

                adminReportData.add(adminreport);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void adminReportStale(){
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
                csvWriter.append((char) adminreport.getSugarR());
                csvWriter.append(",");
                csvWriter.append((char) adminreport.getChocolateR());
                csvWriter.append(",");
                csvWriter.append((char) adminreport.getTotalCake());
                csvWriter.append(",");
                csvWriter.append((char) adminreport.getPlain());
                csvWriter.append(",");
                csvWriter.append((char) adminreport.getChocolateC());
                csvWriter.append(",");
                csvWriter.append((char) adminreport.getSugarC());
                csvWriter.append(",");
                csvWriter.append((char) adminreport.getTotalFilled());
                csvWriter.append(",");
                csvWriter.append((char) adminreport.getLemon());
                csvWriter.append(",");
                csvWriter.append((char) adminreport.getGrape());
                csvWriter.append(",");
                csvWriter.append((char) adminreport.getCustard());
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

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }
}
