package domain;

import java.util.Calendar;

public class TheatrePiece extends Event {

	private final String TITLE;
	private final Calendar START_DATE;
	private final Calendar END_DATE;
	
	// Les '_' avant les attributs c'est lorsqu'on a pas la possiblité d'utiliser la visibilité
	// En java on a juste besoin de spécifier private
	
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

	@Override
	public boolean checkDate(Slot slot) {
		return false;
	}
}
