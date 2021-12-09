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
	
	private Map<Event, Hall> assignments; // on affecte chaque évenement à une salle
	// TODO: dans chaque salle on affecte l'évenement à un créneau
	
	private Set<Hall> halls;
	
	public Schedule() {
		this.halls = new HashSet<Hall>();
		this.assignments = new HashMap<Event, Hall>();
		this.ID = UUID.randomUUID();
	}

	public UUID getID() {
		return ID;
	}
	
	public Hall getHall(Event event) {
		return assignments.get(event);
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
		assignments.put(event, null);
	}
	
	// on affecte les évenements aux salles puis,
	// pour toutes les salles, on met à jour leur emploi du temps
	public void updateTimetables() {
		Set<Event> events = assignments.keySet();
		Hall choosenHall;
		for (Event event : events) {
			choosenHall = chooseHall(event);
			assignments.put(event, choosenHall);
			// If the map previously contained a mapping for the key, 
			// the old value is replaced by the specified value.
		}
		for (Hall hall : halls) {
			hall.updateTimetable();
		}
	}
	
	public Hall chooseHall(Event event) {
		if (event instanceof Concert) {
			if (allHallsHaveConcertThisWeek((Concert) event)) {
				for (Hall h:halls) {
					if (event.getDesiredCapacity() >= h.getCAPACITY()) {
						List<Slot> slots = h.getHoursList();
						for (Slot s : slots) {
							if (((Concert) event).checkDate(s)) {
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
						if (((TheatrePiece) event).checkDate(s)) {
							return h;
						}
					}
				}
			}
		}
		System.err.println("Pas de salle compatible pour l'évenement : " + event);
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
		Hall hallOfEvent;
		for (Entry<Event, Hall> pair : assignments.entrySet()) {
			hallOfEvent = pair.getValue();
			if (hallOfEvent != null) {
			    if (hallOfEvent.equals(hall)) { // on teste si les deux objets sont identiques ici
			    	event = pair.getKey();
			    	if (event instanceof Concert) {
						if(((Concert)event).getDate().get(Calendar.WEEK_OF_YEAR) == numWeek) {
							return true;
						}
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
