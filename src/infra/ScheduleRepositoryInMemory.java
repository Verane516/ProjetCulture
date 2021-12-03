package infra;

import java.util.HashMap;
import java.util.Map;

import domain.Schedule;
import domain.ScheduleRepository;
import java.util.UUID;

public class ScheduleRepositoryInMemory implements ScheduleRepository{

	Map<UUID, Schedule> repoInMemory;
	
	public ScheduleRepositoryInMemory(){
    	this.repoInMemory = new HashMap<UUID, Schedule>();
    }
	
	public Schedule load(UUID id) {
		if (repoInMemory.containsKey(id)) {
			return repoInMemory.get(id);
		}
		else {
			return null;
		}
	}

	public void save(Schedule schedule) {
		repoInMemory.put(schedule.getID(), schedule);
	}
	
	
}
