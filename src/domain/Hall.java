package domain;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;



// Aggregate car une salle est définie par sa programmation qui est ammenée à changer
public class Hall {
	private final int CAPACITY;
	private Map<Slot,Event> timetable; // planning
	// chaque salle peut ouvrir sur une seule horaire par jour
	// cette horaire peut varier lors des jours d'ouverture

	
	public Hall(int capacity, Schedule schedule) {
		this.CAPACITY = capacity;
		this.timetable = Hall.generateTimetable(schedule);
	}

	private static Map<Slot, Event> generateTimetable(Schedule schedule) {
		Map<Slot, Event> timetable = new HashMap<Slot, Event>();
	    Iterator<Slot> it = schedule.iterator();
	    Slot s;
	    while (it.hasNext()) {
	    	s = it.next();
	    	timetable.put(s, null);
	    }
		return timetable;
	}

	public int getCAPACITY() {
		return CAPACITY;
	}

	public Map<Slot, Event> getTimetable() {
		return timetable;
	}

	public void addEvent(Slot slot, Event event) { 
		if (timetable.containsKey(slot)) {
			// le créneau existe pour la salle
			if (timetable.get(slot).equals(null)) {
				// le créneau est libre
				if (true) {
				// vérifier que la date de l'event correspond à la date du slot
					event.checkDate(slot);
				timetable.put(slot, event);
				}
			}
		}
		// lever une exception à chaque cas
	}
	
	
	
}
