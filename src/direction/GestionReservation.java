package direction;

import java.util.Date;
import java.util.List;

import hotel.Client;
import hotel.Reservation;
import maintenance_etages.Chambre;
import maintenance_etages.ReservationChambre;
import restaurant.ReservationRestaurant;
import restaurant.ServiceTable;
import spa.PrestationSpa;

public class GestionReservation {
	private List<Reservation> lesReservations;
	
	public void prendreReservation(Client client, Date startDate, Date endDate, List<Chambre> lesChambres) {
		
		int idReservationResto = 0;
		ReservationChambre resa = new ReservationChambre(idReservationResto, client, startDate, endDate);
	}
	public void prendreReservation(Client client, Date startDate, int nbCouverts, ServiceTable service) {
		
	}
	public void prendreReservation(Client client, Date startDate, PrestationSpa prestation) {
		
	}
	public void deleteReservation(Reservation reservation) {
		
	}
	public void modifierReservation(Client client, Date startDate, Date endDate, List<Chambre> lesChambres) {
		
	}
	public void modifierReservation(Client client, Date startDate, int nbCouverts, ServiceTable service) {
		
	}
	public void modifierReservation(Client client, Date startDate, PrestationSpa prestation) {
		
	}
}
