package domain;

import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

/*
- Les attributs/propriétés n’ont pas de setter.
- Les Entity qui appartiennent à l’Agregate sont créées par lui, il fournit l’identifiant.
- Des traitements métiers publiques qui gèrent l’ ́etat de l’Agregate.
- Ne pas oublier de structurer l’Agregate grâce aux Value Objects pour diminuer la taille de l’Agregate.
*/

// Aggregate
public class Schedule {
	
	private final UUID ID;
	
	private Map<Event, Hall> timetable; // on affecte chaque évenement à une salle
	// TODO: dans chaque salle on affecte l'évenement à un créneau
	
	private Set<Hall> halls;
	
	public Schedule() {
		this.halls = new HashSet<Hall>();
		this.timetable = new HashMap<Event, Hall>();
		this.ID = UUID.randomUUID();
	}

	public UUID getID() {
		return ID;
	}
	
	public Hall getHall(Event event) {
		return timetable.get(event);
	}
	
	public void addHalls(Set<Hall> halls) {
		this.halls.addAll(halls);
	}
	
	public void addHall(Hall hall) {
		this.halls.add(hall);
	}
	
	public void addEvents(List<Event> events) {
		for(Event event : events) {
			this.addEvent(event);
		}
	}
	
	public void addEvent(Event event) {
		timetable.put(event, null);
	}
	
	public Hall chooseHall(Event event) {
		if (event instanceof Concert) {
			if (allHallsHaveConcertThisWeek((Concert) event)) {
				for (Hall h:halls) {
					if (event.getDesiredCapacity() >= h.getCAPACITY()) {
						List<Slot> slots = h.getHoursList();
						for (Slot s : slots) {
							if (((Concert) event).checkDate(s)) {
								timetable.put(event, h);
								// If the map previously contained a mapping for the key, 
								// the old value is replaced by the specified value.
								return h;
							}
						}
					}
				}
			}else {
				for (Hall h:halls) {
					if (event.getDesiredCapacity() >= h.getCAPACITY()) {
						if(!checkWeekHasConcert(h, ((Concert)event))) { // si la salle n'a pas de concert cette semaine
							List<Slot> slots = h.getHoursList();
							for (Slot s : slots) {
									if (((Concert) event).checkDate(s)) {
										timetable.put(event, h);
										return h;
									}
							}
						}
					}
				}
			}
		}

		if (event instanceof TheatrePiece) {
			for (Hall h:halls) {
				if (event.getDesiredCapacity() >= h.getCAPACITY()) {
					List<Slot> slots = h.getHoursList();
					for (Slot s : slots) {
						//Calendar dateProg = ((TheatrePiece) event).getStartDate();
						if (((TheatrePiece) event).checkDate(s)) {
							timetable.put(event, h);
							return h;
						}
					}
				}
			}
		}
		System.err.println("Pas de salle compatible");
		return null;
	}
	
	public boolean allHallsHaveConcertThisWeek(Concert concert) {
		for (Hall h:halls) {
			if(!checkWeekHasConcert(h, concert)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean checkWeekHasConcert(Hall hall, Concert concert) {
		Calendar cal = concert.getDate();
		int numWeek = cal.get(Calendar.WEEK_OF_YEAR);
		Event event;
		for (Entry<Event, Hall> pair : timetable.entrySet()) {
		    if (pair.getValue().equals(hall)) { // on teste si les deux objets sont identiques ici
		    	event = pair.getKey();
		    	if (event instanceof Concert) {
					if(((Concert)event).getDate().get(Calendar.WEEK_OF_YEAR) == numWeek) {
						return true;
					}
				}
		    }
		}
		return false;	
	}
	
	public boolean checkCapacity(Event event, Hall hall) {
		return event.getDesiredCapacity() >= hall.getCAPACITY();
	}
}
