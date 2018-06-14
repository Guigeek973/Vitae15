package restaurant;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import hotel.Client;
import hotel.Reservation;
import main.Connection;
import stock.Article;
import stock.ArticleRestaurant;
import stock.Menu;

public class ReservationRestaurant extends Reservation {
	private int id;
	private int nbCouverts;
	private ServiceTable service;
	private List<ArticleRestaurant> lesPlats;
	private List<Menu> lesMenus;
	
	public ReservationRestaurant(Client client, Date startDate, int nbCouverts, ServiceTable service) {
		super(client, startDate);
		this.nbCouverts = nbCouverts;
		this.service = service;
	}
	
	public int getId() {
		ResultSet rs = Connection.getResultSetSQL(
				"SELECT id FROM reservationtableset "
				+ "WHERE nbTableSet = " + this.nbCouverts 
				+ " AND id_ServiceTable = " + this.service.getId() + " AND id_Reservation = " 
				+ super.getId());
			
		try {
			rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
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
			Connection.execSQL("UPDATE reservationtableset SET nbTableSet = " + nbCouverts);
		}
	}
	public void setService(ServiceTable service) {
		if (this.service != service) {
			this.service = service;
			Connection.execSQL("UPDATE reservationtableset SET id_ServiceTable = " + service.getId());
		}
	}
	
	// ----- GESTION DE LA LISTE -----
		//PLATS
		// AJOUT
		public void ajoutPlat(List<ArticleRestaurant> lesPlats) {
			for(ArticleRestaurant article : lesPlats) {
				ajoutPlat(article);
			}
		}
		
		// SURCHARGE de ajoutArticle qui prend une liste d'articles en param�tre, ici on ne prend qu'un article
		public void ajoutPlat(ArticleRestaurant article) {
			Connection.execSQL("INSERT INTO commanderplat VALUES (" + this.getId() + ", " + article.getId() + ")");
		}
		
		// SUPPRESSION
		public void supprimerPlat(List<ArticleRestaurant> lesPlats) {
			for(ArticleRestaurant article : lesPlats) {
				supprimerPlat(article);
			}
		}
		
		public void supprimerPlat(ArticleRestaurant plat) {
			lesPlats.remove(plat);
			Connection.execSQL("DELETE FROM commanderplat WHERE id_Reservation = " + this.getId() + " AND id_ArticleRestaurant = " + plat.getId());
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
			for(Menu menu : lesMenus) {
				supprimerMenu(menu);
			}
		}
		
		public void supprimerMenu(Menu menu) {
			this.lesMenus.remove(menu);
			Connection.execSQL("DELETE FROM commandermenu WHERE id_Reservation = " + this.getId());
		}
	
	

}
