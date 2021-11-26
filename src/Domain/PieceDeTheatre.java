package Domain;

public class PieceDeTheatre {
	private final int date; //intervalle de date : List ?
	private final String nom; //nom de la pièce
	private final int capacite; //capacité désirée
	
	public PieceDeTheatre(int _date, String _nom, int _capacite){
		this.date=_date;
		this.nom =_nom;
		this.capacite=_capacite;
	}
}
