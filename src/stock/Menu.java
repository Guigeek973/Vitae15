package stock;
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
	public Menu(int id, String libelle, double prix, String description, List<ArticleRestaurant> lesArticles) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.prix = prix;
		this.description = description;
		this.lesArticles = lesArticles;
	}
	
	public Menu(int id, String libelle, double prix, String description) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.prix = prix;
		this.description = description;
	}

	
	
	// ----- GETTERS ------
	public int getId() {
		return id;
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
		try {
			// On vï¿½rifie si la valeur passï¿½e en paramï¿½tre est diffï¿½rente de la valeur actuelle
			if (this.libelle != libelle) {
				// Si elle est diffï¿½rente on change la valeur de l'objet et on update dans la BDD avec la nouvelle valeur
				this.libelle = libelle;
				// On appelle la mï¿½thode statique execSQL pour ï¿½xecuter une requï¿½te SQL
				Connection.execSQL("UPDATE Menu SET label = '" + this.libelle + "'");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setPrix(double prix) {
		try {
			if (this.prix != prix) {
				this.prix = prix;
				Connection.execSQL("UPDATE Menu SET price = " + this.prix);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setDescription(String description) {
		try {
			if (this.description != description) {
				this.description = description;
				Connection.execSQL("UPDATE Menu SET description = '" + this.description + "'");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	// ----- GESTION DE LA LISTE ------
	// SETTERS GLOBAUX
	public void setLesArticles(List<ArticleRestaurant> lesArticles) {
		try {
			// ON VIDE LA TABLE COMPOSER MENU DU MENU EN QUESTION
			Connection.execSQL("DELETE FROM composermenu WHERE id_Menu = " + this.getId());
			// On utilise la fonction ajoutArticle pour ajouter la liste passée en paramètre d'article au menu
			ajoutArticle(lesArticles);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// AJOUT
	public void ajoutArticle(List<ArticleRestaurant> lesArticles) {
		try {
			// Pour chaque article dans la liste on va faire une requï¿½te SQL pour l'insï¿½rer
			for(ArticleRestaurant article : lesArticles) {
				this.lesArticles.add(article);
				Connection.execSQL("INSERT INTO composermenu VALUES (" + article.getId() + ", " + this.getId() + ")");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// SURCHARGE de ajoutArticle qui prend une liste d'articles en paramï¿½tre, ici on ne prend qu'un article
	public void ajoutArticle(ArticleRestaurant article) {
		try {
			this.lesArticles.add(article);
			Connection.execSQL("INSERT INTO composermenu VALUES (" + article.getId() + ", " + this.getId() + ")");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// SUPPRESSION
	public void supprimerArticle(List<ArticleRestaurant> lesArticles) {
		try {
			for(ArticleRestaurant article : lesArticles) {
				this.lesArticles.remove(article);
				Connection.execSQL("DELETE FROM composermenu WHERE id_Article = " + article.getId() + " AND id_Menu = " + this.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void supprimerArticle(Article article) {
		try {
			this.lesArticles.remove(article);
			Connection.execSQL("DELETE FROM composermenu WHERE id_Article = " + article.getId() + " AND id_Menu = " + this.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}