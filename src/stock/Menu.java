package stock;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import main.Connection;

public class Menu {
	private int id;
	private String libelle;
	private double prix;
	private String description;
	private List<ArticleRestaurant> lesArticles;

	// CONSTRUCTEUR
	public Menu(String libelle, double prix, String description, List<ArticleRestaurant> lesArticles) {
		super();
		this.libelle = libelle;
		this.prix = prix;
		this.description = description;
		this.lesArticles = lesArticles;
	}

	public Menu(String libelle, double prix, String description) {
		super();
		this.libelle = libelle;
		this.prix = prix;
		this.description = description;
	}

	public int getId() {
		int id = 0;
		try {
			ResultSet rs = Connection.getResultSetSQL(
					"SELECT id FROM article "
					+ "WHERE label = " + this.libelle
					+ " AND description = " + this.description
					+ " AND price = " + this.prix);
			id = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setId(id);
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
		if (this.id != id) {
			this.id = id;
			Connection.execSQL("UPDATE menu SET id = " + this.id + " WHERE label = '"+this.getLibelle()+"'");
		}
	}

	public String getLibelle() {
		return libelle;
	}

	public double getPrix() {
		return prix;
	}

	public String getDescription() {
		return description;
	}

	public List<ArticleRestaurant> getLesArticles() {
		return lesArticles;
	}

	// ----- SETTERS ------

	public void setLibelle(String libelle) {
		// On vï¿½rifie si la valeur passï¿½e en paramï¿½tre est diffï¿½rente de la valeur actuelle
		if (!this.libelle.equals(libelle)) {
			// Si elle est diffï¿½rente on change la valeur de l'objet et on update dans la BDD avec la nouvelle valeur
			this.libelle = libelle;
			// On appelle la mï¿½thode statique execSQL pour ï¿½xecuter une requï¿½te SQL
			Connection.execSQL("UPDATE Menu SET label = '" + this.libelle + "' WHERE id = " + this.getId());
		}
	}

	public void setPrix(double prix) {
		if (this.prix != prix) {
			this.prix = prix;
			Connection.execSQL("UPDATE Menu SET price = " + this.prix + " WHERE id = " + this.getId());
		}
	}

	public void setDescription(String description) {
		if (!this.description.equals(description)) {
			this.description = description;
			Connection.execSQL("UPDATE Menu SET description = '" + this.description + "' WHERE id = " + this.getId());
		}
	}

	// ----- GESTION DE LA LISTE ------
	// SETTERS GLOBAUX
	public void setLesArticles(List<ArticleRestaurant> lesArticles) {
		// ON VIDE LA TABLE COMPOSER MENU DU MENU EN QUESTION
		Connection.execSQL("DELETE FROM composermenu WHERE id_Menu = " + this.getId());
		// On ajoute tout les articles de la liste passée en parametre
		for (ArticleRestaurant article : lesArticles) {
			// Pour chaque article à rajouter on fait un insert dans la table composer menu
			Connection.execSQL("INSERT INTO composermenu (id) VALUES ("+article.getId()+") WHERE id_Menu = " + this.getId());
		}
	}

	// AJOUT
	public void ajoutArticle(List<ArticleRestaurant> lesArticles) {
		// Pour chaque article dans la liste on va faire une requï¿½te SQL pour l'inserer
		for (ArticleRestaurant article : lesArticles) {
			ajoutArticle(article);
		}
	}

	// SURCHARGE de ajoutArticle qui prend une liste d'articles en paramï¿½tre, ici on ne prend qu'un article
	public void ajoutArticle(ArticleRestaurant article) {
		this.lesArticles.add(article);
		Connection.execSQL("INSERT INTO composermenu VALUES (" + article.getId() + ", " + this.getId() + ")");
	}

	// SUPPRESSION
	public void supprimerArticle(List<ArticleRestaurant> lesArticles) {
		for (ArticleRestaurant article : lesArticles) {
			supprimerArticle(article);
		}
	}

	public void supprimerArticle(ArticleRestaurant article) {
		this.lesArticles.remove(article);
		Connection.execSQL("DELETE FROM composermenu WHERE id_Article = " + article.getId() + " AND id_Menu = " + this.getId());
	}
}