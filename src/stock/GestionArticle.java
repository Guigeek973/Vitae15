package stock;

import java.util.List;

import main.Connection;
import stock.Article.TYPE_ARTICLE;
import stock.ArticleRestaurant.TYPE_FOOD;

public class GestionArticle {
	private List<Article> lesArticles;
	
	public GestionArticle(List<Article> lesArticles) {
		this.lesArticles = lesArticles;
	}
	
	public void creerArticle(String libelle, String description, TYPE_ARTICLE typeArticle, int quantite) {
		Article article = new Article(libelle, description, typeArticle, quantite);
		Connection.execSQL("INSERT INTO article (label, description, quantity, type) VALUES ('"+libelle+"','"+description+"', '"+typeArticle+"', "+quantite+")");
		lesArticles.add(article);
	}
	public void modifierArticle(int id, String libelle, String description, TYPE_ARTICLE typeArticle, int quantite) {
		
	}
	
	
	public void creerArticleRestau(String libelle, String description, int quantite, double prix, double taxe, TYPE_FOOD typeFood) {
//		ArticleRestaurant article = new ArticleRestaurant();
//		Connection.execSQL("INSERT INTO articlerestaurant (label, description, quantity, price, taxes, typeFood) VALUES ('"+libelle+"','"+description+"', '"+typeArticle+"', "+quantite+")");
//		lesArticles.add(article);
	}
	public void modifierArticleRestau(int id, String libelle, String description, int quantite, double prix, double taxe, TYPE_FOOD typeFood) {
		 
	}
	public void deleteArticle(Article article) {
		
	}
}