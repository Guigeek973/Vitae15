package stock;

public class ArticleRestaurant extends Article {
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
	
	public ArticleRestaurant(int id, String libelle, String description, TYPE_ARTICLE typeArticle, int quantite, double prix, TYPE_FOOD typeFood) {
		super(id, libelle, description, typeArticle, quantite);
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
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public void setTaxes(double taxes) {
		this.taxes = taxes;
	}
	public void setTypeNourriture(TYPE_FOOD typeNourriture) {
		this.typeNourriture = typeNourriture;
	}
	
	
	
}
