package maintenance_etages;

import java.util.Date;
import java.util.List;

import hotel.Client;
import hotel.Reservation;
import main.Connection;
import stock.ArticleRestaurant;

public class ReservationChambre extends Reservation {
	private List<Chambre> lesChambres;
	private Date endDate;
	
	public ReservationChambre(int id, Client client, Date startDate, List<Chambre> chambres, Date endDate) {
		super(id, client, startDate);
		this.lesChambres = chambres;
		this.endDate = endDate;
	}

	public List<Chambre> getLesChambres() {
		return lesChambres;
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
		this.lesChambres = lesChambres;
		for(Chambre chambre : lesChambres) {
			Connection.execSQL("INSERT INTO avoirchambresdansreservation VALUES (" + this.getId() + ", " + chambre.getId() + ")");
		}
	}
	
	public void ajoutChambre(List<Chambre> lesChambres) {
		for(Chambre chambre : lesChambres) {
			this.lesChambres.add(chambre);
			Connection.execSQL("INSERT INTO avoirchambresdansreservation VALUES (" + this.getId() + ", " + chambre.getId() + ")");
		}
	}
	public void ajoutChambre(Chambre chambre) {
		this.lesChambres.add(chambre);
		Connection.execSQL("INSERT INTO avoirchambresdansreservation VALUES (" + this.getId() + ", " + chambre.getId() + ")");
	}
	public void supprimerChambre(Chambre chambre) {
		this.lesChambres.remove(chambre);
		Connection.execSQL("DELETE FROM avoirchambresdansreservation WHERE id_Room = " + chambre.getId());
	}
		
	
}
