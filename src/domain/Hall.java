package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

// Entity
public class Hall {
	private final int CAPACITY;
	//private Map<Slot,Event> timetable; // planning de la salle
	
	
	private final UUID ID;
	private List<Event> programmedEvent; //liste des événements programmés
	private List<Slot> hoursList; //liste des horaires, l'heure d'ouverture est incluse dans la liste des créneaux disponibles
	
	/*public Hall(int capacity, Schedule schedule) {
		this.CAPACITY = capacity;
		this.timetable = Hall.generateTimetable(schedule);
		this.id = genId++;
	}
	*/
	
	
	public Hall(int capacity, List<Slot> hoursList) {
		this.CAPACITY = capacity;
		this.programmedEvent = new ArrayList<Event>();
		this.hoursList = hoursList;
		this.ID = UUID.randomUUID();
	}
	

	/*private static Map<Slot, Event> generateTimetable(List<Slot> hoursList) {
		Map<Slot, Event> timetable = new HashMap<Slot, Event>();
	    Iterator<Slot> it = hoursList.iterator();
	    Slot s;
	    while (it.hasNext()) {
	    	s = it.next();
	    	timetable.put(s, null);
	    }
		return timetable;
	}*/
	

	public int getCAPACITY() {
		return CAPACITY;
	}
	
	public UUID getID() {
		return ID;
	}

	/*public Map<Slot,Event> getTimetable() {
		return timetable;
	}*/
	
	
	
	public List<Event> getProgrammedEvent(){
		return programmedEvent;
	}

	public List<Slot> getHoursList(){
		return hoursList;
	}
	
}
