package restaurant;

import java.util.Date;
import java.util.List;

import hotel.Client;
import hotel.Reservation;
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
		this.nbCouverts = nbCouverts;
	}
	public void setService(ServiceTable service) {
		this.service = service;
	}
	public void setLesPlats(List<ArticleRestaurant> lesPlats) {
		this.lesPlats = lesPlats;
	}
	public void setLesMenus(List<Menu> lesMenus) {
		this.lesMenus = lesMenus;
	}
	
	

}
