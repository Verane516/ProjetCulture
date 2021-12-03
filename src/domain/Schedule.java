package domain;

import java.util.HashSet;
import java.util.UUID;

/*
- Les attributs/propriétés n’ont pas de setter.
- Les Entity qui appartiennent à l’Agregate sont créées par lui, il fournit l’identifiant.
- Des traitements métiers publiques qui gèrent l’ ́etat de l’Agregate.
- Ne pas oublier de structurer l’Agregate grâce aux Value Objects pour diminuer la taille de l’Agregate.
*/

// Aggregate à priori
public class Schedule extends HashSet<Slot>{
	
	private final UUID ID;

	// generated automatically, just to suppress warnings
	private static final long serialVersionUID = -1741988041674567258L;
	
	public Schedule() {
		this.ID = UUID.randomUUID();
	}

	public UUID getID() {
		return ID;
	}
	
	
	
	// vérification qu'il n'y a pas de superposition de créneaux si on a le temps
}
