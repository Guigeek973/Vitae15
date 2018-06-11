package spa;

import java.util.Date;

import hotel.Client;
import hotel.Reservation;
import main.Connection;

public class ReservationSpa extends Reservation {
	PrestationSpa prestation;
	
	public ReservationSpa(int id, Client client, Date startDate, PrestationSpa prestation) {
		super(client, startDate);
		this.prestation = prestation;
	}

	public PrestationSpa getPrestation() {
		return prestation;
	}
	public void setPrestation(PrestationSpa prestation) {
		if (this.prestation != prestation) {
			this.prestation = prestation;
			Connection.execSQL("UPDATE Menu SET id_Prestation = '" + this.prestation.getId() + "'");
		}
	}
	
	
}
