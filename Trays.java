package johnDough;
import java.util.*;
import java.io.*;
import java.time.*;

public class Trays {
	ArrayList<Tray> currentTrays = new ArrayList<Tray>();
	
	public Trays(File f) throws FileNotFoundException {
		Scanner filesc = new Scanner(f);
		String mType, sType, tmpType, tmp;
		int ID, curDonuts, daysOld;
		
		filesc.useDelimiter(",");
		filesc.nextLine();
		tmpType = filesc.next();
		
		while (filesc.hasNext()) {
			mType = tmpType.split("\\s")[1];
			sType = tmpType.split("\\s")[0];
			
			curDonuts = Integer.parseInt(filesc.next());
			daysOld = Integer.parseInt(filesc.next());
			
			tmp = filesc.next();
			ID = Integer.parseInt(tmp.split("\n")[0]);
			
			if (filesc.hasNext()) {
				tmpType = tmp.split("\n")[1];
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
		
		for (int i = 0; i < currentTrays.size(); i++) {
			if (currentTrays.get(i).numAvailable == 0)
				continue;
			else if (currentTrays.get(i).daysold == 1) {
				System.out.println("Donut tray with ID "+currentTrays.get(i).trayID+" is expired; throw out.");
			} else {
				currentTrays.get(i).updateDaysOld();
				
				writer.write(currentTrays.get(i).mainType+" "+currentTrays.get(i).subType+","+currentTrays.get(i).trayID+","+currentTrays.get(i).numAvailable+","+currentTrays.get(i).daysold+","+currentTrays.get(i).baketime+"\n");
			}
		}
		
		writer.close();
	}
}
