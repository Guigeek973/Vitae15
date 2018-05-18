package restaurant;

import java.util.Date;
import java.util.List;

import hotel.Client;
import hotel.Reservation;
import main.Connection;
import stock.Article;
import stock.ArticleRestaurant;
import stock.Menu;

public class ReservationRestaurant extends Reservation {
	private int nbCouverts;
	private ServiceTable service;
	private List<ArticleRestaurant> lesPlats;
	private List<Menu> lesMenus;
	
	public ReservationRestaurant(int id, Client client, Date startDate, int nbCouverts, ServiceTable service, List<ArticleRestaurant> plats, List<Menu> menus) {
		super(id, client, startDate);
		this.nbCouverts = nbCouverts;
		this.service = service;
		this.lesPlats = plats;
		this.lesMenus = menus;
	}
	
	public ReservationRestaurant(int id, Client client, Date startDate, int nbCouverts, ServiceTable service) {
		super(id, client, startDate);
		this.nbCouverts = nbCouverts;
		this.service = service;
	}

	public int getNbCouverts() {
		return nbCouverts;
	}
	public ServiceTable getService() {
		return service;
	}
	public List<ArticleRestaurant> getLesPlats() {
		return lesPlats;
	}
	public List<Menu> getLesMenus() {
		return lesMenus;
	}
	
	public void setNbCouverts(int nbCouverts) {
		if (this.nbCouverts != nbCouverts) {
			this.nbCouverts = nbCouverts;
			Connection.execSQL("UPDATE reservationtableset SET nbTableSet = '" + this.nbCouverts + "'");
		}
	}
	public void setService(ServiceTable service) {
		if (this.service != service) {
			this.service = service;
			Connection.execSQL("UPDATE reservationtableset SET id_ServiceTable = '" + this.service + "'");
		}
	}
	// ----- GESTION DE LA LISTE -----
		//PLATS
		// AJOUT
		public void ajoutPlat(List<ArticleRestaurant> lesPlats) {
			// Pour chaque article dans la liste on va faire une requ�te SQL pour l'ins�rer
			this.lesPlats = lesPlats;
			for(ArticleRestaurant article : lesPlats) {
				Connection.execSQL("INSERT INTO commanderplat VALUES (" + this.getId() + ", " + article.getId() + ")");
			}
		}
		
		// SURCHARGE de ajoutArticle qui prend une liste d'articles en param�tre, ici on ne prend qu'un article
		public void ajoutPlat(Article article) {
			Connection.execSQL("INSERT INTO commanderplat VALUES (" + this.getId() + ", " + article.getId() + ")");
		}
		
		// SUPPRESSION
		public void supprimerPlat(List<ArticleRestaurant> lesPlats) {
			this.lesPlats = lesPlats;
			for(ArticleRestaurant article : lesPlats) {
				Connection.execSQL("DELETE FROM commanderplat WHERE id_Reservation = " + this.getId() + " AND id_ArticleRestaurant = " + article.getId());
			}
		}
		
		public void supprimerPlat(ArticleRestaurant article) {
			Connection.execSQL("DELETE FROM commanderplat WHERE id_Reservation = " + this.getId() + " AND id_ArticleRestaurant = " + article.getId());
		}
		
		//MENU
		// AJOUT
		public void ajoutMenu(List<Menu> lesMenus) {
			// Pour chaque article dans la liste on va faire une requ�te SQL pour l'ins�rer
			this.lesMenus = lesMenus;
			for(Menu article : lesMenus) {
				Connection.execSQL("INSERT INTO commandermenu VALUES (" + this.getId() + ", " + article.getId() + ")");
			}
		}
		
		// SURCHARGE de ajoutArticle qui prend une liste d'articles en param�tre, ici on ne prend qu'un article
		public void ajoutMenu(Menu article) {
			Connection.execSQL("INSERT INTO commandermenu VALUES (" + this.getId() + ", " + article.getId() + ")");
		}
		
		// SUPPRESSION
		public void supprimerMenu(List<Menu> lesMenus) {
			this.lesMenus = lesMenus;
			for(Menu article : lesMenus) {
				Connection.execSQL("DELETE FROM commandermenu WHERE id_Reservation = " + this.getId() + " AND id_Menu = " + article.getId());
			}
		}
		
		public void supprimerMenu(Menu menu) {
			this.lesMenus.remove(menu);
			Connection.execSQL("DELETE FROM commandermenu WHERE id_Menu = " + menu.getId());
		}
	
	

}
