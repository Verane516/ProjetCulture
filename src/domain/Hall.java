package domain;

import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

// Entity
public class Hall {
	private final UUID ID;
	private final int CAPACITY;
	
	private final List<Slot> hoursList; //liste des horaires, l'heure d'ouverture est incluse dans la liste des créneaux disponibles
	private Set<Event> programmedEvents; //ensemble des événements programmés
	private Map<Slot,Event> timetable; // affectation des créneaux
	
	public Hall(int capacity, List<Slot> hoursList) {
		this.CAPACITY = capacity;
		this.hoursList = hoursList;
		this.ID = UUID.randomUUID();
		this.programmedEvents = new HashSet<Event>();
		this.timetable = new HashMap<Slot, Event>();
	}
	
	// pour tous les évenements affectés à la salle
	// si un créneau convient pour l'événement, on associe le créneau à l'évenement
	// on peut affecter plusieurs créneaux à une pièce de théatre
	public void affectSlots() {
		boolean affected;
		for (Slot slot: hoursList) {
			affected = false;
			// on affecte en priorité les créneaux aux pièces de théatre
			for (Event event: programmedEvents) {
				if ((event instanceof TheatrePiece)) {
					if (((TheatrePiece) event).checkDate(slot)) {
						if (!affected) {
							affected = true;
							timetable.put(slot, event);
						}
						else {
							System.err.println("On a déjà affecté le créneau compatible avec l'évenement : " + event);
						}
					}
				}
			}
			for (Event event: programmedEvents) {
				if ((event instanceof Concert)) {
					if (((Concert) event).checkDate(slot)) {
						if (!affected) {
							affected = true;
							timetable.put(slot, event);
						}
						else {
							System.err.println("On a déjà affecté le créneau compatible avec l'évenement : " + event);
						}
					}
				}
			}
			
		}
	}
	
	public void addEvents(Set<Event> events){
		programmedEvents.addAll(events);
	}
	
	public void addEvent(Event event){
		programmedEvents.add(event);
	}
	
	public Map<Slot,Event> getTimetable() {
		return timetable;
	}
	

	public int getCAPACITY() {
		return CAPACITY;
	}
	
	public UUID getID() {
		return ID;
	}
	
	public Set<Event> getProgrammedEvent(){
		return programmedEvents;
	}

	public List<Slot> getHoursList(){
		return hoursList;
	}


	@Override
	public int hashCode() {
		return Objects.hash(ID);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hall other = (Hall) obj;
		return Objects.equals(ID, other.ID);
	}
	
	
	
}
