package domain;

import java.util.Calendar;
import java.util.Objects;

public class Concert extends Event {
	private final Calendar DATE; // (AAAA,MM,JJ)
	private final String NAME;
	
	public Concert(int desiredCapacity, Calendar date, String name){
		super(desiredCapacity);
		this.DATE = date;
		this.NAME = name;
	}
	
	public Calendar getDate() {
		return this.DATE;
	}
	
	public String getName() {
		return this.NAME;
	}

	// la classe ConcertTest explique comment on récupère les champs du Calendar
	@Override
	public boolean checkDate(Slot slot) {
		if (this.DATE.get(Calendar.YEAR) == slot.getSTART_DATE().get(Calendar.YEAR)) {
			if (this.DATE.get(Calendar.MONTH) == slot.getSTART_DATE().get(Calendar.MONTH)) {
				if (this.DATE.get(Calendar.DAY_OF_MONTH) == slot.getSTART_DATE().get(Calendar.DAY_OF_MONTH)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(DATE, NAME);
	}

	// on veut une égalité de valeurs
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Concert other = (Concert) obj;
		return Objects.equals(DATE, other.DATE) && Objects.equals(NAME, other.NAME);
	}
	
}
