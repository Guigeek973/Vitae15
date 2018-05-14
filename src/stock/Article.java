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
	
	public Article(int id, String libelle, String description, TYPE_ARTICLE typeArticle, int quantite) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.description = description;
		this.typeArticle = typeArticle;
		this.quantite = quantite;
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
	public TYPE_ARTICLE getTypeArticle() {
		return typeArticle;
	}
	public int getQuantite() {
		return quantite;
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
	public void setTypeArticle(TYPE_ARTICLE typeArticle) {
		this.typeArticle = typeArticle;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	
	
}
