package hotel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import main.Connection;
import maintenance_etages.Chambre;
import stock.Article;
import stock.ArticleRestaurant;
import stock.Menu;

public class TicketRoomService extends Ticket {
	private int id;
	private List<ArticleRestaurant> lesArticles;
	private List<Menu> lesMenus;
	private Chambre chambre;
	
	//CONSTRUCTOR
	public TicketRoomService(String titre, String description, STATUT_TICKET statut, Service service, List<ArticleRestaurant> articles, List<Menu> menus, Chambre ch) {
		super(titre, description, statut, service);
		this.lesArticles = articles;
		this.lesMenus = menus;
		this.chambre = ch;
	}
	
	public int getId() {
		int id = 0;
		ResultSet rs = Connection.getResultSetSQL(
				"SELECT id FROM ticketroomservice"
				+ " WHERE id_Ticket = " + super.getId() 
				+ " AND id_Room = " + this.chambre.getId());
		try {
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
