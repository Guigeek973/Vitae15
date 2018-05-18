package stock;

import main.Connection;

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
	
	//SETTERS
	public void setLibelle(String libelle) {
		if (this.libelle != libelle) {
			this.libelle = libelle;
			Connection.execSQL("UPDATE Article SET label = '" + this.libelle + "'");
		}
	}
	public void setDescription(String description) {
		if (this.description != description) {
			this.description = description;
			Connection.execSQL("UPDATE Article SET description = '" + this.description + "'");
		}
	}
	public void setTypeArticle(TYPE_ARTICLE typeArticle) {
		if (this.typeArticle != typeArticle) {
			this.typeArticle = typeArticle;
			Connection.execSQL("UPDATE Article SET type = '" + this.typeArticle + "'");
		}
	}
	public void setQuantite(int quantite) {
		if (this.quantite != quantite) {
			this.quantite = quantite;
			Connection.execSQL("UPDATE Article SET quantity = " + this.quantite);
		}
	}
}