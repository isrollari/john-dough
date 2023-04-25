package johnDough;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
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
    public static ArrayList<adminReport> adminReportStaleData = new ArrayList<>();
    public static ArrayList<adminReport> adminReportWeekly = new ArrayList<>();
    public static ArrayList<adminReport> adminReportMonthly = new ArrayList<>();
    public static ArrayList<adminReport> adminReportYearly = new ArrayList<>();
    public static ArrayList<adminReport> adminReportWeeklyStale = new ArrayList<>();
    public static ArrayList<adminReport> adminReportMonthlyStale = new ArrayList<>();
    public static ArrayList<adminReport> adminReportYearlyStale = new ArrayList<>();


    public adminReport(){

    }

    public static void generateAdminReport() throws FileNotFoundException{

        String datatestprices[] = {};

        double prices[] = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        int j = 0;
        int weekcount = 0, monthcount = 0, yearcount = 0;

        try {
            File myObj = new File("menu.csv");
            Scanner myScanner = new Scanner(myObj);

            myScanner.nextLine();

            while(myScanner.hasNextLine()){
                String data = myScanner.nextLine();
                datatestprices = data.split(",");

                Double temp = Double.parseDouble(datatestprices[1]);

                prices[j] = temp;

                j++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error has occured, the file was not found");
            e.printStackTrace();
        }

        double priceGlazed = prices[0];
        double priceSugarR = prices[1];
        double priceChocolateR = prices[2];
        double pricePlain = prices[3];
        double priceChocolateC = prices[4];
        double priceSugarC = prices[5];
        double priceLemon = prices[6];
        double priceGrape = prices[7];
        double priceCustard = prices[8];

        DateTimeFormatter format = DateTimeFormatter.ofPattern("M/d/yyyy");
        LocalDate currentDate = LocalDate.now();

        File FmyObj = new File("order-history.csv");
        Scanner filesc = new Scanner(FmyObj);
        String datatest[] = {};

        filesc.nextLine();

        while(filesc.hasNextLine()) {
            String data = filesc.nextLine();
            datatest = data.split(",");

            LocalDate date = LocalDate.now();

            if(LocalDate.parse(datatest[1], format).isBefore(date.minusDays(7))){

            }
            else{
                adminReport adminreport = new adminReport();

                adminreport.setTotalRaised(Integer.parseInt(datatest[3]));
                adminreport.setGlazed(Integer.parseInt(datatest[4]));
                adminreport.setPriceGlazed((float) (Double.parseDouble(datatest[4]) * priceGlazed));
                adminreport.setSugarR(Integer.parseInt(datatest[5]));
                adminreport.setPriceSugarR((float) (Double.parseDouble(datatest[5]) * priceSugarR));
                adminreport.setChocolateR(Integer.parseInt(datatest[6]));
                adminreport.setPriceChocolateR((float) (Double.parseDouble(datatest[6]) * priceChocolateR));
                adminreport.setTotalCake(Integer.parseInt(datatest[7]));
                adminreport.setPlain(Integer.parseInt(datatest[8]));
                adminreport.setPricePlain((float) (Double.parseDouble(datatest[8]) * pricePlain));
                adminreport.setChocolateC(Integer.parseInt(datatest[9]));
                adminreport.setPriceChocolateC((float) (Double.parseDouble(datatest[9]) * priceChocolateC));
                adminreport.setSugarC(Integer.parseInt(datatest[10]));
                adminreport.setPriceSugarC((float) (Double.parseDouble(datatest[10]) * priceSugarC));
                adminreport.setTotalFilled(Integer.parseInt(datatest[11]));
                adminreport.setLemon(Integer.parseInt(datatest[12]));
                adminreport.setPriceLemon((float) (Double.parseDouble(datatest[12]) * priceLemon));
                adminreport.setGrape(Integer.parseInt(datatest[13]));
                adminreport.setPriceGrape((float) (Double.parseDouble(datatest[13]) * priceGrape));
                adminreport.setCustard(Integer.parseInt(datatest[14]));
                adminreport.setPriceCustard((float) (Double.parseDouble(datatest[14]) * priceCustard));
                adminreport.setTotalQuantity(Integer.parseInt(datatest[4]) + Integer.parseInt(datatest[5]) + Integer.parseInt(datatest[5]) + Integer.parseInt(datatest[8]) +
                        Integer.parseInt(datatest[9]) + Integer.parseInt(datatest[10]) + Integer.parseInt(datatest[12]) + Integer.parseInt(datatest[13]) + Integer.parseInt(datatest[14]));
                adminreport.setTotalPrice((float) (Double.parseDouble(datatest[4]) * priceGlazed) + (float) (Double.parseDouble(datatest[5]) * priceGlazed) + (float) (Double.parseDouble(datatest[6]) * priceGlazed) +
                        (float) (Double.parseDouble(datatest[8]) * priceGlazed) + (float) (Double.parseDouble(datatest[9]) * priceGlazed) + (float) (Double.parseDouble(datatest[10]) * priceGlazed) +
                        (float) (Double.parseDouble(datatest[12]) * priceGlazed) + (float) (Double.parseDouble(datatest[13]) * priceGlazed) + (float) (Double.parseDouble(datatest[14]) * priceGlazed));
                adminReportWeekly.add(adminreport);
            }

            if(LocalDate.parse(datatest[1], format).isBefore(date.minusDays(31))){

            }
            else{
                adminReport adminreport = new adminReport();

                adminreport.setTotalRaised(Integer.parseInt(datatest[3]));
                adminreport.setGlazed(Integer.parseInt(datatest[4]));
                adminreport.setPriceGlazed((float) (Double.parseDouble(datatest[4]) * priceGlazed));
                adminreport.setSugarR(Integer.parseInt(datatest[5]));
                adminreport.setPriceSugarR((float) (Double.parseDouble(datatest[5]) * priceSugarR));
                adminreport.setChocolateR(Integer.parseInt(datatest[6]));
                adminreport.setPriceChocolateR((float) (Double.parseDouble(datatest[6]) * priceChocolateR));
                adminreport.setTotalCake(Integer.parseInt(datatest[7]));
                adminreport.setPlain(Integer.parseInt(datatest[8]));
                adminreport.setPricePlain((float) (Double.parseDouble(datatest[8]) * pricePlain));
                adminreport.setChocolateC(Integer.parseInt(datatest[9]));
                adminreport.setPriceChocolateC((float) (Double.parseDouble(datatest[9]) * priceChocolateC));
                adminreport.setSugarC(Integer.parseInt(datatest[10]));
                adminreport.setPriceSugarC((float) (Double.parseDouble(datatest[10]) * priceSugarC));
                adminreport.setTotalFilled(Integer.parseInt(datatest[11]));
                adminreport.setLemon(Integer.parseInt(datatest[12]));
                adminreport.setPriceLemon((float) (Double.parseDouble(datatest[12]) * priceLemon));
                adminreport.setGrape(Integer.parseInt(datatest[13]));
                adminreport.setPriceGrape((float) (Double.parseDouble(datatest[13]) * priceGrape));
                adminreport.setCustard(Integer.parseInt(datatest[14]));
                adminreport.setPriceCustard((float) (Double.parseDouble(datatest[14]) * priceCustard));
                adminreport.setTotalQuantity(Integer.parseInt(datatest[4]) + Integer.parseInt(datatest[5]) + Integer.parseInt(datatest[5]) + Integer.parseInt(datatest[8]) +
                        Integer.parseInt(datatest[9]) + Integer.parseInt(datatest[10]) + Integer.parseInt(datatest[12]) + Integer.parseInt(datatest[13]) + Integer.parseInt(datatest[14]));
                adminreport.setTotalPrice((float) (Double.parseDouble(datatest[4]) * priceGlazed) + (float) (Double.parseDouble(datatest[5]) * priceGlazed) + (float) (Double.parseDouble(datatest[6]) * priceGlazed) +
                        (float) (Double.parseDouble(datatest[8]) * priceGlazed) + (float) (Double.parseDouble(datatest[9]) * priceGlazed) + (float) (Double.parseDouble(datatest[10]) * priceGlazed) +
                        (float) (Double.parseDouble(datatest[12]) * priceGlazed) + (float) (Double.parseDouble(datatest[13]) * priceGlazed) + (float) (Double.parseDouble(datatest[14]) * priceGlazed));

                adminReportMonthly.add(adminreport);
            }

            if(LocalDate.parse(datatest[1], format).isBefore(date.minusDays(365))){

            }
            else{
                adminReport adminreport = new adminReport();

                adminreport.setTotalRaised(Integer.parseInt(datatest[3]));
                adminreport.setGlazed(Integer.parseInt(datatest[4]));
                adminreport.setPriceGlazed((float) (Double.parseDouble(datatest[4]) * priceGlazed));
                adminreport.setSugarR(Integer.parseInt(datatest[5]));
                adminreport.setPriceSugarR((float) (Double.parseDouble(datatest[5]) * priceSugarR));
                adminreport.setChocolateR(Integer.parseInt(datatest[6]));
                adminreport.setPriceChocolateR((float) (Double.parseDouble(datatest[6]) * priceChocolateR));
                adminreport.setTotalCake(Integer.parseInt(datatest[7]));
                adminreport.setPlain(Integer.parseInt(datatest[8]));
                adminreport.setPricePlain((float) (Double.parseDouble(datatest[8]) * pricePlain));
                adminreport.setChocolateC(Integer.parseInt(datatest[9]));
                adminreport.setPriceChocolateC((float) (Double.parseDouble(datatest[9]) * priceChocolateC));
                adminreport.setSugarC(Integer.parseInt(datatest[10]));
                adminreport.setPriceSugarC((float) (Double.parseDouble(datatest[10]) * priceSugarC));
                adminreport.setTotalFilled(Integer.parseInt(datatest[11]));
                adminreport.setLemon(Integer.parseInt(datatest[12]));
                adminreport.setPriceLemon((float) (Double.parseDouble(datatest[12]) * priceLemon));
                adminreport.setGrape(Integer.parseInt(datatest[13]));
                adminreport.setPriceGrape((float) (Double.parseDouble(datatest[13]) * priceGrape));
                adminreport.setCustard(Integer.parseInt(datatest[14]));
                adminreport.setPriceCustard((float) (Double.parseDouble(datatest[14]) * priceCustard));
                adminreport.setTotalQuantity(Integer.parseInt(datatest[4]) + Integer.parseInt(datatest[5]) + Integer.parseInt(datatest[5]) + Integer.parseInt(datatest[8]) +
                        Integer.parseInt(datatest[9]) + Integer.parseInt(datatest[10]) + Integer.parseInt(datatest[12]) + Integer.parseInt(datatest[13]) + Integer.parseInt(datatest[14]));
                adminreport.setTotalPrice((float) (Double.parseDouble(datatest[4]) * priceGlazed) + (float) (Double.parseDouble(datatest[5]) * priceGlazed) + (float) (Double.parseDouble(datatest[6]) * priceGlazed) +
                        (float) (Double.parseDouble(datatest[8]) * priceGlazed) + (float) (Double.parseDouble(datatest[9]) * priceGlazed) + (float) (Double.parseDouble(datatest[10]) * priceGlazed) +
                        (float) (Double.parseDouble(datatest[12]) * priceGlazed) + (float) (Double.parseDouble(datatest[13]) * priceGlazed) + (float) (Double.parseDouble(datatest[14]) * priceGlazed));

                adminReportYearly.add(adminreport);
            }

        }
        filesc.close();

        System.out.print("Week: " + weekcount + " Month: " + monthcount + " Year: " + yearcount + "\n");
    }

    public static void generateAdminReportStale() throws FileNotFoundException{

        DateTimeFormatter format = DateTimeFormatter.ofPattern("M/d/yyyy");
        LocalDate currentDate = LocalDate.now();

        File FmyObj = new File("doughnut-inventory.csv");
        Scanner filesc = new Scanner(FmyObj);
        String datatest[] = {};

        filesc.nextLine();

        while(filesc.hasNextLine()) {
            String data = filesc.nextLine();
            datatest = data.split(",");

            if(Integer.parseInt(datatest[3]) < 7 && Integer.parseInt(datatest[3]) > 1){
                adminReport adminreport = new adminReport();

                int targetAge = Integer.parseInt((datatest[3]));

                if(targetAge >= 2){
                    adminreport.setTotalQuantity(Integer.parseInt(datatest[2]));

                    adminReportWeeklyStale.add(adminreport);
                }
            }

            if(Integer.parseInt(datatest[3]) < 31 && Integer.parseInt(datatest[3]) > 1){
                adminReport adminreport = new adminReport();

                int targetAge = Integer.parseInt((datatest[3]));

                if(targetAge >= 2){
                    adminreport.setTotalQuantity(Integer.parseInt(datatest[2]));

                    adminReportMonthlyStale.add(adminreport);
                }
            }

            if(Integer.parseInt(datatest[3]) < 365 && Integer.parseInt(datatest[3]) > 1) {
                adminReport adminreport = new adminReport();

                int targetAge = Integer.parseInt((datatest[3]));

                if (targetAge >= 2) {
                    adminreport.setTotalQuantity(Integer.parseInt(datatest[2]));

                    adminReportYearlyStale.add(adminreport);
                }
            }
        }
        filesc.close();
    }

    public static void writeAdminReport() {

        FileWriter csvWriter;
        try {
            csvWriter = new FileWriter("admin-report.csv");
            BufferedWriter bw = new BufferedWriter(csvWriter);

            int sumTotalRaised = 0, sumTotalGlazed = 0, sumTotalSugarR = 0, sumTotalChocolateR = 0, sumTotalCake = 0,
                    sumTotalPlain = 0, sumTotalChocolateC = 0, sumTotalSugarC = 0, sumTotalFilled = 0, sumTotalLemon = 0,
                     sumTotalGrape = 0, sumTotalCustard = 0, sumTotalQuantityTotal = 0;

            float sumTotalPriceGlazed = 0, sumTotalPriceSugarR = 0, sumTotalPriceChocolateR = 0, sumTotalPricePlain = 0, sumTotalPriceChocolateC = 0, sumTotalPriceSugarC = 0, sumTotalPriceLemon = 0,
                    sumTotalPriceGrape = 0, sumTotalPriceCustard = 0, sumTotalPriceTotal = 0;

            String Header = "Type, total Raised, Glazed, Glazed price, SugarR, SugarR price, ChocolateR, ChocolateR price, total Cake, Plain, Plain price, ChocolateC, ChocolateC price, SugarC, SugarC price, total Filled, Lemon, Lemon price, Grape, Grape price, Custard, Custard price, Total Quantity, Total Price\n";

            bw.write(Header);
            bw.flush();

            // write the data rows
            for (adminReport adminreport : adminReportWeekly) {
                sumTotalRaised = sumTotalRaised + adminreport.getTotalRaised();
                sumTotalGlazed = sumTotalGlazed + adminreport.getGlazed();
                sumTotalSugarR = sumTotalSugarR + adminreport.getSugarR();
                sumTotalChocolateR = sumTotalChocolateR + adminreport.getChocolateR();
                sumTotalCake = sumTotalCake + adminreport.getTotalCake();
                sumTotalPlain = sumTotalPlain + adminreport.getPlain();
                sumTotalChocolateC = sumTotalChocolateC + adminreport.getChocolateC();
                sumTotalSugarC = sumTotalSugarC + adminreport.getSugarC();
                sumTotalFilled = sumTotalFilled + adminreport.getTotalFilled();
                sumTotalLemon = sumTotalLemon + adminreport.getLemon();
                sumTotalGrape = sumTotalGrape + adminreport.getGrape();
                sumTotalCustard = sumTotalCustard + adminreport.getCustard();
                sumTotalQuantityTotal = sumTotalQuantityTotal + adminreport.getTotalQuantity();

                sumTotalPriceGlazed = sumTotalPriceGlazed + adminreport.getPriceGlazed();
                sumTotalPriceSugarR = sumTotalPriceSugarR + adminreport.getPriceSugarR();
                sumTotalPriceChocolateR = sumTotalPriceChocolateR + adminreport.getPriceChocolateR();
                sumTotalPricePlain = sumTotalPricePlain + adminreport.getPricePlain();
                sumTotalPriceChocolateC = sumTotalChocolateC + adminreport.getPriceChocolateC();
                sumTotalPriceSugarC = sumTotalPriceSugarC + adminreport.getPriceSugarC();
                sumTotalPriceLemon = sumTotalPriceLemon + adminreport.getPriceLemon();
                sumTotalPriceGrape = sumTotalPriceGrape + adminreport.getPriceGrape();
                sumTotalPriceCustard = sumTotalPriceCustard + adminreport.getPriceCustard();
                sumTotalPriceTotal = sumTotalPriceTotal + adminreport.getTotalPrice();
            }

            bw.write("Weekly" + "," + sumTotalRaised + "," + sumTotalGlazed + "," + sumTotalPriceGlazed + "," + sumTotalSugarR + "," + sumTotalPriceSugarR + "," + sumTotalChocolateR + "," +
                    sumTotalPriceChocolateR + "," + sumTotalCake + "," + sumTotalPlain + "," + sumTotalPricePlain + "," + sumTotalChocolateC + "," + sumTotalPriceChocolateC + "," + sumTotalSugarC + "," +
                    sumTotalPriceSugarC + "," + sumTotalFilled + "," + sumTotalLemon + "," + sumTotalPriceLemon + "," + sumTotalGrape + "," + sumTotalPriceGrape + "," + sumTotalCustard + "," +
                    sumTotalPriceCustard + "," + sumTotalQuantityTotal + "," + sumTotalPriceTotal + "\n");

            bw.flush();
            bw.close();

            System.out.println("Writing to CSV successful");

        } catch (IOException e) {
            System.err.println("Error writing inventory to CSV file: " + e.getMessage());
        }

        try {
            csvWriter = new FileWriter("admin-report.csv", true);
            BufferedWriter bw = new BufferedWriter(csvWriter);

            int sumTotalRaised = 0, sumTotalGlazed = 0, sumTotalSugarR = 0, sumTotalChocolateR = 0, sumTotalCake = 0,
                    sumTotalPlain = 0, sumTotalChocolateC = 0, sumTotalSugarC = 0, sumTotalFilled = 0, sumTotalLemon = 0,
                    sumTotalGrape = 0, sumTotalCustard = 0, sumTotalQuantityTotal = 0;

            float sumTotalPriceGlazed = 0, sumTotalPriceSugarR = 0, sumTotalPriceChocolateR = 0, sumTotalPricePlain = 0, sumTotalPriceChocolateC = 0, sumTotalPriceSugarC = 0, sumTotalPriceLemon = 0,
                    sumTotalPriceGrape = 0, sumTotalPriceCustard = 0, sumTotalPriceTotal = 0;

            // write the data rows
            for (adminReport adminreport : adminReportMonthly) {
                sumTotalRaised = sumTotalRaised + adminreport.getTotalRaised();
                sumTotalGlazed = sumTotalGlazed + adminreport.getGlazed();
                sumTotalSugarR = sumTotalSugarR + adminreport.getSugarR();
                sumTotalChocolateR = sumTotalChocolateR + adminreport.getChocolateR();
                sumTotalCake = sumTotalCake + adminreport.getTotalCake();
                sumTotalPlain = sumTotalPlain + adminreport.getPlain();
                sumTotalChocolateC = sumTotalChocolateC + adminreport.getChocolateC();
                sumTotalSugarC = sumTotalSugarC + adminreport.getSugarC();
                sumTotalFilled = sumTotalFilled + adminreport.getTotalFilled();
                sumTotalLemon = sumTotalLemon + adminreport.getLemon();
                sumTotalGrape = sumTotalGrape + adminreport.getGrape();
                sumTotalCustard = sumTotalCustard + adminreport.getCustard();
                sumTotalQuantityTotal = sumTotalQuantityTotal + adminreport.getTotalQuantity();

                sumTotalPriceGlazed = sumTotalPriceGlazed + adminreport.getPriceGlazed();
                sumTotalPriceSugarR = sumTotalPriceSugarR + adminreport.getPriceSugarR();
                sumTotalPriceChocolateR = sumTotalPriceChocolateR + adminreport.getPriceChocolateR();
                sumTotalPricePlain = sumTotalPricePlain + adminreport.getPricePlain();
                sumTotalPriceChocolateC = sumTotalChocolateC + adminreport.getPriceChocolateC();
                sumTotalPriceSugarC = sumTotalPriceSugarC + adminreport.getPriceSugarC();
                sumTotalPriceLemon = sumTotalPriceLemon + adminreport.getPriceLemon();
                sumTotalPriceGrape = sumTotalPriceGrape + adminreport.getPriceGrape();
                sumTotalPriceCustard = sumTotalPriceCustard + adminreport.getPriceCustard();
                sumTotalPriceTotal = sumTotalPriceTotal + adminreport.getTotalPrice();
            }

            bw.write("Monthly" + "," + sumTotalRaised + "," + sumTotalGlazed + "," + sumTotalPriceGlazed + "," + sumTotalSugarR + "," + sumTotalPriceSugarR + "," + sumTotalChocolateR + "," +
                    sumTotalPriceChocolateR + "," + sumTotalCake + "," + sumTotalPlain + "," + sumTotalPricePlain + "," + sumTotalChocolateC + "," + sumTotalPriceChocolateC + "," + sumTotalSugarC + "," +
                    sumTotalPriceSugarC + "," + sumTotalFilled + "," + sumTotalLemon + "," + sumTotalPriceLemon + "," + sumTotalGrape + "," + sumTotalPriceGrape + "," + sumTotalCustard + "," +
                    sumTotalPriceCustard + "," + sumTotalQuantityTotal + "," + sumTotalPriceTotal + "\n");

            bw.flush();
            bw.close();

            System.out.println("Writing to CSV successful");

        } catch (IOException e) {
            System.err.println("Error writing inventory to CSV file: " + e.getMessage());
        }

        try {
            csvWriter = new FileWriter("admin-report.csv", true);
            BufferedWriter bw = new BufferedWriter(csvWriter);

            int sumTotalRaised = 0, sumTotalGlazed = 0, sumTotalSugarR = 0, sumTotalChocolateR = 0, sumTotalCake = 0,
                    sumTotalPlain = 0, sumTotalChocolateC = 0, sumTotalSugarC = 0, sumTotalFilled = 0, sumTotalLemon = 0,
                    sumTotalGrape = 0, sumTotalCustard = 0, sumTotalQuantityTotal = 0;

            float sumTotalPriceGlazed = 0, sumTotalPriceSugarR = 0, sumTotalPriceChocolateR = 0, sumTotalPricePlain = 0, sumTotalPriceChocolateC = 0, sumTotalPriceSugarC = 0, sumTotalPriceLemon = 0,
                    sumTotalPriceGrape = 0, sumTotalPriceCustard = 0, sumTotalPriceTotal = 0;

            // write the data rows
            for (adminReport adminreport : adminReportYearly) {
                sumTotalRaised = sumTotalRaised + adminreport.getTotalRaised();
                sumTotalGlazed = sumTotalGlazed + adminreport.getGlazed();
                sumTotalSugarR = sumTotalSugarR + adminreport.getSugarR();
                sumTotalChocolateR = sumTotalChocolateR + adminreport.getChocolateR();
                sumTotalCake = sumTotalCake + adminreport.getTotalCake();
                sumTotalPlain = sumTotalPlain + adminreport.getPlain();
                sumTotalChocolateC = sumTotalChocolateC + adminreport.getChocolateC();
                sumTotalSugarC = sumTotalSugarC + adminreport.getSugarC();
                sumTotalFilled = sumTotalFilled + adminreport.getTotalFilled();
                sumTotalLemon = sumTotalLemon + adminreport.getLemon();
                sumTotalGrape = sumTotalGrape + adminreport.getGrape();
                sumTotalCustard = sumTotalCustard + adminreport.getCustard();
                sumTotalQuantityTotal = sumTotalQuantityTotal + adminreport.getTotalQuantity();

                sumTotalPriceGlazed = sumTotalPriceGlazed + adminreport.getPriceGlazed();
                sumTotalPriceSugarR = sumTotalPriceSugarR + adminreport.getPriceSugarR();
                sumTotalPriceChocolateR = sumTotalPriceChocolateR + adminreport.getPriceChocolateR();
                sumTotalPricePlain = sumTotalPricePlain + adminreport.getPricePlain();
                sumTotalPriceChocolateC = sumTotalChocolateC + adminreport.getPriceChocolateC();
                sumTotalPriceSugarC = sumTotalPriceSugarC + adminreport.getPriceSugarC();
                sumTotalPriceLemon = sumTotalPriceLemon + adminreport.getPriceLemon();
                sumTotalPriceGrape = sumTotalPriceGrape + adminreport.getPriceGrape();
                sumTotalPriceCustard = sumTotalPriceCustard + adminreport.getPriceCustard();
                sumTotalPriceTotal = sumTotalPriceTotal + adminreport.getTotalPrice();
            }

            bw.write("Yearly" + "," + sumTotalRaised + "," + sumTotalGlazed + "," + sumTotalPriceGlazed + "," + sumTotalSugarR + "," + sumTotalPriceSugarR + "," + sumTotalChocolateR + "," +
                    sumTotalPriceChocolateR + "," + sumTotalCake + "," + sumTotalPlain + "," + sumTotalPricePlain + "," + sumTotalChocolateC + "," + sumTotalPriceChocolateC + "," + sumTotalSugarC + "," +
                    sumTotalPriceSugarC + "," + sumTotalFilled + "," + sumTotalLemon + "," + sumTotalPriceLemon + "," + sumTotalGrape + "," + sumTotalPriceGrape + "," + sumTotalCustard + "," +
                    sumTotalPriceCustard + "," + sumTotalQuantityTotal + "," + sumTotalPriceTotal + "\n");

            bw.flush();
            bw.close();

            System.out.println("Writing to CSV successful");

        } catch (IOException e) {
            System.err.println("Error writing inventory to CSV file: " + e.getMessage());
        }
    }

    public static void writeAdminReportStale() {

        FileWriter csvWriter;
        try {
            csvWriter = new FileWriter("admin-report-stale.csv");
            BufferedWriter bw = new BufferedWriter(csvWriter);

            int sumTotalQuantity = 0;

            String Header = "Num Thrown Out\n";

            bw.write(Header);
            bw.flush();

            // write the data rows
            for (adminReport adminreport : adminReportWeeklyStale) {
                sumTotalQuantity = sumTotalQuantity + adminreport.getTotalQuantity();
            }

            bw.write("Weekly" + "," + sumTotalQuantity + "\n");

            bw.flush();
            bw.close();

            System.out.println("Writing to CSV successful");

        } catch (IOException e) {
            System.err.println("Error writing inventory to CSV file: " + e.getMessage());
        }

        try {
            csvWriter = new FileWriter("admin-report-stale.csv", true);
            BufferedWriter bw = new BufferedWriter(csvWriter);

            int sumTotalQuantity = 0;

            // write the data rows
            for (adminReport adminreport : adminReportMonthlyStale) {
                sumTotalQuantity = sumTotalQuantity + adminreport.getTotalQuantity();
            }

            bw.write("Monthly" + "," + sumTotalQuantity + "\n");

            bw.flush();
            bw.close();

            System.out.println("Writing to CSV successful");

        } catch (IOException e) {
            System.err.println("Error writing inventory to CSV file: " + e.getMessage());
        }

        try {
            csvWriter = new FileWriter("admin-report-stale.csv", true);
            BufferedWriter bw = new BufferedWriter(csvWriter);

            int sumTotalQuantity = 0;

            // write the data rows
            for (adminReport adminreport : adminReportYearlyStale) {
                sumTotalQuantity = sumTotalQuantity + adminreport.getTotalQuantity();
            }

            bw.write("Yearly" + "," + sumTotalQuantity + "\n");

            bw.flush();
            bw.close();

            System.out.println("Writing to CSV successful");

        } catch (IOException e) {
            System.err.println("Error writing inventory to CSV file: " + e.getMessage());
        }
    }

    public static void printAdminReport(){
        for (adminReport adminreport : adminReportWeekly) {
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
