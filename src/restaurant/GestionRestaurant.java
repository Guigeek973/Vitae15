package restaurant;

import java.sql.SQLException;
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
	public Menu getMenu(int id) {
		Menu menuReturn = null;
		for (Menu menu : lesMenus) {
			if (menu.getId() == id) {
				menuReturn = lesMenus.get(menu.getId());
			}
		}
		return menuReturn;
	}
	
	public List<ReservationRestaurant> getLesReservationsRestau() {
		return lesReservationsRestau;
	}
	public int getNbPetitDejJour() {
		return 0;
	}
	
	// SETTERS GLOBAUX
	public void setLesMenus(List<Menu> lesMenus) {
		this.lesMenus = lesMenus;
	}
	public void setLesReservationsRestau(List<ReservationRestaurant> lesReservationsRestau) {
		this.lesReservationsRestau = lesReservationsRestau;
	}
	

	public boolean ajouterMenu(String libelle, double prix, String description) {
		try {
			// SI LE LABEL DU MENU N'EXISTE PAS
			if (!Connection.existSQL("SELECT id FROM menu WHERE label = " + libelle)) {
				// On insert un nouveau menu dans la bdd
				Connection.execSQL("INSERT INTO Menu VALUES ('" + libelle + "', " + prix + ", '" + description + "')");
				// On récupère l'id de ce menu tout juste inséré
				int idNewMenu = Connection.getResultSetSQL("SELECT id FROM menu WHERE label = " + libelle).getInt("id");
				// On ajoute ce nouveau menu à la liste des menus
				this.lesMenus.add(new Menu(idNewMenu, libelle, prix, description));
				// L'ajout a fonctionné on retourne vrai
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// Si l'ajout n'a pas fonctionné on retourne faux
		return false;
	}
	
	public void supprimerMenu(Menu menu) {
		this.lesMenus.remove(menu);
		Connection.execSQL("DELETE FROM menu WHERE id = " + menu.getId());
	}
}
