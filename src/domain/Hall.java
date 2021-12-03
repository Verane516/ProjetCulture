package domain;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// Entity
public class Hall {
	private final int CAPACITY;
	private Map<Slot,Event> timetable; // planning de la salle
	// chaque salle peut ouvrir sur une seule horaire par jour
	// cette horaire peut varier lors des jours d'ouverture
	private int id; //TODO; mettre un UUID (final)
	private int genId = 0;
	
	public Hall(int capacity, Schedule schedule) {
		this.CAPACITY = capacity;
		this.timetable = Hall.generateTimetable(schedule);
		this.id = genId++;
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
	
	public int getId() {
		return id;
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
