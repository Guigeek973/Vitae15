package cuisine;

import java.util.List;

public class Restaurant {
	private List<Menu> lesMenus;
	//private List<ReservationRestaurant> lesReservations;

	public List<Menu> getLesMenus() {
		return lesMenus;
	}

	public void setLesMenus(List<Menu> lesMenus) {
		this.lesMenus = lesMenus;
	}
	
	public void AjouterMenu(float prixTTC, String libelle) {
		// INSERT INTO prixTTC, libelle
	}
	
	public void SupprimerMenu(Menu menuASuppr) {
		// DELETE FROM
	}
}
