package restaurant;

import java.util.List;

import stock.Menu;

public class GestionRestaurant {
	private List<Menu> lesMenus;
	private List<ReservationRestaurant> lesReservationsRestau;
	
	public GestionRestaurant(List<Menu> lesMenus, List<ReservationRestaurant> lesReservationsRestau) {
		super();
		this.lesMenus = lesMenus;
		this.lesReservationsRestau = lesReservationsRestau;
	}
	public List<Menu> getLesMenus() {
		return lesMenus;
	}
	public List<ReservationRestaurant> getLesReservationsRestau() {
		return lesReservationsRestau;
	}
	public void setLesMenus(List<Menu> lesMenus) {
		this.lesMenus = lesMenus;
	}
	public void setLesReservationsRestau(List<ReservationRestaurant> lesReservationsRestau) {
		this.lesReservationsRestau = lesReservationsRestau;
	}

	public int getNbPetitDejJour() {
		return 0;
	}
	public void addMenu(String libelle, double prix) {
		
	}
	public void supprimerMenu(Menu menu) {
		
	}
	public void setMenu(Menu menu, double prix, String libelle) {
		
	}
	public Menu getMenu(int id) {
		return null;
	}
}
