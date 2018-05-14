package stock;

import java.util.List;

public class Menu {
	private int id;
	private String libelle;
	private double prix;
	private List<ArticleRestaurant> lesArticles;
	
	public Menu(int id, String libelle, double prix, List<ArticleRestaurant> lesArticles) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.prix = prix;
		this.lesArticles = lesArticles;
	}

	public int getId() {
		return id;
	}
	public String getLibelle() {
		return libelle;
	}
	public double getPrix() {
		return prix;
	}
	public List<ArticleRestaurant> getLesArticles() {
		return lesArticles;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public void setLesArticles(List<ArticleRestaurant> lesArticles) {
		this.lesArticles = lesArticles;
	}
	
	
	
}
