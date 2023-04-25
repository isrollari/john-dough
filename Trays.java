package johnDough;
import java.util.*;
import java.io.*;
import java.time.*;

public class Trays {
	ArrayList<Tray> currentTrays = new ArrayList<Tray>();
	
	public Trays(File f) throws FileNotFoundException {
		Scanner filesc = new Scanner(f);
		String mType, sType, tmp;
		int ID, curDonuts, daysOld;
		
		filesc.useDelimiter(",");
		filesc.nextLine();
		mType = filesc.next();
		
		while (filesc.hasNext()) {
			sType = filesc.next();
			
			curDonuts = Integer.parseInt(filesc.next());
			daysOld = Integer.parseInt(filesc.next());
			
			tmp = filesc.next();
			String l = tmp.split("\n")[0];
			l = l.replace("\r","");
			ID = Integer.parseInt(l);
			
			if (filesc.hasNext()) {
				mType = tmp.split("\n")[1];
			}
				
			currentTrays.add(new Tray(mType, sType, ID, LocalTime.now(), daysOld, curDonuts));
		}
		
		filesc.close();
	}
	
	public void addTray(String mType, String sType, int ID) {
		currentTrays.add(new Tray(mType, sType, ID));
	}
	
	public void removeDonuts(String mType, String sType, int num) {
		int remaining = num;
		int i = 0;
		
		while (remaining > 0 && i < currentTrays.size()) {
			if (!currentTrays.get(i).isOld && currentTrays.get(i).mainType.equals(mType) && currentTrays.get(i).subType.equals(sType))
				remaining = currentTrays.get(i).removeDonuts(remaining);
		}
	}
	
	public void saveInventory(File f) throws IOException {
		FileWriter writer = new FileWriter(f);
		
		for (int i = 0; i < currentTrays.size(); i++) {
			if (currentTrays.get(i).numAvailable == 0)
				continue;
			else if (currentTrays.get(i).daysold == 1) {
				currentTrays.get(i).updateDaysOld();
				
				System.out.println("Donut tray with ID "+currentTrays.get(i).trayID+" is expired; throw out.");
			} else {
				currentTrays.get(i).updateDaysOld();
				
				writer.write(currentTrays.get(i).mainType+" "+currentTrays.get(i).subType+","+currentTrays.get(i).numAvailable+","+currentTrays.get(i).daysold+"\n");
			}
		}
		
		writer.close();
	}
	
	public void saveTrays() throws IOException {
		FileWriter writer = new FileWriter("doughnut-inventory.csv");
		writer.flush();
		
		writer.write("Doughnut Type,Doughnut Subtype,Quantity,Days Old,Tray ID\n");
		
		for (int i = 0; i < currentTrays.size(); i++) {
			if (currentTrays.get(i).numAvailable == 0)
				continue;
			else if (currentTrays.get(i).daysold == 1) {
				System.out.println("Donut tray with ID "+currentTrays.get(i).trayID+" is expired; throw out.");
			} else {
				currentTrays.get(i).updateDaysOld();
				
				writer.write(currentTrays.get(i).mainType+" "+currentTrays.get(i).subType+","+currentTrays.get(i).numAvailable+","+currentTrays.get(i).daysold+","+currentTrays.get(i).trayID+"\n");
			}
		}
		
		writer.close();
	}
}
