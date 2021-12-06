package domain;

import java.util.ArrayList;
import java.util.List;
/*
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
*/


// Entity
public class Hall {
	private final int CAPACITY;
	//private Map<Slot,Event> timetable; // planning de la salle
	
	
	private int id; //TODO; mettre un UUID (final)
	private int genId = 0;
	private List<Event> programmedEvent; //liste des événements programmés
	private List<Slot> hoursList; //liste des horaires, l'heure d'ouverture est incluse dans la liste des créneaux disponibles
	/*Map <Calendar,Hour> hoursListV2;
	Map <Calendar,Event> programmedEventV2;*/
	
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
		this.id = genId++;
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
	
	public int getId() {
		return id;
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
