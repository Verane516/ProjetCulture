package infra;

import java.util.HashSet;
import java.util.Set;
import domain.Hall;

//structure du cours, à modifier
public class HallRepositoryInMemory {

	Set<Hall> memory;
	
	public HallRepositoryInMemory(){
    	memory=new HashSet<Hall>();
    }
	public void save(Hall h){
		memory.add(h);
	}
	public Hall findHallById(int hallId){
		for (Hall h:memory){
			if (h.getId() == hallId){
				return h;
			} 
		}
		return null;
	}
}
