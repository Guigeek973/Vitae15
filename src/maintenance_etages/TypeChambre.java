package maintenance_etages;

public class TypeChambre {
	private int id;
	private String libelle;
	private float prix;
	private double taxes; /// changer dans MCD ==> TYPE DOUBLE
	private int places;
	
	public enum TAXES {
		LOW(5.5),
		INTERMEDIATE(7),
		MEDIUM(10),
		HIGH(20);
		
		private double taxe;
		
		TAXES(double tax) {
			this.taxe = tax;
		}
		public double getTaxe() {
			return this.taxe;
		}
	}

	public TypeChambre(String libelle, float prix, TAXES tax, int places) {
		super();
		this.libelle = libelle;
		this.prix = prix;
		this.taxes = tax.getTaxe();
		this.places = places;
	}

	public int getId() {
		return id;
	}
	public String getLibelle() {
		return libelle;
	}
	public float getPrix() {
		return prix;
	}
	public double getTaxes() {
		return taxes;
	}
	public int getPlaces() {
		return places;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public void setTaxes(double taxes) {
		this.taxes = taxes;
	}
	public void setPlaces(int places) {
		this.places = places;
	}
	
	
	
	
}
