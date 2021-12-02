package domain;

import java.util.Map;

// structure du cours, à modifier
public class HallRepository {
		
	public Hall findHallById(int hallId) {
		//lire les données sauvegardées
		data = File.read();
		
		//reconstruire l'agregate
		Hall h = new Hall(data.id);
		
		//restaurer l'état
		h.moves = data;
		
		return h;
	}
	
	
	public void save (Hall h) {
		data.id = h.getId();
		
		//sauver sur un support
		file.write(data);
	}
	
public void update (Hall h) {
		
	}
}
