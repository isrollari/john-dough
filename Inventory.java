package johnDough;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {
    private String type;
    private String subType;
    private String quantity;
    private String daysOld;
    public static ArrayList<Inventory> InventoryData = new ArrayList<>();
    public Inventory(){
        String datatest[] = {};

        try {
            File myObj = new File("doughnut-inventory.xlsx");
            Scanner myScanner = new Scanner(myObj);
            while(myScanner.hasNextLine()){
                String data = myScanner.nextLine();
                datatest = data.split(",");
                Inventory inventory = new Inventory();
                inventory.setType(datatest[0]);
                inventory.setSubType(datatest[1]);
                inventory.setQuantity(datatest[2]);
                inventory.setDaysOld(datatest[3]);
                InventoryData.add(inventory);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error has occured, the file was not found");
            e.printStackTrace();
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getDaysOld() {
        return daysOld;
    }

    public void setDaysOld(String daysOld) {
        this.daysOld = daysOld;
    }
}
