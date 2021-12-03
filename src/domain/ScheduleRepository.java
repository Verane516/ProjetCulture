package domain;

import java.util.UUID;

public interface ScheduleRepository {
		
	public Schedule load(UUID id);
	// lire les données sauvegardées
	
	
	public void save(Schedule schedule);	
	// sauvegarder les données
	
}
