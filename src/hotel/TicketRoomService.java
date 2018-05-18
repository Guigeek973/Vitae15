package hotel;

import java.util.List;

import maintenance_etages.Chambre;
import stock.Article;
import stock.ArticleRestaurant;
import stock.Menu;

public class TicketRoomService extends Ticket {
	private List<ArticleRestaurant> lesArticles;
	private List<Menu> lesMenus;
	private Chambre chambre;
	
	//CONSTRUCTOR
	public TicketRoomService(int id, String titre, String description, STATUT_TICKET statut, Service service, List<ArticleRestaurant> articles, List<Menu> menus, Chambre ch) {
		super(id, titre, description, statut, service);
		this.lesArticles = articles;
		this.lesMenus = menus;
		this.chambre = ch;
	}

	//GETTERS
	public List<ArticleRestaurant> getLesArticles() {
		return lesArticles;
	}
	public List<Menu> getLesMenus() {
		return lesMenus;
	}
	public Chambre getChambre() {
		return chambre;
	}
	
	//SETTERS
	public void setLesArticles(List<ArticleRestaurant> lesArticles) {
		this.lesArticles = lesArticles;
	}
	public void addArticleRestaurant(Menu menu) {
		
	}
	public void setLesMenus(List<Menu> lesMenus) {
		this.lesMenus = lesMenus;
	}
	public void addMenu(Menu menu) {
		
	}
	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}
	
}
