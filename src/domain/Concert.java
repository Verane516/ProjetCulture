package domain;

import java.util.Calendar;

//ValueObject
public class Concert extends Event {
	// convention de codage : les attributs final sont en majuscules, espacées par un underscore
	private final Calendar DATE; // (AAAA,MM,JJ)
	private final String NAME; //nom du groupe/artiste
	
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
		if (DATE.YEAR == slot.getSTART_DATE().YEAR) {
			if (DATE.MONTH == slot.getSTART_DATE().MONTH) {
				if (DATE.DAY_OF_MONTH == slot.getSTART_DATE().DAY_OF_MONTH) {
					return true;
				}
			}
			
		}
		
		return false;
	}
	
	// redéfinir equals et hashCode pour avoir une égalité de valeurs
	
}
