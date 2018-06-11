package restaurant;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import hotel.Client;
import main.Connection;
import spa.PrestationSpa;
import stock.ArticleRestaurant;
import stock.Menu;

public class GestionRestaurant {
	private List<Menu> lesMenus;
	private List<ReservationRestaurant> lesReservationsRestau;
	
	// CONSTRUCTEUR
	public GestionRestaurant(List<Menu> lesMenus, List<ReservationRestaurant> lesReservationsRestau) {
		super();
		// On peut utiliser les setters car il n'ya pas de requ�te SQL dans les setters de gestio		setLesMenus(lesMenus);
		setLesReservationsRestau(lesReservationsRestau);
	}
	
	// GETTERS
	public List<Menu> getLesMenus() {
		return this.lesMenus;
	}
	
	public Menu getMenu(int id) {
		Menu menuReturn = null;
		// On boucle sur les menus pour trouver le menu avec l'id pass� en param�tre
		for (Menu menu : this.lesMenus) {
			if (menu.getId() == id) {
				// On a trouv� le menu
				menuReturn = this.lesMenus.get(menu.getId());
			}
		}
		// On retourne le menu trouv� par la boucle
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
			if (!Connection.existSQL("SELECT id FROM menu WHERE label = '" + libelle + "'")) {
				// On insert un nouveau menu dans la bdd
				Connection.execSQL("INSERT INTO Menu(label, price, description) VALUES ('" + libelle + "', " + prix + ", '" + description + "')");
				// On ajoute ce nouveau menu � la liste des menus
				// L'ajout a fonctionn� on retourne vrai
				return true;
				this.lesMenus.add(new Menu(libelle, prix, description));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// Si l'ajout n'a pas fonctionn� on retourne fau		return false;
	}
	
	public void supprimerMenu(Menu menu) {
		this.lesMenus.remove(menu);
		Connection.execSQL("DELETE FROM menu WHERE id = " + menu.getId());
	}
	
	public boolean ajouterReservationRestaurant(Client client, Date startDate, int nbCouverts, ServiceTable service) {	
		ReservationRestaurant rr = new ReservationRestaurant(client, startDate, nbCouverts, service);
		if (!Connection.existSQL("SELECT id FROM reservationtableset WHERE id_Reservation = " + rr.getId() 
				+ " AND id_ServiceTable = " + service.getId()
				+ " AND nbTableSet = " + nbCouverts)) {
			Connection.execSQL("INSERT INTO reservationtableset VALUES ('" + rr.getId() + "', " + service.getId() + ", '" + nbCouverts + "')");
			this.lesReservationsRestau.add(rr);
			return true;
		}
		else 
			return false;
	}
	
	public void modifierMenu(Menu menu, String libelle, double prix, String description) {
		
	}
	
	public void supprimerReservationRestaurant(ReservationRestaurant reservationRestaurant) {
		this.lesReservationsRestau.remove(reservationRestaurant);
		Connection.execSQL("DELETE FROM reservationtableset WHERE id = " + reservationRestaurant.getId());
	}
}
