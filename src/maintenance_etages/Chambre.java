package maintenance_etages;

public class Chambre {
	private int id;
	private TypeChambre typeChambre;
	private String libelle;
	private String etatChambre;
	private Boolean isOccuped;
	public enum ETAT_CHAMBRE {
		OCCUPE,
		LIBRE
	}
	public Chambre(int id, TypeChambre typeChambre, String libelle, String etatChambre, Boolean isOccuped) {
		super();
		this.id = id;
		this.typeChambre = typeChambre;
		this.libelle = libelle;
		this.etatChambre = etatChambre;
		this.isOccuped = isOccuped;
	}
	
	
}
