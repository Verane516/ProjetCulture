package domain;
/*
import java.util.List;
import java.util.ArrayList;
*/
import java.util.HashMap;
import java.util.Map;

import java.util.Date;

// Entity car une salle est définie par sa programmation qui est ammenée à changer
public class Hall {
	// conseil : quand une info peut être obtenue en lisant le code il n'y a pas besoin de commentaire
	private final int CAPACITY;
	private final Map<Date,Schedule> TIMETABLE; // créneaux admissibles
	// chaque salle peut ouvrir sur une seule horaire par jour
	// cette horaire peut varier lors des jours d'ouverture
	private Map<Date,Event> programmedEvents; // créneaux alloués
	
	/*
	private final List<Schedule> horaireSalle; //créer une classe horaire
	private final int ouverture; //int ou date ou List ? (List car plusieurs dates d'ouverture sur la semaine ou le mois)
	private final List<Event> programme; //programme de la salle
	*/
	
	public Hall(int capacity, Map<Date,Schedule> timetable) {
		this.CAPACITY = capacity;
		this.TIMETABLE = timetable;
		this.programmedEvents = new HashMap<Date,Event>();
		/*
		this.horaireSalle = new ArrayList<Schedule>();
		this.programme = new ArrayList<Event>();
		*/
	}

	public int getCAPACITY() {
		return CAPACITY;
	}

	public Map<Date, Schedule> getTimetable() {
		return TIMETABLE;
	}

	public void addEvent(Date date, Event event) { 
		if (TIMETABLE.containsKey(date)) {
			programmedEvents.put(date, event);
			// l'évenement serait alors implicitement programmé à l'horaire TIMETABLE.get(date)
		}
	}
	
	
	
}
