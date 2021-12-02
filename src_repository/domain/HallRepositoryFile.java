package domain;

import java.io.File;

//structure du cours, à modifier
public class HallRepositoryFile {

	public Hall findHallById(int hallId){
	     File f = new File(hallId);
	     Hall h = new Hall(f.read() ...) ;
	     return h;
	} 
	public void save(Hall h){
	  File f = new File(h.getId());
	  f.write( h ...);
	}
	
}
