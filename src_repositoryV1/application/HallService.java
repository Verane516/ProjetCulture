package application;

import domain.Hall;
import domain.HallRepository;
import domain.Schedule;

public class HallService {
	private HallRepository rep;
	
	public HallService(HallRepository rep) {
		this.rep = rep;
	}
	
	//ajouter un événement au planning d'une salle  (à modifier)
	public int newEvent() {
		Hall h = new Hall(capacity, schedule);
		rep.add(h);
		return h.getId();
	}
	
	
}
