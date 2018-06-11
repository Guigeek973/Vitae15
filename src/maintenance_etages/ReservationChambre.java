package maintenance_etages;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import hotel.Client;
import hotel.Reservation;
import main.Connection;

public class ReservationChambre extends Reservation {
	private int id;
	private List<Chambre> lesChambres;
	private Date endDate;
	
	public ReservationChambre(Client client, Date startDate, Date endDate) {
		super(client, startDate);
		this.endDate = endDate;
	}
	
	public int getId() {
		int id = 0;
		try {
			id = Connection.getResultSetSQL(
					"SELECT id FROM reservationroom "
					+ "WHERE id_Reservation = " + super.getId()
					+ " AND endDate = " + this.endDate).getInt(1);
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

	public List<Chambre> getLesChambres() {
		return lesChambres;
	}
	public Chambre getChambre(int id) {
		Chambre chambreReturn = null;
		for (Chambre chambre : this.lesChambres) {
			if (chambre.getId() == id) {
				chambreReturn = this.lesChambres.get(chambre.getId());
			}
		}
		return chambreReturn;
	}
	public Date getEndDate() {
		return endDate;
	}
	
	public void setEndDate(Date endDate) {
		if (this.endDate != endDate) {
			this.endDate = endDate;
			Connection.execSQL("UPDATE reservationroom SET endDate = '" + this.endDate + "'");
		}
	}
	
	public void setLesChambres(List<Chambre> lesChambres) {
		Connection.execSQL("DELETE FROM avoirchambresdansreservation WHERE id = " + this.getId());
		ajoutChambre(lesChambres);
	}
	
	public void ajoutChambre(List<Chambre> lesChambres) {
		for(Chambre chambre : lesChambres) {
			ajoutChambre(chambre);
		}
	}
	public void ajoutChambre(Chambre chambre) {
		this.lesChambres.add(chambre);
		Connection.execSQL("INSERT INTO avoirchambresdansreservation VALUES (" + this.getId() + "," + this.getId() + "," + chambre.getId() + ")");
	}
	public void supprimerChambre(List<Chambre> lesChambres) {
		for(Chambre chambre : lesChambres) {
			supprimerChambre(chambre);
		}
	}
	public void supprimerChambre(Chambre chambre) {
		this.lesChambres.remove(chambre);
		Connection.execSQL("DELETE FROM avoirchambresdansreservation WHERE id_Room = " + chambre.getId());
	}
}