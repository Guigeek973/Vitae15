package maintenance_etages;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import hotel.Client;
import hotel.Reservation;
import main.Connection;

public class ReservationChambre extends Reservation {
	private int id;
	private static List<Chambre> lesChambres;
	private Date endDate;
	
	public ReservationChambre(int id, Client client, Date startDate, Date endDate) { 
		super(client, startDate);
		this.endDate = endDate;
	}
	
	public ReservationChambre(Client client, Date startDate, Date endDate) { //insert row in BDD and in listChambres
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

		return this.id;
	}


	public int getIdReservation() {
		int id = 0;
		try {
			id = Connection.getResultSetSQL(
					"SELECT id_Reservation FROM reservationroom "
					+ "WHERE id = " + this.getId()).getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return id;
	}
	public Date getStartDate() {
		Date id = null;
		try {
			id = Connection.getResultSetSQL(
					"SELECT startDate FROM reservationroom JOIN reservation ON id_Reservation = reservation.id"
					+ " WHERE reservationroom.id = " + this.getId()).getDate(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return id;
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
			Connection.execSQL("UPDATE reservationroom SET endDate = '" + endDate + "'");
		}
	}
	
	public void setLesChambres(List<Chambre> lesChambres) {
		Connection.execSQL("DELETE FROM avoirchambresdansreservation WHERE id = " + this.getId());
		this.lesChambres.clear();
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