package domain;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/*
- Les attributs/propriétés n’ont pas de setter.
- Les Entity qui appartiennent à l’Agregate sont créées par lui, il fournit l’identifiant.
- Des traitements métiers publiques qui gèrent l’ ́etat de l’Agregate.
- Ne pas oublier de structurer l’Agregate grâce aux Value Objects pour diminuer la taille de l’Agregate.
*/

// Aggregate
public class Schedule{
	
	private final UUID ID;
	private Map<Slot,Event> timetable;
	
	public Schedule(Hall hall) {
		this.timetable = Schedule.generateTimetable(hall.getHoursList());
		this.ID = UUID.randomUUID();
	}

	public UUID getID() {
		return ID;
	}
	
	public boolean checkCapacity(Event event, Hall hall) {
		return event.getDesiredCapacity() >= hall.getCAPACITY();
	}

	
	private static Map<Slot, Event> generateTimetable(List<Slot> hoursList) {
		Map<Slot, Event> timetable = new HashMap<Slot, Event>();
	    Iterator<Slot> it = hoursList.iterator();
	    Slot s;
	    while (it.hasNext()) {
	    	s = it.next();
	    	timetable.put(s, null);
	    }
		return timetable;
	}
	
	public Map<Slot,Event> getTimetable() {
		return timetable;
	}
	
	// vérification qu'il n'y a pas de superposition de créneaux si on a le temps
}
