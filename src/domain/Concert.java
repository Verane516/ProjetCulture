package domain;

import java.util.Date;

//ValueObject
public class Concert extends Event {
	// convention de codage : les attributs final sont en majuscules, espacées par un underscore
	private final Date DATE;
	private final String NAME; //nom du groupe/artiste
	
	public Concert(int desiredCapacity, Date date, String name){
		super(desiredCapacity);
		this.DATE = date;
		this.NAME = name;
	}
	
	public Date getDate() {
		return this.DATE;
	}
	
	public String getName() {
		return this.NAME;
	}
}
