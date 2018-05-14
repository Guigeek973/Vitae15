package hotel;

import java.util.List;

import maintenance_etages.Chambre;
import stock.Article;
import stock.Menu;

public class TicketRoomService extends Ticket {
	private List<Article> lesArticles;
	private List<Menu> lesMenus;
	private Chambre chambre;
	
	public TicketRoomService(int id, String titre, String description, STATUT_TICKET statut, Service service, List<Article> articles, List<Menu> menus, Chambre ch) {
		super(id, titre, description, statut, service);
		this.lesArticles = articles;
		this.lesMenus = menus;
		this.chambre = ch;
	}

	public List<Article> getLesArticles() {
		return lesArticles;
	}
	public List<Menu> getLesMenus() {
		return lesMenus;
	}
	public Chambre getChambre() {
		return chambre;
	}
	public void setLesArticles(List<Article> lesArticles) {
		this.lesArticles = lesArticles;
	}
	public void setLesMenus(List<Menu> lesMenus) {
		this.lesMenus = lesMenus;
	}
	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}
	
}
