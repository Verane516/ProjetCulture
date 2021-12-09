package test;

import domain.Schedule;
import domain.ScheduleRepository;
import infra.ScheduleRepositoryInMemory;
import java.util.UUID;


public class ScheduleRepositoryInMemoryTest {
	
	public static void main(String[] args) {
		
		ScheduleRepository repoInMemory = new ScheduleRepositoryInMemory();
		Schedule schedule1 = new Schedule();
		UUID schedule1ID = schedule1.getID();
		
		repoInMemory.save(schedule1);
		
		Schedule schedule2 = repoInMemory.load(schedule1ID);
		
		System.out.println(schedule1.equals(schedule2)); 
		// equals vérifie qu'on a le même objet
		
	}
	
}
