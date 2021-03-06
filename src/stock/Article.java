package stock;

import java.sql.ResultSet;
import java.sql.SQLException;

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
	
	public Article(String libelle, String description, TYPE_ARTICLE typeArticle, int quantite) {
		this.libelle = libelle;
		this.description = description;
		this.typeArticle = typeArticle;
		this.quantite = quantite;
	}

	public int getId() {
		int id = 0;
		try {
			ResultSet rs = Connection.getResultSetSQL(
					"SELECT id FROM article "
					+ "WHERE label = '" + this.libelle + "'");
			id = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.id;
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
			if (!Connection.existSQL("SELECT id FROM article WHERE label = '" + libelle + "'")) {
			this.libelle = libelle;
			Connection.execSQL("UPDATE Article SET label = '" + libelle + "'");
			}
		}
	}
	public void setDescription(String description) {
		if (this.description != description) {
			this.description = description;
			Connection.execSQL("UPDATE Article SET description = '" + description + "'");
		}
	}
	public void setTypeArticle(TYPE_ARTICLE typeArticle) {
		if (this.typeArticle != typeArticle) {
			this.typeArticle = typeArticle;
			Connection.execSQL("UPDATE Article SET type = '" + typeArticle + "'");
		}
	}
	public void setQuantite(int quantite) {
		if (this.quantite != quantite) {
			this.quantite = quantite;
			Connection.execSQL("UPDATE Article SET quantity = " + quantite);
		}
	}
}