package domain;

import java.util.Calendar;
import java.util.Objects;

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
	
	
	
}
