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
	
	public ArticleRestaurant(String libelle, String description, TYPE_ARTICLE typeArticle, int quantite, double prix, TYPE_FOOD typeFood) {
		super(libelle, description, typeArticle, quantite);
		this.prix = prix;
		this.typeNourriture = typeFood;
		this.taxes = typeFood.getTaxe();
	}
	
}
