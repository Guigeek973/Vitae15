package stock;



public class ArticleRestaurant {
	private int id;
	private String libelle;
	private String description;
	private int quantite;
	private double prix;
	private double taxes;
	private TYPE_FOOD typeNourriture;
	public enum TYPE_FOOD {
		BOISSON_CHAUDE(10),
		BOISSON_FROIDE(10),
		VIENNOISERIE(5.5),
		PLAT(10),
		FRUIT(5.5);
		
		private double taxe;
		TYPE_FOOD(double tax) {
			this.taxe = tax;
		}
		
		public double getTaxe() {
			return this.taxe;
		}
	}
	
	public ArticleRestaurant(int id, String libelle, String description, int quantite, double prix, TYPE_FOOD typeFood) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.description = description;
		this.quantite = quantite;
		this.prix = prix;
		this.typeNourriture = typeFood;
		this.taxes = typeFood.getTaxe();
	}
	
	
	public double getPrix() {
		return prix;
	}
	public double getTaxes() {
		return taxes;
	}
	public TYPE_FOOD getTypeNourriture() {
		return typeNourriture;
	}
	public int getId() {
		return id;
	}
	public String getLibelle() {
		return libelle;
	}
	public String getDescription() {
		return description;
	}
	public int getQuantite() {
		return quantite;
	}
	
	
	
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public void setTaxes(double taxes) {
		this.taxes = taxes;
	}
	public void setTypeNourriture(TYPE_FOOD typeNourriture) {
		this.typeNourriture = typeNourriture;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
