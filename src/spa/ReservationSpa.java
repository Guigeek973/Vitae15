package spa;

import java.sql.SQLException;
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
		int id = 0;
		try {
			id = Connection.getResultSetSQL(
					"SELECT id FROM reservationspa "
					+ "WHERE id_Reservation = " + super.getId()
					+ " AND startDate = " + super.getStartDate() + this.prestation.getDuree()
					+ " AND id_Prestation = " + this.prestation.getId()).getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setId(id);
		return this.id;
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