package stock;
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
		this.description = description;;
		this.lesArticles = lesArticles;
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
		// On v�rifie si la valeur pass�e en param�tre est diff�rente de la valeur actuelle
		if (this.libelle != libelle) {
			// Si elle est diff�rente on change la valeur de l'objet et on update dans la BDD avec la nouvelle valeur
			this.libelle = libelle;
			// On appelle la m�thode statique execSQL pour �xecuter une requ�te SQL
			Connection.execSQL("UPDATE Menu SET label = '" + this.libelle + "'");
		}
	}
	
	public void setPrix(double prix) {
		if (this.prix != prix) {
			this.prix = prix;
			Connection.execSQL("UPDATE Menu SET price = " + this.prix);
		}
	}
	
	public void setDescription(String description) {
		if (this.description != description) {
			this.description = description;
			Connection.execSQL("UPDATE Menu SET description = '" + this.description + "'");
		}
	}
	
	
	
	// ----- GESTION DE LA LISTE ------
	// AJOUT
	public void ajoutArticle(List<ArticleRestaurant> lesArticles) {
		// Pour chaque article dans la liste on va faire une requ�te SQL pour l'ins�rer
		for(ArticleRestaurant article : lesArticles) {
			this.lesArticles.add(article);
			Connection.execSQL("INSERT INTO composermenu VALUES (" + article.getId() + ", " + this.getId() + ")");
		}
	}
	
	// SURCHARGE de ajoutArticle qui prend une liste d'articles en param�tre, ici on ne prend qu'un article
	public void ajoutArticle(ArticleRestaurant article) {
		this.lesArticles.add(article);
		Connection.execSQL("INSERT INTO composermenu VALUES (" + article.getId() + ", " + this.getId() + ")");
	}
	
	// SUPPRESSION
	public void supprimerArticle(List<ArticleRestaurant> lesArticles) {
		for(ArticleRestaurant article : lesArticles) {
			this.lesArticles.remove(article);
			Connection.execSQL("DELETE FROM composermenu WHERE id_Article = " + article.getId() + " AND id_Menu = " + this.getId());
		}
	}
	
	public void supprimerArticle(Article article) {
		this.lesArticles.remove(article);
		Connection.execSQL("DELETE FROM composermenu WHERE id_Article = " + article.getId() + " AND id_Menu = " + this.getId());
	}
}