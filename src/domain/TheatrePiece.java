package domain;

import java.util.Calendar;
import java.util.Objects;

public class TheatrePiece extends Event {

	private final String TITLE;
	private final Calendar START_DATE; // (AAAA,MM,JJ)
	private final Calendar END_DATE; // (AAAA,MM,JJ)
	
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

	// TODO: faire un schéma pour expliquer comment on gère les vérifications de date et le mettre dans le rapport !
	// TODO: Idée : on gère les date avec des timestamp (secondes écoulées depuis une certaine date) pour pas se prendre la tête
	@Override
	public boolean checkDate(Slot slot) {
		// Si l'année de la date de début de la pièce est égale à l'année de la date de début du créneau
		// ou que l'année de la date de fin de la pièce est égale à l'année de la date de fin du créneau (?)
		if ((START_DATE.get(Calendar.YEAR) == slot.getSTART_DATE().get(Calendar.YEAR)) || (END_DATE.get(Calendar.YEAR) == slot.getEND_DATE().get(Calendar.YEAR))) {
			// Si le mois de la date de début du créneau est supérieure ou égale au mois de la date de début de la pièce
			// et que le mois de la date de fin du créneau est inférieur ou égal au mois de la date de fin de la pièce
			// TODO: ça me semble faux : à vérifier
			if ((slot.getSTART_DATE().get(Calendar.MONTH) >= START_DATE.get(Calendar.MONTH)) && (slot.getEND_DATE().get(Calendar.MONTH) <= END_DATE.get(Calendar.MONTH))) {
				// si le jour de la date de début du créneau est supérieur ou égal au jour de la date de début de la pièce
				// et que le jour de la date de fin du créneau est inférieur ou égale au jour de la date de fin de la la pièce
				// TODO: je pense que tu as inversé les inégalités
				if ((slot.getSTART_DATE().get(Calendar.DAY_OF_MONTH) >= START_DATE.get(Calendar.DAY_OF_MONTH)) && (slot.getEND_DATE().get(Calendar.DAY_OF_MONTH) <= END_DATE.get(Calendar.DAY_OF_MONTH))) {
					return true;
				}
			}
			
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
				&& Objects.equals(TITLE, other.TITLE);
	}
	
	
}
