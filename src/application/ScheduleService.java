package application;

import domain.Event;
import domain.Slot;
import domain.Hall;
//import domain.Schedule;

public class ScheduleService {
	
	// ajouter un événement au planning d'une salle pour le planning considéré
	public void addEvent(Slot slot, Event event, Hall hall) { 
		
		if (hall.getTimetable().containsKey(slot) == true) {
			// le créneau existe pour la salle
			if (hall.getTimetable().get(slot).equals(null) == true) {
				// le créneau est libre
				// vérifier que la date de l'event correspond à la date du slot
				if (event.checkDate(slot) == true) {
					hall.getTimetable().put(slot, event);
				}else {
					System.out.println("La date de l'événement ne correspond pas au créneau sélectionné.");
				}
					
			}else {
				System.out.println("Le créneau sélectionné n'est pas libre.");
			}
		
		}else {
			System.out.println("Le créneau sélectionné n'existe pas.");
		}
	}
}
