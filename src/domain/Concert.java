package domain;

import java.util.Calendar;

//ValueObject
public class Concert extends Event {
	// convention de codage : les attributs final sont en majuscules, espacées par un underscore
	private final Calendar DATE;
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

	@Override
	public boolean checkDate(Slot slot) {
		// TODO Auto-generated method stub
		return false;
	}
}
