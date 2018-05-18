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
		// On peut utiliser les setters car il n'ya pas de requête SQL dans les setters de gestion
		setLesMenus(lesMenus);
		setLesReservationsRestau(lesReservationsRestau);
	}
	
	// GETTERS
	public List<Menu> getLesMenus() {
		return this.lesMenus;
	}
	public Menu getMenu(int id) {
		Menu menuReturn = null;
		// On boucle sur les menus pour trouver le menu avec l'id passé en paramètre
		for (Menu menu : this.lesMenus) {
			if (menu.getId() == id) {
				// On a trouvé le menu
				menuReturn = this.lesMenus.get(menu.getId());
			}
		}
		// On retourne le menu trouvé par la boucle
		return menuReturn;
	}
	public List<ReservationRestaurant> getLesReservationsRestau() {
		return lesReservationsRestau;
	}
	public ReservationRestaurant getReservationRestaurant(int id) {
		ReservationRestaurant reservationRestaurant = null;
		for (ReservationRestaurant reservation : this.lesReservationsRestau) {
			if (reservation.getId() == id) {
				reservationRestaurant = this.lesReservationsRestau.get(reservation.getId());
			}
		}
		return reservationRestaurant;
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
	
	
	// AJOUT - SUPPRESSION LISTES

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
	
	
//	public boolean ajouterReservationRestaurant(int nbCouverts, ServiceTable service) {
//		// AJOUTER UNE RESERVATION
//		this.lesReservationsRestau.add(new ReservationRestaurant(nbCouverts, null, null, nbCouverts, service, null, null));
//		try {
//			if (!Connection.existSQL("SELECT id FROM reservationtableset WHERE id = " + libelle)) {
//				Connection.execSQL("INSERT INTO Menu VALUES ('" + libelle + "', " + prix + ", '" + description + "')");
//				int idNewMenu = Connection.getResultSetSQL("SELECT id FROM menu WHERE label = " + libelle).getInt("id");
//				this.lesMenus.add(new Menu(idNewMenu, libelle, prix, description));
//				return true;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return false;
//	}
	
	public void supprimerReservationRestaurant(ReservationRestaurant reservationRestaurant) {
		this.lesReservationsRestau.remove(reservationRestaurant);
		Connection.execSQL("DELETE FROM reservationtableset WHERE id = " + reservationRestaurant.getId());
	}
}
