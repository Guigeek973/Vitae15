package hotel;

import java.util.Date;

public class Reservation {
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
	public Reservation(Client client, Date startDate) {
		super();
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
	public void setId(int id) {
		this.id = id;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public void setModified_at(Date modified_at) {
		this.modified_at = modified_at;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public void setStatut(STATUT_RESERVATION statut) {
		this.statut = statut;
	}
	
	
}
