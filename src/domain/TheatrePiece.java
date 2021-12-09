package domain;

import java.util.Calendar;
import java.util.Objects;

public class TheatrePiece extends Event {

	private final String TITLE;
	private final Calendar START_DATE; // (AAAA,MM,JJ)
	private final Calendar END_DATE; // (AAAA,MM,JJ)
	
	
	public TheatrePiece(int desiredCapacity,Calendar startDate, Calendar endDate, String title){
		super(desiredCapacity);
		this.START_DATE = startDate;
		this.END_DATE = endDate;
		this.TITLE = title;
	}
	
	public Calendar getStartDate() {
		return START_DATE;
	}

	public Calendar getEndDate() {
		return END_DATE;
	}

	public String getTitle() {
		return TITLE;
	}

	// TODO: faire un schéma pour expliquer comment on gère les vérifications de date et le mettre dans le rapport !
	@Override
	public boolean checkDate(Slot slot) {
		long pieceStartInSec = (long) (START_DATE.getTimeInMillis() * 0.001);
		long pieceEndInSec = (long) (END_DATE.getTimeInMillis() * 0.001);
		long slotStartInSec =  (long) (slot.getSTART_DATE().getTimeInMillis() * 0.001);
		long slotEndInSec =  (long) (slot.getEND_DATE().getTimeInMillis() * 0.001);
		
		if ((slotStartInSec >= pieceStartInSec) &&(slotEndInSec <= pieceEndInSec)) {
			return true;
		}
		
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(END_DATE, START_DATE, TITLE);
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
		TheatrePiece other = (TheatrePiece) obj;
		return Objects.equals(END_DATE, other.END_DATE) && Objects.equals(START_DATE, other.START_DATE)
				&& Objects.equals(TITLE, other.TITLE) && Objects.equals(this.getDesiredCapacity(), other.getDesiredCapacity());
	}

	@Override
	public String toString() {
		return "TheatrePiece [TITLE=" + TITLE + /*", START_DATE=" + START_DATE + ", END_DATE=" + END_DATE +*/ "]";
	}
	
	
}
