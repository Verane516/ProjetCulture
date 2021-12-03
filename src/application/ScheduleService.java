package application;

import domain.Event;
import domain.Slot;
import domain.Hall;
import domain.Schedule;

public class ScheduleService {
	
	// ajouter un événement au planning d'une salle pour le planning considéré
	public void addEvent(Slot slot, Event event, Hall hall, Schedule schedule){ 
		if (hall.getHoursList().contains(slot) == true) {
			// le créneau existe pour la salle et il est libre
			if (schedule.getTimetable().get(slot).equals(null) == true) {
				// le créneau est libre
				// vérifier que la date de l'event correspond à la date du slot
				if (event.checkDate(slot) == true) {
					schedule.getTimetable().put(slot, event);
					hall.getProgrammedEvent().add(event);
					hall.getHoursList().remove(slot);
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
	
	//déprogrammer un événement via son créneau + màj des listes HoursList et ProgrammedEvent
	public void deleteEvent(Slot slot, Event event, Hall hall, Schedule schedule){ 
		schedule.getTimetable().put(slot, null);
		hall.getProgrammedEvent().remove(event);
		hall.getHoursList().add(slot);
	}
	
	//afficher le planning d'une salle
	public void viewSchedule(Schedule schedule, Hall hall) {
		System.out.println (schedule.getTimetable());
	}
	
	
}
