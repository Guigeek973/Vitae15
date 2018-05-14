package spa;

import java.util.Date;

import hotel.Client;
import hotel.Reservation;

public class ReservationSpa extends Reservation {
	PrestationSpa prestation;
	
	public ReservationSpa(int id, Client client, Date startDate, PrestationSpa prestation) {
		super(id, client, startDate);
		this.prestation = prestation;
	}

	public PrestationSpa getPrestation() {
		return prestation;
	}
	public void setPrestation(PrestationSpa prestation) {
		this.prestation = prestation;
	}
	
	
}
