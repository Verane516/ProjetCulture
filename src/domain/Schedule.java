package domain;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
	
	public Schedule() {
		this.timetable = new HashMap<Event, Hall>(); // TODO: remplir cette map avec la liste des évenements
		this.ID = UUID.randomUUID();
	}

	public UUID getID() {
		return ID;
	}
	
	public Hall getHall(Event event) {
		return timetable.get(event);
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
		}
		System.err.println("Pas de salle compatible");
		return null;
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
		Event e;
		for (Entry<Event, Hall> pair : timetable.entrySet()) {
		    if (pair.getValue().equals(h)) { // on teste si les deux objets sont identiques ici
		    	e = pair.getKey();
		    	if (e instanceof Concert) {
					if(((Concert)e).getDate().get(Calendar.WEEK_OF_YEAR) == numWeek) {
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
