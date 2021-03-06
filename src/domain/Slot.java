package domain;

import java.util.Calendar;
import java.util.Objects;

import application.CalendarPrint;

// value object
public class Slot {

	private final Calendar START_DATE; // date et heure
	private final Calendar END_DATE; // date et heure
	
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

	@Override
	public int hashCode() {
		return Objects.hash(END_DATE, START_DATE);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Slot other = (Slot) obj;
		return Objects.equals(END_DATE, other.END_DATE) && Objects.equals(START_DATE, other.START_DATE);
	}

	@Override
	public String toString() {
		return "Slot [START_DATE=" + CalendarPrint.getShortDescription(START_DATE) + ", END_DATE=" + CalendarPrint.getShortDescription(END_DATE) + "]";
	}
	
	
	
}
