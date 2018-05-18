package restaurant;

import java.util.List;

import main.Connection;
import stock.ArticleRestaurant;
import stock.Menu;

public class GestionRestaurant {
	private List<Menu> lesMenus;
	private List<ReservationRestaurant> lesReservationsRestau;
	
	// CONSTRUCTEUR
	public GestionRestaurant(List<Menu> lesMenus, List<ReservationRestaurant> lesReservationsRestau) {
		super();
		this.lesMenus = lesMenus;
		this.lesReservationsRestau = lesReservationsRestau;
	}
	
	// GETTERS
	public List<Menu> getLesMenus() {
		return lesMenus;
	}
	public List<ReservationRestaurant> getLesReservationsRestau() {
		return lesReservationsRestau;
	}
	
	// SETTERS
	public void setLesMenus(List<Menu> lesMenus) {
		this.lesMenus = lesMenus;
	}
	public void setLesReservationsRestau(List<ReservationRestaurant> lesReservationsRestau) {
		this.lesReservationsRestau = lesReservationsRestau;
	}

	public int getNbPetitDejJour() {
		return 0;
	}
	public void addMenu(String libelle, double prix, String description, List<ArticleRestaurant> lesArticles) {
//		Connection.execSQL("INSERT INTO menu(price, label, description) VALUES (" + prix + ",'" + libelle + "', '" + description + "')");
//		
//		lesMenus.add(new Menu(0, "", prix, description, lesArticles));
	}
	public void supprimerMenu(Menu menu) {
		Connection.execSQL("DELETE FROM menu WHERE id = " + menu.getId());
	}
	public Menu getMenu(int id) {
		return null;
	}
}
