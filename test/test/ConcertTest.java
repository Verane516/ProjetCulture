package test;

import java.util.Calendar;
import domain.Concert;


public class ConcertTest {
	
	public static void main(String[] args) {
		
		int desiredCapacity = 10;
		Calendar today = Calendar.getInstance();
		String name = "toto's concert";
		Concert concert = new Concert(desiredCapacity, today, name);
		
		System.out.println(Calendar.MONTH); // le numéro du champ mois de la classe Calendar
		System.out.println(concert.getDate().MONTH); // ne s'utilise pas comme ça
		System.out.println(concert.getDate().get(Calendar.MONTH)); // on a bien décembre (11)
	}
	
}
