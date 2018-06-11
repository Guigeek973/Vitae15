package spa;

import java.util.Date;

import hotel.Client;
import hotel.Reservation;
import main.Connection;

public class ReservationSpa extends Reservation {
	private int id;
	PrestationSpa prestation;
	
	public ReservationSpa(Client client, Date startDate, PrestationSpa prestation) {
		super(client, startDate);
		this.prestation = prestation;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public PrestationSpa getPrestation() {
		return prestation;
	}
	public void setPrestation(PrestationSpa prestation) {
		if (this.prestation != prestation) {
			this.prestation = prestation;
			Connection.execSQL("UPDATE reservationspa SET id_Prestation = " + this.prestation.getId() + " WHERE id = " + this.getId());
		}
	}
}