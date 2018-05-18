package stock;

import java.util.List;

import stock.Article.TYPE_ARTICLE;
import stock.ArticleRestaurant.TYPE_FOOD;

public class GestionArticle {
	private List<Article> lesArticles;
	private List<ArticleRestaurant> lesArticlesRestau;
	
	public GestionArticle(List<Article> lesArticles) {
		super();
		this.lesArticles = lesArticles;
	}
	
	public void addArticle(String libelle, String description, TYPE_ARTICLE typeArticle, int quantite) {
		
	}
	public void modifierArticle(int id, String libelle, String description, TYPE_ARTICLE typeArticle, int quantite) {
		
	}
	public void addArticleRestau(String libelle, String description, int quantite, double prix, double taxe, TYPE_FOOD typeFood) {
		
	}
	public void modifierArticleRestau(int id, String libelle, String description, int quantite, double prix, double taxe, TYPE_FOOD typeFood) {
		
	}
	public void deleteArticle(Article article) {
		
	}
}
