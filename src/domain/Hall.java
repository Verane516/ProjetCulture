package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.HashMap;

// Entity
public class Hall {
	private final UUID ID;
	private final int CAPACITY;
	
	private final List<Slot> hoursList; //liste des horaires, l'heure d'ouverture est incluse dans la liste des créneaux disponibles
	private List<Event> programmedEvents; //liste des événements programmés
	private Map<Slot,Event> timetable; // affectation des créneaux
	
	public Hall(int capacity, List<Slot> hoursList) {
		this.CAPACITY = capacity;
		this.hoursList = hoursList;
		this.ID = UUID.randomUUID();
		this.programmedEvents = new ArrayList<Event>();
		this.timetable = new HashMap<Slot, Event>();
	}
	
	public void updateTimetable() {
		// pour tous les évenements affectés à la salle
		// si un créneau convient pour l'événement, on associe le créneau à l'évenement
		// on peut affecter plusieurs créneaux à une pièce de théatre
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
	
	public List<Event> getProgrammedEvent(){
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
