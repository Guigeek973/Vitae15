package direction;

import java.sql.ResultSet;
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
	public boolean ajoutChambre(String label, Chambre.ETAT_CHAMBRE etatChambre, boolean isAvailable, TypeChambre typeChambre) {
		try {
			if (!Connection.existSQL("SELECT id FROM room WHERE label = '" + label + "'")) {
				Connection.execSQL("INSERT INTO room(label, status, isAvailable, id_RoomType) VALUES ('" + label + "', '" + etatChambre + "', " + isAvailable + ", '"+typeChambre.getId()+"')");
				int idNewRoom = Connection.getResultSetSQL("SELECT id FROM room WHERE label = '" + label + "'").getInt("id");
				this.lesChambres.add(new Chambre(idNewRoom, typeChambre, label, etatChambre, isAvailable));
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// Si l'ajout n'a pas fonctionné on retourne faux
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
		double tauxJ = 0;
		try {
			ResultSet rs = Connection.getResultSetSQL("SELECT((SELECT count(room.id) FROM room WHERE room.isAvailable = 1) / (SELECT count(room.id) FROM room)) AS tauxJ");
			tauxJ = rs.getDouble("tauxJ");
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return tauxJ;
	}
	public double getDureeMoyenne() {
		double dureeMoyenne = 0;
		try {
		ResultSet rs = Connection.getResultSetSQL("SELECT AVG(DATEDIFF(reservationroom.endDate, reservation.startDate)) AS DureeMoyenne FROM reservationroom INNER join reservation on reservation.id = reservationroom.id");
		dureeMoyenne = rs.getDouble("DureeMoyenne");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dureeMoyenne;
	}
	public double getPanierMoyen() {
		// TODO : Récupérer le panier moyen des clients
		return 0;
	}
	
}
