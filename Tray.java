package johnDough;
import java.time.*;

public class Tray {
	LocalTime baketime;
	int daysold;
	String mainType;
	String subType;
	int trayID;
	int numAvailable;

	public Tray(String mType, String sType, int ID) {
		baketime = LocalTime.now();
		daysold = 0;
		mainType = mType;
		subType = sType;
		trayID = ID;
		numAvailable = 200;
	}
	
	public Tray(String mType, String sType, int ID, LocalTime bTime, int dOld, int curDonuts) {
		baketime = bTime;
		daysold = dOld;
		mainType = mType;
		subType = sType;
		trayID = ID;
		numAvailable = curDonuts;
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
