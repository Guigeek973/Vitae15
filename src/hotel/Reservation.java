package hotel;

import java.util.Date;

import main.Connection;

public abstract class Reservation {
	private int id;
	private Client client;
	private Date created_at;
	private Date modified_at;
	private Date startDate;
	private STATUT_RESERVATION statut;
	public enum STATUT_RESERVATION {
		EN_COURS,
		VALIDE
	}
	public Reservation(int id, Client client, Date startDate) {
		super();
		this.id = id;
		this.client = client;
		this.startDate = startDate;
		this.statut = STATUT_RESERVATION.EN_COURS;
	}
	public int getId() {
		return id;
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
			Connection.execSQL("UPDATE reservation SET id_Client = " + this.client.getId());
		}
	}
	public void setCreated_at(Date created_at) {
		if (this.created_at != created_at) {
			this.created_at = created_at;
			Connection.execSQL("UPDATE reservation SET created_at = '" + this.created_at + "'");
		}
	}
	public void setModified_at(Date modified_at) {
		if (this.modified_at != modified_at) {
			this.modified_at = modified_at;
			Connection.execSQL("UPDATE reservation SET modified_at = '" + this.modified_at + "'");
		}
	}
	public void setStartDate(Date startDate) {
		if (this.startDate != startDate) {
			this.startDate = startDate;
			Connection.execSQL("UPDATE reservation SET startDate = '" + this.startDate + "'");
		}
	}
	public void setStatut(STATUT_RESERVATION statut) {
		if (this.statut != statut) {
			this.statut = statut;
			Connection.execSQL("UPDATE reservation SET status = '" + this.statut + "'");
		}
	}
	
	
}
