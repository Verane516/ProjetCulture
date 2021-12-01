package domain;

import java.util.Calendar;

// value object
public class Slot {

	private final Calendar START_DATE;
	private final Calendar END_DATE;
	
	public Slot(Calendar sD, Calendar eD) {
		this.START_DATE = sD;
		this.END_DATE = eD;
		
	}

	public Calendar getSTART_DATE() {
		return START_DATE;
	}

	public Calendar getEND_DATE() {
		return END_DATE;
	}
	
}
