package application;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import domain.Concert;
import domain.Event;
import domain.Slot;
import domain.TheatrePiece;
import domain.Hall;

public class DataSetTest {
	
	public static void getInfo(Calendar calendar) {
		System.out.println("YEAR: " + calendar.get(Calendar.YEAR));
		System.out.println("MONTH: " + calendar.get(Calendar.MONTH));
		System.out.println("WEEK_OF_YEAR: " + calendar.get(Calendar.WEEK_OF_YEAR));
		System.out.println("WEEK_OF_MONTH: " + calendar.get(Calendar.WEEK_OF_MONTH));
		System.out.println("DATE: " + calendar.get(Calendar.DATE));
		System.out.println("DAY_OF_MONTH: " + calendar.get(Calendar.DAY_OF_MONTH));
		System.out.println("DAY_OF_YEAR: " + calendar.get(Calendar.DAY_OF_YEAR));
		System.out.println("DAY_OF_WEEK: " + calendar.get(Calendar.DAY_OF_WEEK));
		System.out.println("DAY_OF_WEEK_IN_MONTH: " + calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		System.out.println("AM_PM: " + calendar.get(Calendar.AM_PM));
		System.out.println("HOUR: " + calendar.get(Calendar.HOUR));
		System.out.println("HOUR_OF_DAY: " + calendar.get(Calendar.HOUR_OF_DAY));
		System.out.println("MINUTE: " + calendar.get(Calendar.MINUTE));
		System.out.println("SECOND: " + calendar.get(Calendar.SECOND));
		System.out.println("MILLISECOND: " + calendar.get(Calendar.MILLISECOND) + "\n");
	}

	public static void main(String[] args) {
		
		// notre jeu de donnée va porter sur le mois de janvier 2022
		
		final int YEAR = 2022;
		final int MONTH = 0; // janvier
		final int DAY_OF_MONTH = 1;
		
		final Calendar CALENDAR = new GregorianCalendar(YEAR, MONTH, DAY_OF_MONTH);
	    // calendar.setFirstDayOfWeek(Calendar.MONDAY); // par défaut
		
		// DataSetTest.getInfo(calendar);
		
		Calendar calendar2 = (GregorianCalendar)CALENDAR.clone();
		calendar2.add(Calendar.DATE, 1);
		
		
		// DataSetTest.getInfo(calendar);
		// DataSetTest.getInfo(calendar2);
		// on a bien fait une copie en profondeur
		
		List<Calendar> daysOfJanuary = new ArrayList<Calendar>();
		daysOfJanuary.add(CALENDAR);
		Calendar curCal;
		for (int i = 1; i <= 30 ; i++) {
			curCal = (GregorianCalendar)CALENDAR.clone();
			curCal.add(Calendar.DATE, i);
			daysOfJanuary.add(curCal);
		}
		
		// DataSetTest.getInfo(daysOfJanuary.get(30)); // 31-ième jour de janvier
		
		// Supposons :
		// - il y a un concert par jour
		// - chaque concert peut acceuillir 50 personnes, tous les 10 jours il y a un gros concert
		// - les concerts débutent à 18h
		
		final int DEFAULT_CAPACITY = 50;
		final int BIG_EVENT_FACTOR = 20;
		int DEFAULT_BEGIN_HOUR = 18;
		
		
		List<Event> concerts = new ArrayList<Event>();
		Calendar startDate;
		
		for (int i = 0; i <= 30 ; i++) {
			startDate = (GregorianCalendar)daysOfJanuary.get(i).clone();
			startDate.add(Calendar.HOUR, DEFAULT_BEGIN_HOUR);
			if (i%10 == 0) {
				concerts.add(new Concert(BIG_EVENT_FACTOR*DEFAULT_CAPACITY, startDate, "concert n" + i));
			}
			else {
				concerts.add(new Concert(DEFAULT_CAPACITY, startDate, "concert n" + i));
			}
		}
		
		List<Event> theaterPieces = new ArrayList<Event>();
		// semaine du 3 au 9 janvier
		Calendar beginDate1 = new GregorianCalendar(YEAR, MONTH, 3);
		Calendar endDate1 = new GregorianCalendar(YEAR, MONTH, 7);
		theaterPieces.add(new TheatrePiece(DEFAULT_CAPACITY, beginDate1, endDate1, "How to understand Java"));
		
		// semaine du 10 au 16 janvier
		Calendar beginDate2 = new GregorianCalendar(YEAR, MONTH, 11);
		Calendar endDate2 = new GregorianCalendar(YEAR, MONTH, 12);
		theaterPieces.add(new TheatrePiece(BIG_EVENT_FACTOR*DEFAULT_CAPACITY, beginDate2, endDate2, "Theater piece n2"));
		
		List<Event> events = new ArrayList<Event>();
		events.addAll(concerts);
		events.addAll(theaterPieces);
		
		// créneaux :
		
		final int BEGIN_HOUR_1 = 19;
		final int END_HOUR_1 = 21;
		final int DEFAULT_MINUTES = 0;
		
		List<Slot> slots1 = new ArrayList<Slot>();
		Calendar slotStart;
		Calendar slotEnd;
		
		for (int i = 1; i <= 31 ; i++) {
			slotStart = new GregorianCalendar(YEAR, MONTH, i, BEGIN_HOUR_1, DEFAULT_MINUTES);
			slotEnd = new GregorianCalendar(YEAR, MONTH, i, END_HOUR_1, DEFAULT_MINUTES);
			slots1.add(new Slot(slotStart, slotEnd));
		}
		
		final int BEGIN_HOUR_2 = 18;
		final int END_HOUR_2 = 22;
		
		List<Slot> slots2 = new ArrayList<Slot>();
		for (int i = 1; i <= 31 ; i++) {
			slotStart = new GregorianCalendar(YEAR, MONTH, i, BEGIN_HOUR_2, DEFAULT_MINUTES);
			slotEnd = new GregorianCalendar(YEAR, MONTH, i, END_HOUR_2, DEFAULT_MINUTES);
			slots2.add(new Slot(slotStart, slotEnd));
		}
		
		// On ne génére pas de créneaux le lundi
		List<Slot> slots3 = new ArrayList<Slot>();
		for (int i = 1; i <= 31 ; i++) {
			slotStart = new GregorianCalendar(YEAR, MONTH, i, BEGIN_HOUR_2, DEFAULT_MINUTES);
			if (slotStart.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
				slotEnd = new GregorianCalendar(YEAR, MONTH, i, END_HOUR_2, DEFAULT_MINUTES);
				slots3.add(new Slot(slotStart, slotEnd));
				// System.out.println("DATE: " + slotStart.get(Calendar.DATE));
			}
		}
		// System.out.println("Nombre de créneaux pour la liste de slot 3 : " + slots3.size());
		// on a bien 26 jours qui ne sont pas des lundis en janvier 2022
		
		// On ferme à END_HOUR_2 les samedis et à END_HOUR_1 le reste de la semaine
		List<Slot> slots4 = new ArrayList<Slot>();
		for (int i = 1; i <= 31 ; i++) {
			slotStart = new GregorianCalendar(YEAR, MONTH, i, BEGIN_HOUR_1, DEFAULT_MINUTES);
			if (slotStart.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
				slotEnd = new GregorianCalendar(YEAR, MONTH, i, END_HOUR_2, DEFAULT_MINUTES);
			}
			else {
				slotEnd = new GregorianCalendar(YEAR, MONTH, i, END_HOUR_1, DEFAULT_MINUTES);
			}
		slots4.add(new Slot(slotStart, slotEnd));
		}
		
		final int LOW_CAPACITY = 20; // capacité trop faible pour acceuillir les événements
		final int MEDIUM_CAPACITY = 100; // capacité suffisante pour les petits événements, mais pas pour les gros;
		final int BIG_CAPACITY = 1500; // capacité suffisante pour tous les événements;
		
		Set<Hall> halls = new HashSet<Hall>();
		
		Hall smallHall = new Hall(LOW_CAPACITY, slots1);
		halls.add(smallHall);
		
		Hall bigHall = new Hall(BIG_CAPACITY, slots2);
		halls.add(bigHall);
		
		Hall hallClosedOnMondays = new Hall(MEDIUM_CAPACITY, slots3);
		halls.add(hallClosedOnMondays);
		
		Hall hallWith2EndHours = new Hall(LOW_CAPACITY, slots4);
		halls.add(hallWith2EndHours);
		
	}

}
