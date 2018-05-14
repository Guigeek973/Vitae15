package stock;

public class Article {
	private int id;
	private String libelle;
	private String description;
	private TYPE_ARTICLE typeArticle;
	private int quantite;
	public enum TYPE_ARTICLE {
		MAINTENANCE,
		LITERIE,
		SPA,
		RESTAURANT
	}
	
	public Article(String libelle, String description, TYPE_ARTICLE typeArticle, int quantite) {
		super();
		this.libelle = libelle;
		this.description = description;
		this.typeArticle = typeArticle;
		this.quantite = quantite;
	}
	
	
}
