package domain;

import java.util.Date;

public class TheatrePiece extends Event {
	
	private final Date START_DATE;
	private final Date END_DATE;
	private final String TITLE;
	
	// Les '_' avant les attributs c'est lorsqu'on a pas la possiblité d'utiliser la visibilité
	// En java on a juste besoin de spécifier private
	
	public TheatrePiece(int desiredCapacity,Date startDate, Date endDate, String title){
		super(desiredCapacity);
		this.START_DATE = startDate;
		this.END_DATE = endDate;
		this.TITLE = title;
	}
	
	public Date getStartDate() {
		return START_DATE;
	}

	public Date getEndDate() {
		return END_DATE;
	}

	public String getTitle() {
		return TITLE;
	}
}
