package direction;

import java.sql.SQLException;
import java.util.List;

import hotel.Client;
import main.Connection;
import maintenance_etages.Chambre;
import maintenance_etages.ReservationChambre;
import maintenance_etages.TypeChambre;
import maintenance_etages.Chambre.ETAT_CHAMBRE;
import stock.Menu;

public class Hotel {
	private List<Chambre> lesChambres;
	private List<ReservationChambre> lesReservationsChambre;
	private List<Client> lesClients;

	// CONSTRUCTEUR
	public Hotel(List<Chambre> lesChambres, List<ReservationChambre> lesReservationsChambre, List<Client> clients) {
		super();
		this.lesChambres = lesChambres;
		this.lesReservationsChambre = lesReservationsChambre;
		this.lesClients = clients;
	}
	
	// GETTERS
	public List<Chambre> getLesChambres() {
		return lesChambres;
	}
	public List<ReservationChambre> getLesReservationsChambre() {
		return lesReservationsChambre;
	}
	public List<Client> getLesClients() {
		return lesClients;
	}
	
	// SETTERS
	public void setLesClients(List<Client> lesClients) {
		this.lesClients = lesClients;
	}
	public void setLesChambres(List<Chambre> lesChambres) {
		this.lesChambres = lesChambres;
	}
	public void setLesReservationsChambre(List<ReservationChambre> lesReservationsChambre) {
		this.lesReservationsChambre = lesReservationsChambre;
	}
	
	// AJOUT - SUPRESSION
	public boolean ajoutClient(String nom, String prenom, String tel) {
		try {
			// SI LE CLIENT N'EXISTE PAS
			if (!Connection.existSQL("SELECT id FROM client WHERE firstname = '" + nom + "' AND lastname = '"+ prenom + "' AND tel = '" + tel + "'")) {
				// On insert un nouveau client dans la bdd
				Connection.execSQL("INSERT INTO client(firstname, lastname, tel) VALUES ('" + nom + "', '" + prenom + "', '" + tel + "')");
				// On récupère l'id de ce client tout juste inséré
				int idNewClient = Connection.getResultSetSQL("SELECT id FROM client WHERE firstname = '" + nom + "' AND lastname = '"+ prenom + "' AND tel = '" + tel + "'").getInt("id");
				// On ajoute ce nouveau client à la liste des clients
				this.lesClients.add(new Client(idNewClient, nom, prenom, tel));
				// L'ajout a fonctionné on retourne vrai
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// Si l'ajout n'a pas fonctionné on retourne faux
		return false;
	}
	public void suppressionClient(Client client) {
			this.lesClients.remove(client);
			Connection.execSQL("DELETE FROM client WHERE id = " + client.getId());
	}
	public boolean ajoutChambre(TypeChambre typeChambre, String libelle) {
		// TODO : ajoutChambre
//		try {
//			// SI LE CLIENT N'EXISTE PAS
//			if (!Connection.existSQL("SELECT id FROM room WHERE libelle = '" + libelle + "'")) {
//				// On insert un nouveau client dans la bdd
//				Connection.execSQL("INSERT INTO room(label, lastname, tel) VALUES ('" + nom + "', '" + prenom + "', '" + tel + "')");
//				// On récupère l'id de ce client tout juste inséré
//				int idNewClient = Connection.getResultSetSQL("SELECT id FROM client WHERE firstname = '" + nom + "' AND lastname = '"+ prenom + "' AND tel = '" + tel + "'").getInt("id");
//				// On ajoute ce nouveau client à la liste des clients
//				this.lesClients.add(new Client(idNewClient, nom, prenom, tel));
//				// L'ajout a fonctionné on retourne vrai
//				return true;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		// Si l'ajout n'a pas fonctionné on retourne faux
		return false;
	}
	public void suppressionChambre(Chambre chambre) {
		this.lesChambres.remove(chambre);
		Connection.execSQL("DELETE FROM room WHERE id = " + chambre.getId());
}
	public void suppressionReservation(ReservationChambre reservationChambre) {
		this.lesReservationsChambre.remove(reservationChambre);
		Connection.execSQL("DELETE FROM reservationroom WHERE id = " + reservationChambre.getId());
}
	
	
	public double getTauxJournalier() {
		return 0;
	}
	public double getDureeMoyenne() {
		return 0;
	}
	public double getPanierMoyen() {
		return 0;
	}
	
}
