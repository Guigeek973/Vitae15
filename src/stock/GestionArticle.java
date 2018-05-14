package stock;

import java.util.List;

import stock.Article.TYPE_ARTICLE;
import stock.ArticleRestaurant.TYPE_FOOD;

public class GestionArticle {
	private List<Article> lesArticles;
	public GestionArticle(List<Article> lesArticles) {
		super();
		this.lesArticles = lesArticles;
	}
	
	public void addArticle(Article article, String libelle, String description, TYPE_ARTICLE typeArticle, int quantite) {
		
	}
	public void modifierArticle(Article article, String libelle, String description, TYPE_ARTICLE typeArticle, int quantite) {
		
	}
	public void addArticleRestau(Article article, String libelle, String description, TYPE_ARTICLE typeArticle, int quantite, double prix, double taxe, TYPE_FOOD typeFood) {
		
	}
	public void modifierArticleRestau(Article article, String libelle, String description, TYPE_ARTICLE typeArticle, int quantite, double prix, double taxe, TYPE_FOOD typeFood) {
		
	}
	public void deleteArticle(Article article) {
		
	}
}
