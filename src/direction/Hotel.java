package direction;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import hotel.Client;
import main.Connection;
import maintenance_etages.Chambre;
import maintenance_etages.ReservationChambre;
import maintenance_etages.TypeChambre;

public class Hotel {
	private static List<Chambre> lesChambres;
	private static List<ReservationChambre> lesReservationsChambre;
	private static List<Client> lesClients;
	private static Hotel instance;

	// CONSTRUCTEUR
	private Hotel(List<Chambre> lesChambres, List<ReservationChambre> lesReservationsChambre, List<Client> clients) {
		super();
		Hotel.lesChambres = lesChambres;
		Hotel.lesReservationsChambre = lesReservationsChambre;
		Hotel.lesClients = clients;
	}
	
	public static Hotel getInstance(List<Chambre> lesChambres, List<ReservationChambre> lesReservationsChambre, List<Client> lesClients) {
		if (Hotel.instance == null) {
			Hotel.instance = new Hotel(lesChambres, lesReservationsChambre, lesClients);
		}
		return Hotel.instance;
	}
	
	// GETTERS
	public static List<Chambre> getLesChambres() {
		return lesChambres;
	}
	public static List<ReservationChambre> getLesReservationsChambre() {
		return lesReservationsChambre;
	}
	public static List<Client> getLesClients() {
		return lesClients;
	}
	
	// SETTERS
	public static void setLesClients(List<Client> lesClients) {
		Hotel.lesClients = lesClients;
	}
	public static void setLesChambres(List<Chambre> lesChambres) {
		Hotel.lesChambres = lesChambres;
	}
	public static void setLesReservationsChambre(List<ReservationChambre> lesReservationsChambre) {
		Hotel.lesReservationsChambre = lesReservationsChambre;
	}
	
	// AJOUT - SUPRESSION
	public boolean ajoutClient(String nom, String prenom, String tel) {
		// SI LE CLIENT N'EXISTE PAS
		if (!Connection.existSQL("SELECT id FROM client WHERE firstname = '" + nom + "' AND lastname = '"+ prenom + "' AND tel = '" + tel + "'")) {
			// On insert un nouveau client dans la bdd
			Connection.execSQL("INSERT INTO client(firstname, lastname, tel) VALUES ('" + nom + "', '" + prenom + "', '" + tel + "')");
			// On ajoute ce nouveau client à la liste des clients
			this.lesClients.add(new Client(nom, prenom, tel));
			// L'ajout a fonctionné on retourne vrai
			return true;
		}
		// Si l'ajout n'a pas fonctionné on retourne faux
		return false;
	}
	public void suppressionClient(Client client) {
			this.lesClients.remove(client);
			Connection.execSQL("DELETE FROM client WHERE id = " + client.getId());
	}
	public boolean ajoutChambre(String label, Chambre.ETAT_CHAMBRE etatChambre, boolean isAvailable, TypeChambre typeChambre) {
		if (!Connection.existSQL("SELECT id FROM room WHERE label = '" + label + "'")) {
			Connection.execSQL("INSERT INTO room(label, status, isAvailable, id_RoomType) VALUES ('" + label + "', '" + etatChambre + "', " + isAvailable + ", '"+typeChambre.getId()+"')");
			this.lesChambres.add(new Chambre(typeChambre, label, etatChambre, isAvailable));
			return true;
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
