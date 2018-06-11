package spa;

import java.util.Date;
import java.util.List;

import hotel.Client;
import main.Connection;
import spa.ReservationSpa;
import spa.PrestationSpa;

public class GestionSpa {
	private List<PrestationSpa> lesPrestationsSpa;
	private List<ReservationSpa> lesReservationsSpa;
	
	// CONSTRUCTEUR
	public GestionSpa(List<PrestationSpa> lesPrestationsSpa, List<ReservationSpa> lesReservationsSpa) {
		super();
		// On peut utiliser les setters car il n'ya pas de requête SQL dans les setters de gestion
		setLesPrestations(lesPrestationsSpa);
		setLesReservationsSpa(lesReservationsSpa);
	}

	// GETTERS
	public List<PrestationSpa> getLesPrestationsSpa() {
		return this.lesPrestationsSpa;
	}

	public PrestationSpa getPrestationSpa(int id) {
		PrestationSpa prestationReturn = null;
		// On boucle sur les prestations pour trouver la prestation avec l'id passé en paramètre
		for (PrestationSpa prestationspa : this.lesPrestationsSpa) {
			if (prestationspa.getId() == id) {
				// On a trouvé le menu
				prestationReturn = this.lesPrestationsSpa.get(prestationspa.getId());
			}
		}
		// On retourne le menu trouvé par la boucle
		return prestationReturn;
	}
	
	public List<ReservationSpa> getLesReservationSpa() {
		return lesReservationsSpa;
	}
	
	public ReservationSpa getReservationSpa(int id) {
		ReservationSpa reservationSpa = null;
		for (ReservationSpa reservation : this.lesReservationsSpa) {
			if (reservation.getId() == id) {
				reservationSpa = this.lesReservationsSpa.get(reservation.getId());
			}
		}
		return reservationSpa;
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
	
	public void deletePrestationSpa(PrestationSpa prestationSpa) {
		this.lesPrestationsSpa.remove(prestationSpa);
		Connection.execSQL("DELETE FROM prestation WHERE id = " + prestationSpa.getId());
	}
	
	public boolean addReservationSpa(Client client, Date startDate, PrestationSpa prestationSpa) {

		return false;

	}
	
	public void modifierPrestation(PrestationSpa p, String libelle, double prix, Date duree) {
		
	}
	
	public void supprimerReservationSpa(ReservationSpa reservationSpa) {
		this.lesReservationsSpa.remove(reservationSpa);
		Connection.execSQL("DELETE FROM reservationspa WHERE id = " + reservationSpa.getId());
	}
}
