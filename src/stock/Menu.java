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
		this.libelle = libelle;
		this.prix = prix;
		this.description = description;
		this.lesArticles = lesArticles;
	}

	public Menu(String libelle, double prix, String description) {
		this.libelle = libelle;
		this.prix = prix;
		this.description = description;
	}

	public int getId() {
		int id = 0;
		try {
			ResultSet rs = Connection.getResultSetSQL("SELECT id FROM article WHERE label = '" + this.libelle + "'");
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

	public boolean setLibelle(String libelle) {
		boolean retour = false;
		// On vï¿½rifie si la valeur passee en parametre est differente de la valeur actuelle
		if (!this.libelle.equals(libelle)) {
			// On vérifie que ce libelle n'est pas déjà pris
			if (!Connection.existSQL("SELECT id FROM menu WHERE label = '" + libelle + "'")) {
				// Si elle est differente on change la valeur de l'objet et on update dans la BDD avec la nouvelle valeur
				this.libelle = libelle;
				// On appelle la methode statique execSQL pour executer une requete SQL
				Connection.execSQL("UPDATE menu SET label = '" + libelle + "' WHERE id = " + this.getId());
				retour = true;
			}
		}
		return retour;
	}

	public void setPrix(double prix) {
		if (this.prix != prix) {
			this.prix = prix;
			Connection.execSQL("UPDATE menu SET price = " + prix + " WHERE id = " + this.getId());
		}
	}

	public void setDescription(String description) {
		if (!this.description.equals(description)) {
			this.description = description;
			Connection.execSQL("UPDATE menu SET description = '" + description + "' WHERE id = " + this.getId());
		}
	}

	// ----- GESTION DE LA LISTE ------
	// SETTERS GLOBAUX
	public void setLesArticles(List<ArticleRestaurant> lesArticles) {
		// ON VIDE LA TABLE COMPOSER MENU DU MENU EN QUESTION
		Connection.execSQL("DELETE FROM composermenu WHERE id_Menu = " + this.getId());
		// On vide tout les articles du menu
		this.lesArticles.clear();
		// On ajoute tout les articles de la liste passée en parametre
		ajoutArticle(lesArticles);
	}

	// AJOUT
	public void ajoutArticle(List<ArticleRestaurant> lesArticles) {
		// Pour chaque article dans la liste on va faire une requete SQL pour l'inserer
		for (ArticleRestaurant article : lesArticles) {
			ajoutArticle(article);
		}
	}

	// SURCHARGE de ajoutArticle qui prend une liste d'articles en parametre, ici
	// on ne prend qu'un article
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