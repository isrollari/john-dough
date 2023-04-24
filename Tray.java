package johnDough;
import java.time.*;

public class Tray {
	LocalTime baketime;
	int daysold;
	String mainType;
	String subType;
	int trayID;
	int numAvailable;
	boolean isOld;

	public Tray(String mType, String sType, int ID) {
		baketime = LocalTime.now();
		daysold = 0;
		mainType = mType;
		subType = sType;
		trayID = ID;
		numAvailable = 20;
		isOld = false;
	}
	
	public Tray(String mType, String sType, int ID, LocalTime bTime, int dOld, int curDonuts) {
		baketime = bTime;
		daysold = dOld;
		mainType = mType;
		subType = sType;
		trayID = ID;
		numAvailable = curDonuts;
		
		if (dOld > 1)
			isOld = true;
		else
			isOld = false;
	}
	
	public int removeDonuts(int num) {
		if (num > numAvailable) {
			numAvailable = 0;
			return num - numAvailable;
		} else {
			numAvailable -= num;
			return 0;
		}
	}
	
	public void updateDaysOld() {
		daysold++;
	}
}
