package Domain;

import java.util.List;

//ValueObject
public class Salle {
	private final int capacite; //capacité de la salle
	private final List<Horaire> horaireSalle; //créer une classe horaire
	private final int ouverture; //int ou date ou List ? (List car plusieurs dates d'ouverture sur la semaine ou le mois)
	private final List<Evenement> programme; //programme de la salle
	
}
