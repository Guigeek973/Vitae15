package spa;

import java.util.Date;
import java.util.List;

import hotel.Client;
import hotel.Reservation;
import main.Connection;
import spa.ReservationSpa;
import spa.PrestationSpa;

public class GestionSpa {
	private List<PrestationSpa> lesPrestationsSpa;
	private List<ReservationSpa> lesReservationsSpa;
	
	// CONSTRUCTEUR
	public GestionSpa(List<PrestationSpa> lesPrestationsSpa, List<ReservationSpa> lesReservationsSpa) {
		// On peut utiliser les setters car il n'ya pas de requête SQL dans les setters de gestion
		setLesPrestations(lesPrestationsSpa);
		setLesReservationsSpa(lesReservationsSpa);
	}

	// GETTERS
	public List<PrestationSpa> getLesPrestationsSpa() {
		return this.lesPrestationsSpa;
	}
	
	public List<ReservationSpa> getLesReservationSpa() {
		return this.lesReservationsSpa;
	}

	// SETTERS GLOBAUX
	public void setLesPrestations(List<PrestationSpa> lesPrestationsSpa) {
		this.lesPrestationsSpa = lesPrestationsSpa;
	}
	
	public void setLesReservationsSpa(List<ReservationSpa> lesReservationsSpa) {
		this.lesReservationsSpa = lesReservationsSpa;
	}
	
	// AJOUT - SUPPRESSION LISTES
	public boolean addPrestationSpa(String libelle, double prix, Date duree) {
		// SI LE LABEL DE LA PRESTATION N'EXISTE PAS
		if (!Connection.existSQL("SELECT id FROM prestation WHERE label = '" + libelle + "'")) {
			// On insert une nouvelle prestation dans la bdd
			Connection.execSQL("INSERT INTO Prestation(label, price, duration) VALUES ('" + libelle + "', " + prix + ", '" + duree + "')");
			// On ajoute cette prestation à la liste des prestations
			this.lesPrestationsSpa.add(new PrestationSpa(libelle, prix, duree));
			// L'ajout a fonctionné on retourne vrai
			return true;
		}
		// Si l'ajout n'a pas fonctionné on retourne faux
		return false;
	}
	

	
	public boolean addReservationSpa(Client client, Date startDate, PrestationSpa prestationSpa) {
//		if (!Connection.existSQL("SELECT id FROM reservationspa WHERE id_ = '" + libelle + "'")) {
//		}
		return false;

	}
	
	public void modifierReservation(ReservationSpa reservation, Client client, Date created_at, Date modified_at, PrestationSpa prestation, Date startDate, Reservation.STATUT_RESERVATION statut) {
		reservation.setClient(client);
		reservation.setCreated_at(created_at);
		reservation.setModified_at(modified_at);
		reservation.setPrestation(prestation);
		reservation.setStartDate(startDate);
		reservation.setStatut(statut);
	}
	
	public void modifierPrestation(PrestationSpa prestation, String libelle, double prix, Date duree) {
		prestation.setLibelle(libelle);
		prestation.setPrix(prix);
		prestation.setDuree(duree);
	}
	
	public void supprimerReservation(ReservationSpa reservationSpa) {
		this.lesReservationsSpa.remove(reservationSpa);
		Connection.execSQL("DELETE FROM reservationspa WHERE id = " + reservationSpa.getId());
	}
	
	public void supprimerPrestation(PrestationSpa prestationSpa) {
		this.lesPrestationsSpa.remove(prestationSpa);
		Connection.execSQL("DELETE FROM prestation WHERE id = " + prestationSpa.getId());
	}
}
