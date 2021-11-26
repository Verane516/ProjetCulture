package domain;

//ValueObject
public class Concert {
	private final int date; //date du concert
	private final String nom; //nom du groupe/artiste
	private final int capacite; //capacite désirée
	
	public Concert(int _date, String _nom, int _capacite){
		this.date=_date;
		this.nom =_nom;
		this.capacite=_capacite;
	}
}
