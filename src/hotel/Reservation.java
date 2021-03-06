package hotel;

import java.sql.SQLException;
import java.util.Date;

import main.Connection;

public abstract class Reservation {
	protected int id;
	protected Client client;
	protected Date created_at;
	protected Date modified_at;
	protected Date startDate;
	protected STATUT_RESERVATION statut;
	public enum STATUT_RESERVATION {
		EN_COURS,
		VALIDE
	}
	public Reservation(int id) {
		super();
	}
	
	public Reservation(Client client, Date startDate) {
		super();
		this.client = client;
		this.startDate = startDate;
		this.statut = STATUT_RESERVATION.EN_COURS;
	}
	public int getId() {
		int id = 0;
		try {
			id = Connection.getResultSetSQL(
					"SELECT id FROM reservation "
					+ "WHERE reservation.id_Client = " + this.client 
					+ " AND startDate = " + this.startDate + " AND created_at = " 
					+ this.created_at + " AND updated_at = " + this.modified_at
					+ " AND status = " + this.statut).getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return this.id;
	}

	public Client getClient() {
		return client;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public Date getModified_at() {
		return modified_at;
	}
	public Date getStartDate() {
		return startDate;
	}
	public STATUT_RESERVATION getStatut() {
		return statut;
	}

	
	
	public void setClient(Client client) {
		if (this.client != client) {
			this.client = client;
			Connection.execSQL("UPDATE reservation SET id_Client = " + client.getId());
		}
	}
	public void setCreated_at(Date created_at) {
		if (this.created_at != created_at) {
			this.created_at = created_at;
			Connection.execSQL("UPDATE reservation SET created_at = '" + created_at + "'");
		}
	}
	public void setModified_at(Date modified_at) {
		if (this.modified_at != modified_at) {
			this.modified_at = modified_at;
			Connection.execSQL("UPDATE reservation SET modified_at = '" + modified_at + "'");
		}
	}
	public void setStartDate(Date startDate) {
		if (this.startDate != startDate) {
			this.startDate = startDate;
			Connection.execSQL("UPDATE reservation SET startDate = '" + startDate + "'");
		}
	}
	public void setStatut(STATUT_RESERVATION statut) {
		if (this.statut != statut) {
			this.statut = statut;
			Connection.execSQL("UPDATE reservation SET status = '" + statut + "'");
		}
	}
	
	
}
