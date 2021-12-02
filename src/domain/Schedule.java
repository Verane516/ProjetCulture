package domain;

import java.util.HashSet;

// Aggregate à priori
public class Schedule extends HashSet<Slot>{

	// generated automatically, just to suppress warnings
	private static final long serialVersionUID = -1741988041674567258L;
	// vérification qu'il n'y a pas de superposition de créneaux si on a le temps
}
