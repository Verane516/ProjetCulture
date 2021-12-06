package domain;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
	// dans chaque salle on affecte l'évenement à un créneau
	
	private List<Hall> halls; // un élément par salle, problème : on peut en théorie affecter un event 2 fois
	
	public Hall getHall(Event event) {
		return timetable.get(event);
	}
	
	/*public Slot getSlot(Event event) {
		List<Slot> slots = this.getHall(event).getHoursList();
		
	}*/
	
	public Hall chooseHall(Event event) {
		for (int i=0; i <halls.size(); i++) {
			List<Slot> slots = h.getHoursList();
			for (Slot s : slots) {
				if (event instanceof Concert) {
					if(!checkWeekHasConcert(h, ((Concert)event))) { // si la salle n'a pas de concert cette semaine
						if (((Concert) event).checkDate(s)) {
							timetable.put(event, h);
							return h;
						}
					}
				}
				if (event instanceof TheatrePiece) {
					//Calendar dateProg = ((TheatrePiece) event).getStartDate();
					if (((TheatrePiece) event).checkDate(s)) {
						timetable.put(event, h);
						return h;
					}
				}
			}
			System.err.println("Pas de salle compatible");
			return null;
		}
		if (i == halls.size()) {
			
		}
	}
	
	
	
	public Hall chooseHall(Event event) {
		if (event instanceof Concert) {
			if (allHallsHaveConcert((Concert) event)) {
				for (Hall h:halls) {
					List<Slot> slots = h.getHoursList();
					for (Slot s : slots) {
						if (((Concert) event).checkDate(s)) {
							timetable.put(event, h);
							return h;
						}
					}
				}
			}else {
				for (Hall h:halls) {
					List<Slot> slots = h.getHoursList();
					for (Slot s : slots) {
						if (event instanceof Concert) {
							if(!checkWeekHasConcert(h, ((Concert)event))) { // si la salle n'a pas de concert cette semaine
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
				List<Slot> slots = h.getHoursList();
				for (Slot s : slots) {
					//Calendar dateProg = ((TheatrePiece) event).getStartDate();
					if (((TheatrePiece) event).checkDate(s)) {
						timetable.put(event, h);
						return h;
					}
				}
			}
			System.err.println("Pas de salle compatible");
			return null;
		}
	
	}
	
	public boolean allHallsHaveConcert(Concert concert) {
		for (Hall h:halls) {
			if(!checkWeekHasConcert(h, concert)) {
				return false;
			}
		}
		return true;
	}
	
	//avec vérification 1 concert par semaine
	public boolean checkWeekHasConcert(Hall h, Concert concert) {
		Calendar c = concert.getDate();
		int numWeek = c.get(Calendar.WEEK_OF_YEAR);		
		List<Event> events = (List<Event>) timetable.get(h);
		for (Event e:events) {
			if (e instanceof Concert) {
				if(((Concert)e).getDate().get(Calendar.WEEK_OF_YEAR) == numWeek) {
					return true;
				}
			}
		}
		return false;	
	}
	
	
	/*public Hall chooseHall(Event event) {
		for (Hall h: halls) {
			List<Slot> slots = h.getHoursList();
			for (Slot s : slots) {
				if (event instanceof Concert) {
					//Calendar dateProg = ((Concert) event).getDate();
					if (((Concert) event).checkDate(s)) {
						timetable.put(event, h);
						return h;
					}
				}
				if (event instanceof TheatrePiece) {
					//Calendar dateProg = ((TheatrePiece) event).getStartDate();
					if (((TheatrePiece) event).checkDate(s)) {
						timetable.put(event, h);
						return h;
					}
				}
			}
			System.err.println("Pas de salle compatible");
			return null;
		}
	}*/
	
	public Schedule() {
		this.timetable = new HashMap<Event, Hall>();
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
	
	public Map<Event, Hall> getTimetable() {
		return timetable;
	}
	
	// vérification qu'il n'y a pas de superposition de créneaux si on a le temps
}
